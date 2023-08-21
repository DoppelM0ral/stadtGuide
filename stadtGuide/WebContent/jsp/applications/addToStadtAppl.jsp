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
	String backBttn = request.getParameter("backBttn");
	
	if (addToStadt == null){addToStadt = "";}
	if (addBttn == null){addBttn = "";}
	if (backBttn == null){backBttn = "";}
	
	if(backBttn.equals("Zur Stadt")){
		response.sendRedirect("../views/stadtView.jsp");
	}else if(addBttn.equals("Erweitern")){
		if(addToStadt.equals("restaurant")){
			response.sendRedirect("../views/addRestaurantView.jsp");
		}else if(addToStadt.equals("unterkunft")){
			response.sendRedirect("../views/addUnterkunftView.jsp");
		}else if(addToStadt.equals("kultur")){
			response.sendRedirect("../views/addKulturView.jsp");
		}else if(addToStadt.equals("aktivitaet")){
			response.sendRedirect("../views/addAktivitaetView.jsp");
		}
	}else { 
		response.sendRedirect("../views/addToStadtView.jsp");
	}
%>
</body>
</html>