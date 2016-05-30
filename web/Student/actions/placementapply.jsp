<%@page import="db.DBUtils"%>
<%@page import="utils.Globals"%>
<%
    
    String id = request.getParameter("id");
    String loginid = session.getAttribute(Globals.SessionId).toString();
    
    String result = DBUtils.applyPlacementDrive(id, loginid);
    
    session.setAttribute(Globals.ALERT_VALUE, result);
    response.sendRedirect("../placements.jsp");
%>