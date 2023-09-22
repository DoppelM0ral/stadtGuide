<%@page import="stadtGuideBeans.kulturBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
</head>
<body>
<jsp:useBean id="cultb" class="stadtGuideBeans.kulturBean" scope="session"/>
<%
	String newCultName = request.getParameter("newCultName");
	String newCultAdresse = request.getParameter("newCultAdresse");
	String newCult = request.getParameter("newCult");
	String cultPreis = request.getParameter("cultPreis");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	if (confirmBttn == null){confirmBttn = "";}
	if (returnBttn == null){returnBttn = "";}
	
	if (confirmBttn.equals("Bestaetigen")){
		cultb.zaehlerID();
		cultb.setNewCultName(newCultName);
		cultb.setNewCultAdresse(newCultAdresse);
		cultb.setNewCult(newCult);
		cultb.setCultPreis(cultPreis);
		cultb.kulturAnlegen();
		response.sendRedirect("../views/stadtView.jsp");}
	else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");}
	else{
		response.sendRedirect("../views/addKulturView.jsp");
	}
		
%>
</body>
</html>