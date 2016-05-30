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
        
        <script>
            
            $(document).ready(function () {
            <%      if (!(session.getAttribute(Globals.ALERT_VALUE) == null)) {%>

                $("#alert_info").html("<%= session.getAttribute(Globals.ALERT_VALUE)%>");
                $("#alert_model").modal();

            <%          session.setAttribute(Globals.ALERT_VALUE, null);
                }
            %>
                    
                    $("#semester").on('change', function(){
                        $.ajax({
                            method: "POST",
                            url: "ajax/getsubjects.jsp",
                            data: { semester: $(this).val() }
                        })
                        .done(function( msg ) {
                            $("#semsubjects").html(msg);
                        })
                        .fail(function ( jqXHR, textStatus ){
                            alert( "Request failed: " + textStatus );
                        });
                    });
            });
        </script>
        
 <script>
        function validateselect()
        {
//            var a=document.getElementById("department").value;
            
            var b=document.getElementById("semester").value;
//            var c=document.getElementById("department").value;
          
            if(b=="SELECT")
            {
               alert("Please select Semester");
                return false; 
            }
            else
                
        {
            return true;
        }
        }
        
        
        </script>
        <script>
            function isNumber(evt)
            {
                evt = (evt) ? evt : window.event;
                var charcode = (evt.which) ? evt.which : evt.keyCode;
                if (charcode > 31 && (charcode < 48 || charcode > 57))
                {
                    return false;

                }
                return true;
            }
        </script>
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
                        <li class="active"><a href="academics.jsp">Academics</a></li>
                        <li><a href="placementofficers.jsp">Placement Officers</a></li>
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
                    <h2>Academics</h2>
                </div>
                <div class="col-md-6 col-md-offset-1">
                    <form class="form-horizontal" method="post" action="../Academics" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-md-4" for="semester">Semester</label>
                            <div class="col-md-8">
                                <select class="form-control" name="semester" id="semester">
                                    <%
                                        for (String sem : Globals.Semesters) {
                                    %>
                                    <option value="<%=sem%>"><%=sem%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4" for="totalmarks">Total Marks</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="totalmarks" onkeypress="return isNumber(event)" required id="totalmarks" placeholder="Total Marks" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4" for="percentage">Percentage</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="percentage" onkeypress="return isNumber(event)" required id="percentage" placeholder="Percentage" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4" for="backlogs">Backlogs</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="backlogs" onkeypress="return isNumber(event)" required id="backlogs" placeholder="Backlogs" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4" for="certificate">Certificate</label>
                            <div class="col-md-8">
                                <input type="file" class="form-control" required name="certificate" id="certificate" />
                            </div>
                        </div>
                        <div id="semsubjects">
                                    
                        </div>
                        <div class="form-group">
                            <div class="col-md-8 col-md-offset-4">
                                <input type="submit" class="btn btn-primary btn-block" value="Submit" onclick="return validateselect()" />
                            </div>
                        </div>
                    </form>
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
                            <li><a href="index.jsp"><span></span>Home</a></li>
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
                <p>Copyright © 2015 University. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
            </div>
        </div>
        <!---->
        
        <div class="modal fade" id="alert_model" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Info</h4>
                    </div>
                    <div class="modal-body">
                        <p id="alert_info"></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
    </body>
</html>