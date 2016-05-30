<%@page import="utils.Globals"%>
<%@page import="db.DBUtils"%>
<%
    
    String id = request.getParameter("id");
    String action = request.getParameter("action");
    
    action = (action.equals("accept")) ? "1" : "-1";
    DBUtils.academicAction(id, action);
    
    action = (action.equals("1")) ? "approved" : "rejected";
    session.setAttribute(Globals.ALERT_VALUE, "Accademic details " + action);
    
    response.sendRedirect("../");
%>