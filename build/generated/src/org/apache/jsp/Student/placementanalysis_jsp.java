package org.apache.jsp.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Hashtable;
import utils.AlgorithmUtils;
import utils.Globals;
import java.util.List;
import db.DBUtils;

public final class placementanalysis_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <!-- jQuery (necessary JavaScript plugins) -->\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <link href=\"../css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"../css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <!--//theme-style-->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"University Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <script src=\"../js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"../js/bootstrap.js\"></script>\n");
      out.write("   \n");
      out.write("        <title>Placement Analysis</title>\n");
      out.write("        \n");
      out.write("        <script lang=\"javascript\">\n");
      out.write("            function placementAnalysis() {\n");
      out.write("              var xhttp = new XMLHttpRequest();\n");
      out.write("              xhttp.onreadystatechange = function() {\n");
      out.write("                if (xhttp.readyState == 4 && xhttp.status == 200) {\n");
      out.write("                 document.getElementById(\"results\").innerHTML = xhttp.responseText;\n");
      out.write("                }\n");
      out.write("              };\n");
      out.write("              xhttp.open(\"GET\", \"../PlacementAnalysisServlet\", true);\n");
      out.write("              xhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function testAnalysis() {\n");
      out.write("              var xhttp = new XMLHttpRequest();\n");
      out.write("              xhttp.onreadystatechange = function() {\n");
      out.write("                if (xhttp.readyState == 4 && xhttp.status == 200) {\n");
      out.write("                 document.getElementById(\"results\").innerHTML = xhttp.responseText;\n");
      out.write("                }\n");
      out.write("              };\n");
      out.write("              xhttp.open(\"GET\", \"../TestAnalysisServlet?technical=\"+document.getElementById(\"technical\").value\n");
      out.write("                      +\"&logical=\"+document.getElementById(\"logical\").value\n");
      out.write("                      +\"&theoritcal=\"+document.getElementById(\"theoritcal\").value\n");
      out.write("                      +\"&programming=\"+document.getElementById(\"programming\").value, true);\n");
      out.write("              \n");
      out.write("              xhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <!-- banner --> \n");
      out.write("        <div class=\"banner2\">\t  \n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\"><img src=\"../images/logo.jpg\" alt=\"\"/></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"top-menu\">\n");
      out.write("                    <span class=\"menu\"></span>\n");
      out.write("                    <ul class=\"navig\">\n");
      out.write("                        <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"academics.jsp\">Academics</a></li>\n");
      out.write("                        <li><a href=\"placementofficers.jsp\">Placement Officers</a></li>\n");
      out.write("                        <li><a href=\"placements.jsp\">Placements</a></li>\n");
      out.write("                        <li><a href=\"placementanalysis.jsp\">Placement Analysis</a></li>\n");
      out.write("                        <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- script-for-menu -->\n");
      out.write("                <script>\n");
      out.write("                    $(\"span.menu\").click(function () {\n");
      out.write("                        $(\"ul.navig\").slideToggle(\"slow\", function () {\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("                <!-- script-for-menu -->\n");
      out.write("                <div class=\"clearfix\"></div>\n");
      out.write("            </div>\t  \n");
      out.write("        </div>\n");
      out.write("        <div class=\"blog\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <div class=\"blog-head\">\n");
      out.write("        <h1>Placement Analysis</h1>\n");
      out.write("        </div>\n");
      out.write("        <hr/>\n");
      out.write("        <input type=\"button\" id=\"analysis\" name=\"analysis\" value=\"Analyse\" onclick=\" placementAnalysis(); \"/>\n");
      out.write("        <hr/>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        Logged In As - ");
      out.print( userName );
      out.write("<br/>\n");
      out.write("        Technical:\n");
      out.write("        <input type=\"text\" id=\"technical\" name=\"technical\" value=\"");
      out.print( lTechnical );
      out.write("\"/>\n");
      out.write("        <br/>\n");
      out.write("        Logical:\n");
      out.write("        <input type=\"text\" id=\"logical\" name=\"logical\" value=\"");
      out.print( lLogical );
      out.write("\"/>\n");
      out.write("        <br/>\n");
      out.write("        Theoritcal:\n");
      out.write("        <input type=\"text\" id=\"theoritcal\" name=\"theoritcal\" value=\"");
      out.print( lTheoritcal );
      out.write("\"/>\n");
      out.write("        <br/>\n");
      out.write("        Programming:\n");
      out.write("        <input type=\"text\" id=\"programming\" name=\"programming\" value=\"");
      out.print( lProgramming );
      out.write("\"/>\n");
      out.write("        <br/>\n");
      out.write("        <input type=\"button\" id=\"test\" name=\"test\" value=\"Test\" onclick=\" testAnalysis(); \"/>\n");
      out.write("        <hr/>\n");
      out.write("        <div id=\"results\">\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <hr/>\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"copywrite\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <p>Copyright © 2015 University. All rights reserved | Design by <a href=\"http://w3layouts.com\">W3layouts</a></p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("   \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
