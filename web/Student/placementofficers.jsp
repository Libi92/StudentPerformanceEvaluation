<%@page import="db.DBUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Globals"%>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute(Globals.SessionId)==null)
      response.sendRedirect("../");

%> 
<!DOCTYPE HTML>
<html>
    <head>
        <title>University a Educational Category Flat Bootstrap Responsive Website Template | Single :: w3layouts</title>
        <!-- jQuery (necessary JavaScript plugins) -->
        <!-- Custom Theme files -->
        <link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <!-- Custom Theme files -->
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="University Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.js"></script>

    </head>
    <body>
        <!-- banner --> 
        <div class="banner2">	  
            <div class="header">
                <div class="logo">
                    <a href="index.html"><img src="../images/logo.jpg" alt=""/></a>
                </div>
                <div class="top-menu">
                    <span class="menu"></span>
                    <ul class="navig">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="academics.jsp">Academics</a></li>
                        <li class="active"><a href="placementofficers.jsp">Placement Officers</a></li>
                        <li><a href="placements.jsp">Placements</a></li>
                        <li><a href="placementanalysis.jsp">Placement Analysis</a></li>
                        <li><a href="logout.jsp">Logout</a></li>
                    </ul>
                </div>
                <!-- script-for-menu -->
                <script>
                    $("span.menu").click(function () {
                        $("ul.navig").slideToggle("slow", function () {
                        });
                    });
                </script>
                <!-- script-for-menu -->
                <div class="clearfix"></div>
            </div>	  
        </div>
        <!---->
        <!-- blog-page -->
        <div class="blog">
            <div class="container">
                <div class="blog-head">
                    <h2>Placement Officers</h2>
                </div>

                <div class="col-md-8">
                    <%                        
                        ResultSet rs = DBUtils.getPlacementOfficer();
                        if (rs.next()) {
                    %>
                    <table class="table table-hover">
                        <tr>
                            <th>Staff ID</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                        </tr>
                        <%
                            do {
                        %>
                        <tr>
                            <td><%= rs.getString("staffId")%></td>
                            <td><%= rs.getString("name")%></td>
                            <td><%= rs.getString("contact")%></td>
                            <td><%= rs.getString("email")%></td>
                        </tr>
                        <%
                            } while (rs.next());
                        %>
                    </table>
                    <%
                    } else {
                    %>
                    <div class="alert alert-info" role="alert">No Placement Officers Added</div>
                    <%
                        }
                    %>
                </div>
                <div class="clearfix"> </div>
            </div>	
        </div>	
        <!---->
        <div class="footer">
            <div class="container">
                <div class="ftr-sec">
                    <div class="col-md-4 ftr-grid">
                        <h3>Text Module</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut odio ut quam convallis ultricies. Morbi rutrum lectus tortor. Cras vitae semper mi, et feugiat dolor.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut odio ut quam convallis ultricies. Morbi rutrum lectus tortor. Cras vitae semper mi, et feugiat dolor.</p>
                    </div>
                    <div class="col-md-4 ftr-grid2">
                        <h3>Pages</h3>
                        <ul>
                            <li><a href="index.html"><span></span>Home</a></li>
                            <li><a href="about.html"><span></span>About</a></li>
                            <li><a href="program.html"><span></span>Programs</a></li>
                            <li><a href="blog.html"><span></span>Blog</a></li>	
                            <li><a href="gallery.html"><span></span>Gallery</a></li>
                            <li><a href="contact.html"><span></span>Contact</a></li>
                        </ul>
                    </div>
                    <div class="col-md-4 ftr-grid3">
                        <h3>Quick links</h3>
                        <ul>
                            <li><a href="about.html"><span></span>History</a></li>
                            <li><a href="about.html"><span></span>Departments</a></li>
                            <li><a href="gallery.html"><span></span>Services</a></li>
                            <li><a href="blog.html"><span></span>Guidances</a></li>	
                            <li><a href="about.html"><span></span>Team</a></li>
                            <li><a href="contact.html"><span></span>Contact</a></li>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <!---->
        <div class="copywrite">
            <div class="container">
                <p>Copyright � 2015 University. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
            </div>
        </div>
        <!---->
    </body>
</html>