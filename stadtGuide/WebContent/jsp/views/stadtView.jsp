<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/auswahlViewCSS.css"/>
<title>Insert title here</title>
</head>
<body>

<h2>Ihre ausgew&auml;hlte Stadt:</h2>


M&ouml;chten Sie noch was hinzuf&uuml;gen?
<form>
	<table>
	<tr>
	<td>
		Was bevorzugen Sie in einem Restaurant?
	</td>
	<td>
		Welche Art von Unterkunft suchen Sie?
	</td>
	</tr>
	<tr>
	<td>
	<select name="ernaehrung" multiple size="5">
		<option value="alles">Alles-Esser</option>
		<option value="pescetarier">Pescetarier</option>
		<option value="vegetarisch">Vegetarisch</option>
		<option vallue="vegan">Vegan</option>
		<option value="glutenfrei">Glutenfrei</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>
	<select name="unterkunft" multiple size="3">
		<option value="hotel">Hotel</option>
		<option value="wohnung">Ferienwohnung</option>
		<option value="airbnb">AirBnB</option>
	</select>
	</td>
	</tr>
	</table>
</form>

</body>
</html>