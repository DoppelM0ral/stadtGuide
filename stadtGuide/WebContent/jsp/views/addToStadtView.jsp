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
						<select name="Restaurants" multiple size="2" text-align="center">
							<option value="restaurant1">Restaurant 1</option>
							<option value="restaurant2">Restaurant 2</option>
						</select>
						
					</td>
					<td>
						<select name="Museen" multiple size="2">
							<option value="museum1">Museum 1</option>
							<option value="museum2">Museum 2</option>
						</select>
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
						<select name="Unterkuenfte" multiple size="2">
							<option value="unterkuenft1">Unterkunft 1</option>
							<option value="unterkunft2">Unterkunft 2</option>
						</select>
					</td>
					<td>
						<select name="Aktivitaeten" multiple size="2">
							<option value="aktivitaet1">Aktivitaet 1</option>
							<option value="aktivitaet2">Aktivitaet 2</option>
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