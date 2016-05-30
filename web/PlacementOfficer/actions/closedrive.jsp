<%@page import="utils.Globals"%>
<%@page import="db.DBUtils"%>
<%
    
    String driveId = request.getParameter("id");
    DBUtils.closePlacementDrive(driveId);
    session.setAttribute(Globals.ALERT_VALUE, "Placement drive closed");
    
    response.sendRedirect("../placements.jsp");
%>