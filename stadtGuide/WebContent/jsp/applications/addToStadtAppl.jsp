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
	String addToStadt = request.getParameter("addToStadt");
	String addBttn = request.getParameter("addBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	if (addToStadt == null){addToStadt = "";}
	if (addBttn == null){addBttn = "";}
	if (returnBttn == null){returnBttn = "";}
	
	if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/stadtView.jsp");
	}else if(addToStadt.equals("restaurant")){
		response.sendRedirect("../views/addRestaurantView.jsp");
	}
%>
</body>
</html>