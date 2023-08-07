<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/auswahlViewCSS.css"/>
<title>Stadtguide</title>
</head>
<body>
<jsp:useBean id="ab" class="stadtGuideBeans.auswahlBean" scope="session"/>
<jsp:useBean id="mb" class="stadtGuideBeans.messageBean" scope="session"/>
	<br>
	<br>
	<br>
	<br>
	<br>

	<form action="../applications/auswahlAppl.jsp" method="get">
		<table>
			<tr>
				<td id="guide" colspan="2">
					Dein Opensource Stadtguide
				</td>
			</tr>
			<tr>
				<td id="message" colspan="2" align="center">
					Bitte w�hle eine Stadt oder lege eine neue an
					<%-- <jsp:getProperty name="mb" property="message" /> --%>
				</td>
			</tr>
			<tr>
				<td align="center">
					<select name="gewaehlteStadt">
						<option>Ausw�hlen</option>
						<option>Ludwigshafen</option>
						<option>Mannheim</option>
						<option>Kaiserslautern</option>
					</select>
				</td>
				<td align="center">
					<input type="text" name="newCityName" value="">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" name="confirmBttn" value="Best�tigen">
				</td>
				<td align="center">
					<input type="submit" name="addNewBttn" value="Neue Stadt anlegen">
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