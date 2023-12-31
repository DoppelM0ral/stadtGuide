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
<script type="text/javascript" src="../../js/addKulturJS.js"></script>
</head>
<body>
<jsp:useBean id="cultb" class="stadtGuideBeans.kulturBean" scope="session"/>
<jsp:useBean id="sb" class="stadtGuideBeans.stadtBean" scope="session"/>
<%
	String newCultName = request.getParameter("newCultName");
	String newCultAdresse = request.getParameter("newCultAdresse");
	String newCult = request.getParameter("newCult");
	String guenstigString = request.getParameter("guenstig");
	String normalString = request.getParameter("normal");
	String teuerString = request.getParameter("teuer");
	String confirmBttn = request.getParameter("confirmBttn");
	String returnBttn = request.getParameter("returnBttn");
	
	boolean guenstig = Boolean.parseBoolean(guenstigString);
	boolean normal = Boolean.parseBoolean(normalString);
	boolean teuer = Boolean.parseBoolean(teuerString);
	
	boolean museum = false;
	boolean historisch = false;
	boolean tour = false;
	boolean sehenswuerdigkeit = false;
	
	if (newCult != null) {
        switch (newCult) {
            case "museum":
                museum = true;
                break;
            case "historisch":
                historisch = true;
                break;
            case "tour":
                tour = true;
                break;
            case "sehenswuerdigkeit":
            	sehenswuerdigkeit = true;
                break;
            default:
                break;
        }
    }
	
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
		cultb.setMuseum(museum);
		cultb.setHistorisch(historisch);
		cultb.setTour(tour);
		cultb.setSehenswuerdigkeit(sehenswuerdigkeit);
		cultb.setGuenstig(guenstig);
		cultb.setNormal(normal);
		cultb.setTeuer(teuer);
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