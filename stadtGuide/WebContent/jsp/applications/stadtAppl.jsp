<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String ernaehrung = request.getParameter("ernaehrung");
	String unterkunft = request.getParameter("unterkunft");
	String returnBttn = request.getParameter("returnBttn");
	String addToBttn = request.getParameter("addToBttn");
	
	if(returnBttn== null){returnBttn = "";}
	if(addToBttn == null){addToBttn= "";}
	
	if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/auswahlView.jsp");
	}else if(addToBttn.equals("Stadt erweitern")){
		response.sendRedirect("../views/addToStadtView.jsp");
	}
%>
</body>
</html>