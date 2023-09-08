<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="../../js/stadtViewJS.js"></script>
<link type="text/css" rel="stylesheet" href="../../css/stadtViewCSS.css"/>
<title>Stadt</title>
</head>
<body>
<jsp:useBean id="sb" class="stadtGuideBeans.stadtBean" scope="session"/>
	<br>
	<br>
	<br>
	<br>
	<br>
<form action="../applications/stadtAppl.jsp" method="get">
		<table id="main">
			<tr>
				<td id="guide" colspan="2">
					Dein Opensource Stadtguide
				</td>
			</tr>
			<tr>
				<td id="message" colspan="2" align="center">
					Die Stadt <jsp:getProperty name="sb" property="stadt"/> 
					liegt im Bundesland <jsp:getProperty name="sb" property="stadtLand"/>
					im Kreis <jsp:getProperty name="sb" property="stadtKreis"/>
			 		und hat die Postleitzahl <jsp:getProperty name="sb" property="stadtPLZ"/>.				</td>
			</tr>
			
			<tr>
				<td  id="main" colspan="2">
				<table>
			<tr>
				<td width="20%">
					Was suchen sie?<br>
							<select name="gesucht" onChange="showOption(this)">
								<option value="">Auswählen</option>
								<option value="restaurant">Restaurant</option>
								<option value="unterkunft">Unterkunft</option>
								<option value="kultur">Kultur</option>
								<option value="aktivitaet">Aktivität</option>
							</select>
				</td>
				<td width="70%">
					<jsp:getProperty property="hiddenRestaurant" name="sb"/>
					<jsp:getProperty property="hiddenUnterkunft" name="sb"/>
					<jsp:getProperty property="hiddenKultur" name="sb"/>
					<jsp:getProperty property="hiddenAktivitaet" name="sb"/>

				</td>
				<td width="10%">
					<input type="submit" name="searchBttn" value="suchen">
				</td>
			</tr>
			<tr>
				<td  id="main" colspan="2">
						Hier kommt die liste der Möglichkeiten anhand der suchoptionen hin
			 	</td>
			</tr>

			
			
		</table>
				</td>
			</tr>
			<tr>
				<td align="center" width="50%">
					<input type="submit" name="returnBttn" value="Zurueck">
				</td>
				<td align="center">
					<input type="submit" name="addToBttn" value="Stadt erweitern">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
