package org.apache.jsp.PlacementOfficer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.Globals;

public final class Analysis_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute(Globals.SessionId)==null)
      response.sendRedirect("../");


      out.write(" \n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>University a Educational Category Flat Bootstrap Responsive Website Template | Single :: w3layouts</title>\n");
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
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            $(document).ready(function () {\n");
      out.write("            ");
      if (!(session.getAttribute(Globals.ALERT_VALUE) == null)) {
      out.write("\n");
      out.write("\n");
      out.write("                $(\"#alert_info\").html(\"");
      out.print( session.getAttribute(Globals.ALERT_VALUE));
      out.write("\");\n");
      out.write("                $(\"#alert_model\").modal();\n");
      out.write("\n");
      out.write("            ");
          session.setAttribute(Globals.ALERT_VALUE, null);
                }
            
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
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
      out.write("                        <li class=\"active\"><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                        <li><a href=\"academics.jsp\">Academics</a></li>\n");
      out.write("                        <li><a href=\"placementofficers.jsp\">Placement Officers</a></li>\n");
      out.write("                        <li><a href=\"placements.jsp\">Placements</a></li>\n");
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
      out.write("        <!---->\n");
      out.write("        <!-- blog-page -->\n");
      out.write("        <div class=\"blog\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"blog-head\">\n");
      out.write("                    <h2>Change Password</h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 col-md-offset-1\">\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"clearfix\"> </div>\n");
      out.write("            </div>\t\n");
      out.write("        </div>\t\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"ftr-sec\">\n");
      out.write("                    <div class=\"col-md-4 ftr-grid\">\n");
      out.write("                        <h3>Text Module</h3>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut odio ut quam convallis ultricies. Morbi rutrum lectus tortor. Cras vitae semper mi, et feugiat dolor.</p>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut odio ut quam convallis ultricies. Morbi rutrum lectus tortor. Cras vitae semper mi, et feugiat dolor.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4 ftr-grid2\">\n");
      out.write("                        <h3>Pages</h3>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"index.html\"><span></span>Home</a></li>\n");
      out.write("                            <li><a href=\"about.html\"><span></span>About</a></li>\n");
      out.write("                            <li><a href=\"program.html\"><span></span>Programs</a></li>\n");
      out.write("                            <li><a href=\"blog.html\"><span></span>Blog</a></li>\t\n");
      out.write("                            <li><a href=\"gallery.html\"><span></span>Gallery</a></li>\n");
      out.write("                            <li><a href=\"contact.html\"><span></span>Contact</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4 ftr-grid3\">\n");
      out.write("                        <h3>Quick links</h3>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"about.html\"><span></span>History</a></li>\n");
      out.write("                            <li><a href=\"about.html\"><span></span>Departments</a></li>\n");
      out.write("                            <li><a href=\"gallery.html\"><span></span>Services</a></li>\n");
      out.write("                            <li><a href=\"blog.html\"><span></span>Guidances</a></li>\t\n");
      out.write("                            <li><a href=\"about.html\"><span></span>Team</a></li>\n");
      out.write("                            <li><a href=\"contact.html\"><span></span>Contact</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"copywrite\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <p>Copyright © 2015 University. All rights reserved | Design by <a href=\"http://w3layouts.com\">W3layouts</a></p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("        \n");
      out.write("        <div class=\"modal fade\" id=\"alert_model\" tabindex=\"-1\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                        <h4 class=\"modal-title\">Info</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <p id=\"alert_info\"></p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Ok</button>\n");
      out.write("                    </div>\n");
      out.write("                </div><!-- /.modal-content -->\n");
      out.write("            </div><!-- /.modal-dialog -->\n");
      out.write("        </div><!-- /.modal -->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
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
