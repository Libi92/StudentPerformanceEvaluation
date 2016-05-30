<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Globals"%>
<%@page import="db.DBUtils"%>
<%
    
    String department = DBUtils.getDepartment(session.getAttribute(Globals.SessionId).toString());
    String semester = request.getParameter("semester");
    ResultSet rs = DBUtils.GetSubjects(department, semester);
%>

<div class="about-head">
    <h4>Subject Marks</h4>
    <hr>
</div>
<%
    int i = 0;
    int rowcount = 0;
    if (rs.last()) {
        rowcount = rs.getRow();
        rs.beforeFirst();
    }
%>
<input type="hidden" name="subjectcount" value="<%= rowcount %>" />
<%
    while(rs.next()){
        String subject = rs.getString("subject");
        
%>
<div class="form-group">
    <label class="col-md-4" for="mark<%= i %>"><%= subject %></label>
    <input type="hidden" name="subject<%= i %>" value="<%= rs.getString("subjectid") %>" />
    <div class="col-md-8">
        <input type="text" class="form-control" name="mark<%= i %>" id="mark<%= i++ %>" placeholder="<%= subject %>" />
    </div>
</div>
<%
    }
%>