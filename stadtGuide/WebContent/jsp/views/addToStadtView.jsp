<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../../css/addStadtViewCSS.css"/>
<title>Insert title here</title>
</head>
<body>
<form action="../applications/addToStadtAppl.jsp" method="get">
			<table>
				<tr>
					<td id="guide" colspan="2">
						Dein Opensource Stadtguide
					</td>
				</tr>
				<tr>
					<td id="message" colspan="2" align="center">
						Was m&ouml;chten Sie hinzuf&uuml;gen?
					</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
				<select name="addToStadt">
					<option value="restaurant">Restaurant</option>
					<option value="unterkunft">Unterkunft</option>
					<option value="kultur">Kultur</option>
					<option value="aktivitaet">Aktivitaet</option>
				</select>
				</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" name="addBttn" value="Auswaehlen">
					</td>
					<td align="center">
						<input type="submit" name="returnBttn" value="Zurueck">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>