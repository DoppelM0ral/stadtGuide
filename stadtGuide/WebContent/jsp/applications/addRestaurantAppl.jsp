<%@page import="stadtGuideBeans.stadtBean"%>
<%@page import="stadtGuideBeans.restaurantBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
<script type="text/javascript" src="../js/addKulturJS.js"></script>
</head>
<body>
<jsp:useBean id="restB" class="stadtGuideBeans.restaurantBean" scope="session"/>
<jsp:useBean id="sb" class="stadtGuideBeans.stadtBean" scope="session"/>
<%
	String newRestName = request.getParameter("newRestName");
	String newRestAdresse = request.getParameter("newRestAdresse");
	String veganString = request.getParameter("vegan");
	String vegetarischString = request.getParameter("vegetarisch");
	String halalString = request.getParameter("halal");
	String pescetarischString = request.getParameter("pescetarisch");
	String glutenfreiString = request.getParameter("glutenfrei");
	String guenstigString = request.getParameter("guenstig");
	String normalString = request.getParameter("normal");
	String teuerString = request.getParameter("teuer");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	boolean vegan = Boolean.parseBoolean(veganString);
	boolean vegetarisch = Boolean.parseBoolean(vegetarischString);
	boolean halal = Boolean.parseBoolean(halalString);
	boolean pescetarisch = Boolean.parseBoolean(pescetarischString);
	boolean glutenfrei = Boolean.parseBoolean(glutenfreiString);
	
	boolean guenstig = Boolean.parseBoolean(guenstigString);
	boolean normal = Boolean.parseBoolean(normalString);
	boolean teuer = Boolean.parseBoolean(teuerString);
	
	if(confirmBttn == null){confirmBttn = "";}
	if(returnBttn == null){returnBttn = "";}
	
	if(confirmBttn.equals("Bestaetigen")){
		if(restB.restaurantCheck()){
	        response.sendRedirect("../views/addRestaurantView.jsp");
		}else {
		String stadtPLZ = sb.getStadtPLZ();
		restB.setStadtPLZ(stadtPLZ);
		restB.setNewRestName(newRestName);
		restB.setNewRestAdresse(newRestAdresse);
		restB.setVegan(vegan);
		restB.setVegetarisch(vegetarisch);
		restB.setHalal(halal);
		restB.setPescetarisch(pescetarisch);
		restB.setGlutenfrei(glutenfrei);
		restB.setGuenstig(guenstig);
		restB.setNormal(normal);
		restB.setTeuer(teuer);
		restB.restaurantAnlegen();
		response.sendRedirect("../views/stadtView.jsp");}
	}else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");
	}else{
		response.sendRedirect("../views/addRestaurantView.jsp");
	}
%>
</body>
</html>