<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application</title>
</head>
<body>
<jsp:useBean id="sb" class="stadtGuideBeans.addBean" scope="session"/>


	This shouldnt be possible :)
	Gotta work on that
	
		<%
		//Übergabe der Parameter
		String nameStadt = request.getParameter("nameStadt");
		String plzStadt = request.getParameter("plzStadt");
		String bundeslandStadt = request.getParameter("bundeslandStadt");
		String kreisStadt = request.getParameter("kreisStadt");
		String einwohnerStadt = request.getParameter("einwohnerStadt");
		String backBttn = request.getParameter("backBttn");
		String confirmBttn = request.getParameter("confirmBttn");
		
		//NullCheck und Aufbereitung der parameter
		if (backBttn == null){
			backBttn = "";}

		
		//Application
		if (backBttn.equals("Zurueck")){
			response.sendRedirect("../views/auswahlView.jsp");}
		else if (confirmBttn.equals("Bestaetigen")){
			sb.setStadtName(nameStadt);
			sb.setStadtPLZ(plzStadt);
			sb.setStadtLand(bundeslandStadt);
			sb.setStadtKreis(kreisStadt);
			sb.setStadtEinwohner(einwohnerStadt);
			sb.stadtAnlegen();
			response.sendRedirect("../views/addStadtView.jsp");	}
		else{
			response.sendRedirect("../views/auswahlView.jsp");}
		%>

</body>
</html>