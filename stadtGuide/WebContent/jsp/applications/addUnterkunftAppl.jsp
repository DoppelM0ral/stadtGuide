<%@page import="stadtGuideBeans.stadtBean"%>
<%@page import="stadtGuideBeans.unterkunftBean"%>
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
<jsp:useBean id="stayb" class="stadtGuideBeans.unterkunftBean" scope="session"/>
<jsp:useBean id="sb" class="stadtGuideBeans.stadtBean" scope="session"/>
<%
	String newStayName = request.getParameter("newStayName");
	String newStayAdresse = request.getParameter("newStayAdresse");
	String newStay = request.getParameter("newStay");
	String guenstigString = request.getParameter("guenstig");
	String normalString = request.getParameter("normal");
	String teuerString = request.getParameter("teuer");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	boolean guenstig = Boolean.parseBoolean(guenstigString);
	boolean normal = Boolean.parseBoolean(normalString);
	boolean teuer = Boolean.parseBoolean(teuerString);
	
	boolean hotel = false;
	boolean airbnb = false;
	boolean ferienwohnung = false;
	

	if (newStay != null) {
        switch (newStay) {
            case "hotel":
                hotel = true;
                break;
            case "airbnb":
                airbnb = true;
                break;
            case "ferienwohnung":
                ferienwohnung = true;
                break;
            default:
                break;
        }
    }
	
	if(confirmBttn == null){confirmBttn = "";}
	if(returnBttn == null){returnBttn = "";}
	
	if(confirmBttn.equals("Bestaetigen")){
		if(stayb.unterkunftCheck()){
			
			String errorMessage = "Die Unterkunft existiert bereits.";
	        %>
	        <script>
	        showError("<%= errorMessage %>");
	        </script>
	        <%
	        response.sendRedirect("../views/addUnterkunftView.jsp");
		}else {
		String stadtPLZ = sb.getStadtPLZ();
		stayb.setStadtPLZ(stadtPLZ);
		stayb.setNewStayName(newStayName);
		stayb.setNewStayAdresse(newStayAdresse);
		stayb.setHotel(hotel);
		stayb.setAirbnb(airbnb);
		stayb.setFerienwohnung(ferienwohnung);
		stayb.setGuenstig(guenstig);
		stayb.setNormal(normal);
		stayb.setTeuer(teuer);
		stayb.unterkunftAnlegen();
		response.sendRedirect("../views/stadtView.jsp");}
	}else if(returnBttn.equals("Zurueck")){
		response.sendRedirect("../views/addToStadtView.jsp");	
	}else{
		response.sendRedirect("../views/addUnterkunftView.jsp");
	}
%>
</body>
</html>