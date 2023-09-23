<%@page import="stadtGuideBeans.messageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addToStadtViewCSS.css"/>
<title>Unterkunft anlegen</title>
</head>
<body>
<jsp:useBean id="mb" class="stadtGuideBeans.messageBean" scope="session"/>
	<br>
	<br>
	<br>
	<br>
	<br>
<form action="../applications/addUnterkunftAppl.jsp" method="get">
		<table>
			<tr>
				<td id="guide" colspan="2">
					Dein Opensource Stadtguide
				</td>
			</tr>
			<tr>
				<td id="message" colspan="2" align="center">
					<jsp:getProperty name="mb" property="addUnterkunftText"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					Name:
				</td>
				<td align="center">
					Adresse:
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="text" name="newStayName" value="">
				</td>
				<td align="center">
					<input type="text" name="newStayAdresse" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					Welche Art der Unterkunft?
				</td>
				<td align="center">
					Preisklasse:
				</td>
			</tr>
			<tr>
				<td align="center">
					<select name="newStay">
						<option value="hotel">Hotel</option>
						<option value="airbnb">AirBnB</option>
						<option value="ferienwohnung">Ferienwohnung</option>
					</select>
				</td>
				<td id="cc">
					<label><input type="radio" name="guenstig" value="true" />G&uuml;nstig<br></label>
					<label><input type="radio" name="normal" value="true" />Normal<br></label>
					<label><input type="radio" name="teuer" value="true" />Teuer<br></label>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" name="returnBttn" value="Zurueck">
				</td>
				<td align="center">
					<input type="submit" name="confirmBttn" value="Bestaetigen">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>