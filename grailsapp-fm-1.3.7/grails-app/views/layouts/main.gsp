<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link href="${createLinkTo(dir:'', file:'default.css')}" media="screen" rel="stylesheet" type="text/css" />
				
		<title><g:layoutTitle default="Grails" /></title>
        <g:layoutHead />
	</head>
	<body>
		<div id="maincontainer">
			<div id="topsection">
				<div class="innertube"><h1>Company Title .....</h1></div>
			</div>
			<div id="contentwrapper">
				<div id="contentcolumn">
					
					<!-- Page name needs to be injected -->
					<div><h2>${pageName}</h2></div>
					<div class="innertube">
					
						<g:layoutBody />
						
					</div>
				</div>
			</div>

			<div id="leftcolumn">
				<div class="innertube">
					<h3>Side bar.....</h3>
				</div>
			</div>

			<div id="footer">footer.....</div>
		</div>
	</body>
</html>