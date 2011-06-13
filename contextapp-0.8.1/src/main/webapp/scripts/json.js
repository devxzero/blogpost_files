/**
 * json.js:
 * This file defines functions JSON.parse() and JSON.serialize()
 * for decoding and encoding JavaScript objects and arrays from and to
 * application/json format.
 * 
 * The JSON.parse() function is a safe parser: it uses eval() for
 * efficiency but first ensures that its argument contains only legal
 * JSON literals rather than unrestricted JavaScript code.
 *
 * This code is derived from the code at http://www.json.org/json.js
 * which was written and placed in the public domain by Douglas Crockford.
 **/
// This object holds our parse and serialize functions
var JSON = {}; 

// The parse function is short but the validation code is complex.
// See http://www.ietf.org/rfc/rfc4627.txt
JSON.parse = function(s) {
    try {
        return !(/[^,:{}\[\]0-9.\-+Eaeflnr-u \n\r\t]/.test(
                                   s.replace(/"(\\.|[^"\\])*"/g, ''))) &&
            eval('(' + s + ')');
    }
    catch (e) {
        return false;
    }
};

// Our JSON.serialize() function requires a number of helper functions.
// They are all defined within this anonymous function so that they remain
// private and do not pollute the global namespace.
(function () {
    var m = {  // A character conversion map
            '\b': '\\b', '\t': '\\t',  '\n': '\\n', '\f': '\\f',
            '\r': '\\r', '"' : '\\"',  '\\': '\\\\'
        },
        s = { // Map type names to functions for serializing those types
            'boolean': function (x) { return String(x); },
            'null': function (x) { return "null"; },
            number: function (x) { return isFinite(x) ? String(x) : 'null'; },
            string: function (x) {
                if (/["\\\x00-\x1f]/.test(x)) {
                    x = x.replace(/([\x00-\x1f\\"])/g, function(a, b) {
                        var c = m[b];
                        if (c) {
                            return c;
                        }
                        c = b.charCodeAt();
                        return '\\u00' +
                            Math.floor(c / 16).toString(16) +
                            (c % 16).toString(16);
                    });
                }
                return '"' + x + '"';
            },
            array: function (x) {
                var a = ['['], b, f, i, l = x.length, v;
                for (i = 0; i < l; i += 1) {
                    v = x[i];
                    f = s[typeof v];
                    if (f) {
                        v = f(v);
                        if (typeof v == 'string') {
                            if (b) {
                                a[a.length] = ',';
                            }
                            a[a.length] = v;
                            b = true;
                        }
                    }
                }
                a[a.length] = ']';
                return a.join('');
            },
            object: function (x) {
                if (x) {
                    if (x instanceof Array) {
                        return s.array(x);
                    }
                    var a = ['{'], b, f, i, v;
                    for (i in x) {
                        v = x[i];
                        f = s[typeof v];
                        if (f) {
                            v = f(v);
                            if (typeof v == 'string') {
                                if (b) {
                                    a[a.length] = ',';
                                }
                                a.push(s.string(i), ':', v);
                                b = true;
                            }
                        }
                    }
                    a[a.length] = '}';
                    return a.join('');
                }
                return 'null';
            }
        };

    // Export our serialize function outside of this anonymous function
    JSON.serialize = function(o) { return s.object(o); };
})(); // Invoke the anonymous function once to define JSON.serialize()