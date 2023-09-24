<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="sb" class="stadtGuideBeans.stadtBean" scope="session"/>
<%@ page import="java.util.List, java.util.Arrays" %>
<%
	String returnBttn = request.getParameter("returnBttn");
	String addToBttn = request.getParameter("addToBttn");
	String gesucht = request.getParameter("gesucht");
	String searchBttn = request.getParameter("searchBttn");
	String[] preis = request.getParameterValues("preis");
	String[] kultur = request.getParameterValues("kultur");
	String[] unterkunft = request.getParameterValues("unterkunft");
	String[] options = request.getParameterValues("options");
	String[] aktivitaet = request.getParameterValues("aktivitaet");
	
	if(returnBttn== null){returnBttn = "";}
	if(addToBttn == null){addToBttn = "";}
	if(searchBttn == null){searchBttn = "";}
	if(gesucht == null){gesucht = "";}
	//	if(kultur[0] == null){kultur[0] = "";}
	//if(unterkunft[0] == null){unterkunft[0] = "";}
	//if(options[0] == null){options[0] = "";}
	//if(preis[0] == null){preis[0] = "";}
	
	
	if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/auswahlView.jsp");
	}else if(addToBttn.equals("Stadt erweitern")){
		response.sendRedirect("../views/addToStadtView.jsp");
	}else if(searchBttn.equals("suchen")){
		sb.setPreise(preis);
		sb.setKultur(options);
		sb.setKultur(kultur);
		sb.setUnterkunft(unterkunft);
		sb.setAktivitaet(aktivitaet);
	}
		
		
%>
</body>
</html>