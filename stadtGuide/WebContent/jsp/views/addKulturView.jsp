<%@page import="stadtGuideBeans.messageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addToStadtViewCSS.css"/>
<script type="text/javascript" src="../js/addKulturJS.js"></script>
<title>Kultur anlegen</title>
</head>
<body>
<jsp:useBean id="mb" class="stadtGuideBeans.messageBean" scope="session"/>
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
					<jsp:getProperty name="mb" property="addKulturText"/>
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
					Stadt: <input type="text" name="newCultStadt" value=""><br>
					Postleitzahl: <input type="text" name="newCultPlz" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					Kulturunterhaltung:
				</td>
				<td align="center">
					Preisklasse:
				</td>
			</tr>
			<tr>
				<td align="center">
					<select id="newCult" name="newCult">
						<option value="museum">Museum</option>
						<option value="historisch">Historischer Platz</option>
						<option value="tour">Tour</option>
						<option value="sehenswuerdigkeit">Sehensw&uuml;rdigkeit</option>
					</select>
				</td>
				<td align="center">
					<label><input type="radio" name="cultPreis" value="" />G&uuml;nstig<br></label>
					<label><input type="radio" name="cultPreis" value="" />Normal<br></label>
					<label><input type="radio" name="cultPreis" value="" />Teuer<br></label>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" name="returnBttn" value="Zurück">
				</td>
				<td align="center">
					<input type="submit" name="confirmBttn" value="Bestätigen">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>