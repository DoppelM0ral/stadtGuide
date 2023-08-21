<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addToStadtViewCSS.css"/>
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
<form action="../applications/addKulturAppl.jsp" method="get">
		<table>
			<tr>
				<td id="guide" colspan="2">
					Dein Opensource Stadtguide
				</td>
			</tr>
			<tr>
				<td id="message" colspan="2" align="center">
					Bitte lege ein neue kulturelle Unterhaltung an
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
					<input type="text" name="newCultName" value="">
				</td>
				<td align="center">
					<input type="text" name="newCultAdress" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					Welche Art der Kulturunterhaltung?
				</td>
				<td align="center">
					Preis:
				</td>
			</tr>
			<tr>
				<td align="center">
					<select id="addToCult" name="addToCult" onclick="getSonstigesFeld()">
						<option value="museum">Museum</option>
						<option value="historisch">Historischer Platz</option>
						<option value="tour">Tour</option>
						<option value="sehenswuerdigkeit">Sehensw&uuml;rdigkeit</option>
						<option value="showTextFeld">Sonstiges</option>
					</select><br><br>
					<input type="text" id="mySonstigesText" style= "visibility: hidden;">
				</td>
				<td align="center">
					<input type="text" name="newCultPrice" value="">
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