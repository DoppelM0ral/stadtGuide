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
<form action="../applications/addAktivitaetAppl.jsp" method="get">
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
					<input type="text" name="newActivName" value="">
				</td>
				<td align="center">
					<input type="text" name="newActivAdress" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					Welche Art der Aktivit&auml;t?
				</td>
				<td align="center">
					Preis:
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="text" name="newActivity" value="">
				</td>
				<td align="center">
					<input type="text" name="newActivPrice" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" name="confirmBttn" value="Bestaetigen">
				</td>
				<td align="center">
					<input type="submit" name="returnBttn" value="Zurueck">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>