contextfw = {
	handle:     null,
	updateUrl:  null,
	refreshUrl: null,
	removeUrl:  null,

	init: function(context, handle) {
		this.handle = handle;
		this.updateUrl = context + "/contextfw-update/"+handle;
		this.refreshUrl = context + "/contextfw-refresh/"+handle;
		this.removeUrl = context + "/contextfw-remove/"+handle;
		this.refresh();
		setInterval(function() {contextfw.refresh()}, 1000*30);
	},

	refresh: function() {
		jQuery.get(this.refreshUrl, null);
	},

	unload: function() {
		jQuery.get(this.removeUrl);
	},

	call: function(elId, method) {

		var params = {}

		for(var i=2; i< arguments.length; i++) {
	      if (arguments[i] != null && typeof(arguments[i]) == "object") {
	    	  params["p"+(i-2)] = JSON.serialize(arguments[i]);
	      }
	      else {
	    	  params["p"+(i-2)] = arguments[i];
	      }
		}

		jQuery.post(this.updateUrl+"/"+elId+"/"+method, params, function(data, textStatus) {
			contextfw._handleResponse(data);
	    }, "text");
	},

	_parseUpdate: function(data, tagName, callback) {
		  var current = data;
		  var pattern = new RegExp("<"+tagName+"(\\s+?.*?)?>");
		  var sIndex = current.search(pattern);
		  var startTagName = "<"+tagName;
		  var endTagName = "</"+tagName+">";
		  while (sIndex > 0) {
			  current = current.substring(sIndex);
			  fTagStart = current.indexOf(startTagName);
			  fTagEnd = current.indexOf(">");
			  endTag = current.indexOf(endTagName);
			  attrData = current.substring(fTagStart+startTagName.length, fTagEnd)

			  attributes = attrData.match(/\S+\s*?=\s*?".*?"/g);

			  attr = {};

			  if (attributes != undefined) {
			    for (i = 0; i < attributes.length; i++) {
					splits = attributes[i].split("=", 2);
					key = this._trim(splits[0]);
					value = this._trim(splits[1]);
					value = value.substr(1, value.length - 2);
					attr[key] = value;
				}
		      }

			  data = current.substring(fTagEnd+1, endTag);
			  current = current.substring(fTagEnd+endTagName.length);
			  sIndex = current.search(pattern);

		      callback(attr, data);
		  }
	  },

	  _trim: function(value) {
		  return value.replace(/^\s*/, "").replace(/\s*$/, "");
	  },

	_handleResponse: function(domDocument) {

		this._parseUpdate(domDocument, "replace", function(attr, data) {
			try {
			  jQuery("#"+ attr.id).replaceWith(data);
			}
			catch(err) {
				// Just ignore
			}
		});

		this._parseUpdate(domDocument, "replaceInner", function(attr, data) {
			try {
			  jQuery("#"+ attr.id).html(data);
			}
			catch(err) {
				// Just ignore
			}
		});

		this._parseUpdate(domDocument, "script", function(attr, script) {
			script = script.replace(/&gt;/g, '>');
			script = script.replace(/&lt;/g, '<');
			script = script.replace(/&amp;/g, '&');
			eval(script);
		});
	},

	_replaceInner: function replaceInner(id, html, mode) {
		try {
			if (mode == "fade") {
				jQuery(id).fadeOut("fast", function() {
					jQuery(id).html(html);
					jQuery(id).fadeIn("fast");
				});
			}
			else {
				jQuery(id).html(html);
			}
		}
		catch(err) {
			//alert(err);
		}
	},

	_handleScripts: function(domDocument) {
		nodes = domDocument.selectNodes("//script");
		if (nodes.length > 0) {
			for (c = 0; c < nodes.length; c++) {
				txt = this._toHtml(nodes[c]);
				txt = txt.replace(/&gt;/g, '>');
				txt = txt.replace(/&lt;/g, '<');
				txt = txt.replace(/&amp;/g, '&');
				eval(txt);
			}
		}
	}
};

/**
 * Serializes a form to json. If the name of form value ends with
 * "[]" then that is considered an array, thus allowing multiple values.
 * The string "[]" is stripped
 */
jQuery.fn.formToObject = function() {
  var o = {};
  var a = this.serializeArray();
  jQuery.each(a, function() {
  	if (this.name.match("\\[\\]$")=="[]") {
  	  var name = this.name.substr(0, this.name.length-2);
      if (!o[name]) {
        o[name] = [];
      }
      o[name].push(this.value || '');
  	}
  	else {
      o[this.name] = this.value || '';
  	}
  });
  return o;
};