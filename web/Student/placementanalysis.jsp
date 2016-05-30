<%-- 
    Document   : placementanalysis
    Created on : Apr 8, 2016, 1:10:28 PM
    Author     : Admin
--%>

<%@page import="java.util.Hashtable"%>
<%@page import="utils.AlgorithmUtils"%>
<%@page import="utils.Globals"%>
<%@page import="java.util.List"%>
<%@page import="db.DBUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
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
   
        <title>Placement Analysis</title>
        
        <script lang="javascript">
            function placementAnalysis() {
              var xhttp = new XMLHttpRequest();
              xhttp.onreadystatechange = function() {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                 document.getElementById("results").innerHTML = xhttp.responseText;
                }
              };
              xhttp.open("GET", "../PlacementAnalysisServlet", true);
              xhttp.send();
            }
            
            function testAnalysis() {
              var xhttp = new XMLHttpRequest();
              xhttp.onreadystatechange = function() {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                 document.getElementById("results").innerHTML = xhttp.responseText;
                }
              };
              xhttp.open("GET", "../TestAnalysisServlet?technical="+document.getElementById("technical").value
                      +"&logical="+document.getElementById("logical").value
                      +"&theoritcal="+document.getElementById("theoritcal").value
                      +"&programming="+document.getElementById("programming").value, true);
              
              xhttp.send();
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
        <div class="blog">
        <div class="container">
        <div class="blog-head">
        <h1>Placement Analysis</h1>
        </div>
        <hr/>
        <input type="button" id="analysis" name="analysis" value="Analyse" onclick=" placementAnalysis(); "/>
        <hr/>
        
        
        <%
            DBUtils.connect();
            final List<String[]> marks = DBUtils.getAllMarks(session.getAttribute(Globals.SessionId).toString());
        
            String userName = "";
            
            if(marks.size()>0) {
                userName = marks.get(0)[0];
            }
            
            final Hashtable<String,Long> marks2 = AlgorithmUtils.categorizeMarks(marks);
        
            String lTechnical = "";
            String lLogical = "";
            String lTheoritcal = "";
            String lProgramming = "";
            
            if(marks2.containsKey("TECHNICAL SUBJECTS")) {
                lTechnical = "" + marks2.get("TECHNICAL SUBJECTS");
            }
            
            if(marks2.containsKey("LOGICAL SUBJECTS")) {
                lLogical = "" + marks2.get("LOGICAL SUBJECTS");
            }
            
            if(marks2.containsKey("PROGRAMMING SUBJECTS")) {
                lProgramming = "" + marks2.get("PROGRAMMING SUBJECTS");
            }
            
            if(marks2.containsKey("THEORITCAL SUBJECTS")) {
                lTheoritcal = "" + marks2.get("THEORITCAL SUBJECTS");
            }
        %>
        
        Logged In As - <%= userName %><br/>
        <table class="table">
            <tr>
                <td>Technical</td>
                <td>:</td>
                <td>
                    <input type="text" id="technical" name="technical" value="<%= lTechnical %>"/>
                </td>
            </tr>
            
            <tr>
                <td>Logical</td>
                <td>:</td>
                <td>
                    <input type="text" id="logical" name="logical" value="<%= lLogical %>"/>
                </td>
            </tr>
            
            <tr>
                <td>Theoritical</td>
                <td>:</td>
                <td>
                    <input type="text" id="theoritcal" name="theoritcal" value="<%= lTheoritcal %>"/>
                </td>
            </tr>
            
            <tr>
                <td>Programming</td>
                <td>:</td>
                <td>
                    <input type="text" id="programming" name="programming" value="<%= lProgramming %>"/>
                </td>
            </tr>
        </table>
        <input type="button" id="test" name="test" value="Test" onclick=" testAnalysis(); "/>
        <hr/>
        <div id="results">
            
        </div>
        
        <hr/>
        <!---->
        <div class="copywrite">
            <div class="container">
                <p>Copyright © 2015 University. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
            </div>
        </div>
        <!---->
        
        
   
    </body>
</html>
