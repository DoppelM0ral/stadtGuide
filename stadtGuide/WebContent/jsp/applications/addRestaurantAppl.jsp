<%@page import="stadtGuideBeans.restaurantBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
</head>
<body>
<jsp:useBean id="restB" class="stadtGuideBeans.restaurantBean" scope="session"/>
<%
	String newRestName = request.getParameter("newRestName");
	String newRestAdresse = request.getParameter("newRestAdresse");
	String newRestFood = request.getParameter("newRestName");
	String nourish = request.getParameter("nourish");
	String restPreis = request.getParameter("restPreis");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	if(confirmBttn == null){confirmBttn = "";}
	if(returnBttn == null){returnBttn = "";}
	
	if(confirmBttn.equals("Bestaetigen")){
		restB.setNewRestName(newRestName);
		restB.setNewRestAdresse(newRestAdresse);
		restB.setNourish(nourish);
		restB.setRestPreis(restPreis);
		restB.restaurantAnlegen();
		response.sendRedirect("../views/stadtView.jsp");
	}else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");
	}else{
		response.sendRedirect("../views/addToStadtView.jsp");
	}
%>
</body>
</html>