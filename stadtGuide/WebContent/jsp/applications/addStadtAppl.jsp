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
		String nameStadt = request.getParameter("nameStadt");
		String plzStadt = request.getParameter("plzStadt");
		String bundeslandStadt = request.getParameter("bundeslandStadt");
		String kreisStadt = request.getParameter("kreisStadt");
		String einwohnerStadt = request.getParameter("einwohnerStadt");
	//	String Stadt = request.getParameter("confrimBttn");
		String backBttn = request.getParameter("backBttn");
		String createBttn = request.getParameter("createBttn");
		
		//NullCheck und Aufbereitung der parameter
		if (backBttn == null){
			backBttn = "";}

		
		//Application
		if (backBttn.equals("Zurück zur Auswahl")){
			}
	//	else if (addNewBttn.equals("Neue Stadt anlegen")){
	//		response.sendRedirect("../views/addStadtView.jsp");	}
		else{
			response.sendRedirect("../views/auswahlView.jsp");}
		%>

</body>
</html>