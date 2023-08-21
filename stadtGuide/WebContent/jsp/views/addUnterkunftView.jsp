<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addToStadtViewCSS.css"/>
<title>Um Unterkunft erweitern</title>
</head>
<body>
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
					Bitte lege eine neue Unterkunft an
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
					<input type="text" name="newStayAdress" value="">
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
					<select name="addToStay">
						<option value="hotel">Hotel</option>
						<option value="airbnb">AirBnB</option>
						<option value="ferienwohnung">Ferienwohnung</option>
					</select>
				</td>
				<td id="cc">
					<label><input type="checkbox" name="stayPreis" value="" />0-50<br></label>
					<label><input type="checkbox" name="stayPreis" value="" />50-100<br></label>
					<label><input type="checkbox" name="stayPreis" value="" />100-200<br></label>
					<label><input type="checkbox" name="stayPreis" value="" />200-300<br></label>
					<label><input type="checkbox" name="stayPreis" value="" />>300<br></label>
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