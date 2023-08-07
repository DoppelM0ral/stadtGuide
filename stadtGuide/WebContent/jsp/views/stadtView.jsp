<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/stadtViewCSS.css"/>
<title>Insert title here</title>
</head>
<body>
<form action="../applications/stadtAppl.jsp" method="get">
	<table>
		<tr>
			<td id="guide" colspan="2">
				Dein Opensource Stadtguide
			</td>
		</tr>
		
		<tr>
			<td><h2>Ihre ausgew&auml;hlte Stadt:</h2></td>
		</tr>
		<tr>
			<td>M&ouml;chten Sie noch was hinzuf&uuml;gen?</td>
		</tr>
		<tr>
			<td>
				Was bevorzugen Sie in einem Restaurant?
			</td>
		</tr>
		<tr>
			<td>
				<select name="ernaehrung">
					<option value="alles">Alles-Esser</option>
					<option value="pescetarier">Pescetarier</option>
					<option value="vegetarisch">Vegetarisch</option>
					<option value="vegan">Vegan</option>
					<option value="glutenfrei">Glutenfrei</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
			Welche Art von Unterkunft suchen Sie?
			</td>
		</tr>
		<tr>
			<td>
				<select name="unterkunft">
					<option value="hotel">Hotel</option>
					<option value="wohnung">Ferienwohnung</option>
					<option value="airbnb">AirBnB</option>
				</select>
			</td>
		</tr>
		<tr>
				<td align="center">
					<input type="submit" name="confirmBttn" value="Auswaehlen">
				</td>
				<td align="center">
					<input type="submit" name="newAddOnBttn" value="Neu anlegen">
				</td>
			</tr>
	</table>
</form>
</body>
</html>