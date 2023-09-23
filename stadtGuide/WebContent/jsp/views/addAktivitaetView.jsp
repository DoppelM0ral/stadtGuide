<%@page import="stadtGuideBeans.messageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addToStadtViewCSS.css"/>
<script src="/stadtGuide/js/addAktivitaetJS.js"></script>
<title>Aktivit&auml;t anlegen</title>
</head>
<body>
<jsp:useBean id="mb" class="stadtGuideBeans.messageBean" scope="session"/>
	<br>
	<br>
	<br>
	<br>
	<br>
<form action="../applications/addAktivitaetAppl.jsp" method="get">
		<table>
			<tr>
				<td id="guide" colspan="2">
					Dein Opensource Stadtguide
				</td>
			</tr>
			<tr>
				<td id="message" colspan="2" align="center">
					<jsp:getProperty name="mb" property="addAktivitaetText"/>
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
					<input type="text" name="newActivName" value="">
				</td>
				<td align="center">
					<input type="text" name="newActivAdresse" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					Welche Aktivit&auml;t:
				</td>
				<td align="center">
					Preisklasse:
				</td>
			</tr>
			<tr>
				<td align="center">
					<select name="newActivity">
						<option value="sportlich">Sportlich</option>
						<option value="unterhaltung">Unterhaltung</option>
						<option value="bildung">Bildung</option>
					</select>
				</td>
				<td>
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