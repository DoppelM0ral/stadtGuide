<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addStadtViewCSS.css"/>
<title>Stadtguide - neue Stadt</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="../applications/addStadtAppl.jsp" method="get">
			<table>
				<tr>
					<td id="guide" colspan="2">
						Dein Opensource Stadtguide
					</td>
				</tr>
				<tr>
					<td id="message" colspan="2" align="center">
						Bitte gebe Informationen über die neue Stadt an
					</td>
				</tr>
				<tr>
					<td align="center">
						Name der Stadt:
					</td>
					<td align="center">
						Postleitzahl:
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="text" name="nameStadt" value="">
					</td>
					<td align="center">
						<input type="text" name="plzStadt" value="">
					</td>
				</tr>
				<tr>
					<td align="center">
						Bundesland:
					</td>
					<td align="center">
						Kreis:
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="text" name="bundeslandStadt" value="">
					</td>
					<td align="center">
						<input type="text" name="kreisStadt" value="">
					</td>
				</tr>
				<tr>
					<td align="center">
						Einwohneranzahl:
					</td>
					<td align="center">
						noch schauen:
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="text" name="einwohnerStadt" value="">
					</td>
					<td align="center">
						<input type="text" name="Stadt" value="">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" name="backBttn" value="Zurück zur Auswahl">
					</td>
					<td align="center">
						<input type="submit" name="createBttn" value="Bestätigen">
					</td>
				</tr>
			</table>
		</form>
		
		<br>
		
		<table id="tips">
			<tr>
				<td>
					Hinweise
				</td>
			</tr>
		</table>
</body>
</html>