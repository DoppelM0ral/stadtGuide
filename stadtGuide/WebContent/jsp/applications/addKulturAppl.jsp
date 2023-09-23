<%@page import="stadtGuideBeans.stadtBean"%>
<%@page import="stadtGuideBeans.addBean"%>
<%@page import="stadtGuideBeans.kulturBean"%>
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
<jsp:useBean id="cultb" class="stadtGuideBeans.kulturBean" scope="session"/>
<jsp:useBean id="sb" class="stadtGuideBeans.stadtBean" scope="session"/>
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
		if(cultb.kulturCheck()){
			
			String errorMessage = "Die Kultur existiert bereits.";
	        %>
	        <script>
	        showError("<%= errorMessage %>");
	        </script>
	        <%
	        response.sendRedirect("../views/addKulturView.jsp");
		}else {
		String stadtPLZ = sb.getStadtPLZ();
		cultb.setStadtPLZ(stadtPLZ);
		cultb.setNewCultName(newCultName);
		cultb.setNewCultAdresse(newCultAdresse);
		cultb.setNewCult(newCult);
		cultb.setCultPreis(cultPreis);
		cultb.kulturAnlegen();
		response.sendRedirect("../views/stadtView.jsp");}
	}else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");}
	else{
		response.sendRedirect("../views/addKulturView.jsp");
	}
		
%>
</body>
</html>