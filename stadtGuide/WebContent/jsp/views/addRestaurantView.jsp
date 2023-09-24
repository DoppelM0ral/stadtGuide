<%@page import="stadtGuideBeans.messageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addToStadtViewCSS.css"/>
<title>Restaurant anlegen</title>
</head>
<body>
<jsp:useBean id="mb" class="stadtGuideBeans.messageBean" scope="session"/>
	<br>
	<br>
	<br>
	<br>
	<br>
<form action="../applications/addRestaurantAppl.jsp" method="get">
		<table>
			<tr>
				<td id="guide" colspan="2">
					Dein Opensource Stadtguide
				</td>
			</tr>
			<tr>
				<td id="message" colspan="2" align="center">
					<jsp:getProperty name="mb" property="addRestaurantText"/>
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
					<input type="text" name="newRestName" value="">
				</td>
				<td align="center">
					<input type="text" name="newRestAdresse" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					Was trifft auf das Restaurant zu?
				</td>
				<td align="center">
					Preisklasse?
				</td>
			</tr>
			<tr>
				<td id="cc">
					<label><input type="checkbox" name="vegan" value="true" />Vegan<br></label>
					<label><input type="checkbox" name="vegetarisch" value="true" />Vegetarisch<br></label>
					<label><input type="checkbox" name="halal" value="true" />Halal<br></label>
					<label><input type="checkbox" name="pescetarisch" value="true" />Pescetarisch<br></label>
					<label><input type="checkbox" name="glutenfrei" value="true" />Glutenfrei<br></label>
				</td>
				<td align="center">
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