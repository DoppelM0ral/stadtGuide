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
<form action="../applications/addRestaurantAppl.jsp" method="get">
		<table>
			<tr>
				<td id="guide" colspan="2">
					Dein Opensource Stadtguide
				</td>
			</tr>
			<tr>
				<td id="message" colspan="2" align="center">
					Bitte lege ein neues Restaurant an
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
					<input type="text" name="newRestAdress" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					Welche Art der Küche?
				</td>
				<td align="center">
					Was trifft auf das Restaurant zu?
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="text" name="newRestFood" value="">
				</td>
				<td id="cc">
					<label><input type="checkbox" name="nourish" value="" />Vegan<br></label>
					<label><input type="checkbox" name="nourish" value="" />Vegetarisch<br></label>
					<label><input type="checkbox" name="nourish" value="" />Pescetarisch<br></label>
					<label><input type="checkbox" name="nourish" value="" />Glutenfrei<br></label>
					<label><input type="checkbox" name="nourish" value="" />Halal<br></label>
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