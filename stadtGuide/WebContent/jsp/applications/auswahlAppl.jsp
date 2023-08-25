<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application</title>
</head>
<body>

	This shouldnt be possible :)
	Gotta work on that
	
		<%
		//Übergabe der Parameter
		String gewaehlteStadt = request.getParameter("gewaehlteStadt");
		String confirmBttn = request.getParameter("confrimBttn");
		String newCityName = request.getParameter("newCityName");
		String addNewBttn = request.getParameter("addNewBttn");
		
		//NullCheck und Aufbereitung der parameter
		if (gewaehlteStadt == null){
			gewaehlteStadt = "";}
		if (confirmBttn == null){
			confirmBttn = "";}
		if (newCityName == null){
			newCityName = "";}
		if (addNewBttn == null){
			addNewBttn = "";}
		
		//Application
		if (confirmBttn.equals("Bestaetigen")){
			response.sendRedirect("../views/stadtView.jsp");}
		else if (addNewBttn.equals("Neue Stadt anlegen")){
			response.sendRedirect("../views/addStadtView.jsp");}
		else{
			response.sendRedirect("../views/auswahlView.jsp");}
		%>

</body>
</html>