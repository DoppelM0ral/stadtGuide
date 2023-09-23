<%@page import="stadtGuideBeans.stadtBean"%>
<%@page import="stadtGuideBeans.aktivitaetBean"%>
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
<jsp:useBean id="activb" class="stadtGuideBeans.aktivitaetBean" scope="session"/>
<jsp:useBean id="sb" class="stadtGuideBeans.stadtBean" scope="session"/>
<%
	String newActivName = request.getParameter("newActivName");
	String newActivAdresse = request.getParameter("newActivAdresse");
	String newActivity = request.getParameter("newActivity");
	String activePreis = request.getParameter("activePreis");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	if (confirmBttn == null){confirmBttn = "";}
	if (returnBttn == null){returnBttn = "";}
	
	if(confirmBttn.equals("Bestaetigen")){
		if(activb.aktivitaetCheck()){
			
			String errorMessage = "Die Akivitaet existiert bereits.";
	        %>
	        <script>
	        showError("<%= errorMessage %>");
	        </script>
	        <%
	        response.sendRedirect("../views/addAktivitaetView.jsp");
		}else {
		String stadtPLZ = sb.getStadtPLZ();
		activb.setStadtPLZ(stadtPLZ);
		activb.setNewActivName(newActivName);
		activb.setNewActivAdresse(newActivAdresse);
		activb.setNewActivity(newActivity);
		activb.setActivePreis(activePreis);
		activb.aktivitaetAnlegen();
		response.sendRedirect("../views/stadtView.jsp");}
	}else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");}
	else{
		response.sendRedirect("../views/addAktivitaetView.jsp");}
%>
</body>
</html>