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
	String newActivName = request.getParameter("newActivName");
	String newActivAdress = request.getParameter("newActivAdress");
	String newActivity = request.getParameter("newActivity");
	String newActivPrice = request.getParameter("newActivPrice");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	if (confirmBttn == null){confirmBttn = "";}
	if (returnBttn == null){returnBttn = "";}
	
	if(confirmBttn.equals("Bestaetigen")){
		response.sendRedirect("../views/stadtView.jsp");}
	else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");}
	else{
		
	}
%>
</body>
</html>