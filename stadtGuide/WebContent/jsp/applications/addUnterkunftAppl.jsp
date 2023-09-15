<%@page import="stadtGuideBeans.unterkunftBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
</head>
<body>
<jsp:useBean id="stayb" class="stadtGuideBeans.unterkunftBean" scope="session"/>
<%
	String newStayName = request.getParameter("newStayName");
	String newStayCity = request.getParameter("newStayCity");
	String newStayPlz = request.getParameter("newStayPlz");
	String newStay = request.getParameter("newStay");
	String stayPreis = request.getParameter("stayPreis");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	if(confirmBttn == null){confirmBttn = "";}
	if(returnBttn == null){returnBttn = "";}
	
	if(confirmBttn.equals("Bestaetigen")){
		stayb.setNewStayName(newStayName);
		stayb.setNewStayCity(newStayCity);
		stayb.setNewStayPlz(newStayPlz);
		stayb.setNewStay(newStay);
		stayb.setStayPreis(stayPreis);
		stayb.unterkunftAnlegen();
		response.sendRedirect("../views/stadtView.jsp");
	}else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");	
	}else{
		response.sendRedirect("../views/addToStadtView.jsp");
	}
%>
</body>
</html>