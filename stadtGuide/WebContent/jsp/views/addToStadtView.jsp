<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
			<table>
				<tr>
					<td id="guide" colspan="2">
						Dein Opensource Stadtguide
					</td>
				</tr>
				<tr>
					<td id="message" colspan="2" align="center">
						Was m&ouml;chten Sie zu Ihrer Stadt dazu w&auml;hlen
					</td>
				</tr>
				<tr>
					<td align="center">
						Restaurants:
					</td>
					<td align="center">
						Historische Pl&auml;tze & Museen:
					</td>
				</tr>
				<tr>
					<td>
						<label><input type="checkbox" name="restaurant" value="m" />&nbsp;Restaurant<br></label>
						<label><input type="checkbox" name="restVegeta" value="m" />&nbsp;Vegetarisches Restaurant<br></label>
						<label><input type="checkbox" name="restVegan" value="m" />&nbsp;Vegane Restaurant<br></label>
					</td>
					<td>
						<label><input type="checkbox" name="hist" value="m" />Museum<br></label>
					</td>
				</tr>
				<tr>
					<td align="center">
						Unterk&uuml;nfte:
					</td>
					<td align="center">
						Aktivit&auml;ten:
					</td>
				</tr>
				<tr>
					<td>
						<label><input type="checkbox" name="restVegan" value="m" />Hotel<br></label>
						<label><input type="checkbox" name="restVegan" value="m" />Ferienwohnung<br></label>
					</td>
					<td>
						<label><input type="checkbox" name="aktiv" value="m" />Aktivitaet<br></label>
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