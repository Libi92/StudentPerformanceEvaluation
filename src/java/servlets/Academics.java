/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.DBUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.Globals;

/**
 *
 * @author cyberprism
 */
@WebServlet(name = "Academics", urlPatterns = {"/Academics"})
public class Academics extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Academics</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Academics at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            System.out.println("multipart");
        } else {
            System.out.println("not multipart");
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String fileName = null;
        String fileKey = null;
        HashMap<String, String> itemMap = new HashMap<String, String>();

        //Processing file upload //////////////////////////////////////////
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setSizeThreshold(5 * 1024 * 1024);
        File fileLocation = File.createTempFile("project", "tmp");
        fileItemFactory.setRepository(fileLocation);
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        try {
            List items = fileUpload.parseRequest(request);
            for (Object object : items) {
                FileItem item = (FileItem) object;
                if (item.isFormField()) {

                    fileKey = item.getFieldName();
                    fileName = item.getString();
                    itemMap.put(fileKey, fileName);

                } else {

                    String root = getServletContext().getRealPath("");
                    File path = new File(root + "/" + Globals.CERTIFICATE_DIRECTORY);
                    if (!path.exists()) {
                        boolean status = path.mkdirs();
                    }

                    File file = new File(path + "/" + item.getName());
                    fileKey = item.getFieldName();
                    fileName = item.getName();
                    itemMap.put(fileKey, fileName);
                    try {
                        item.write(file);

                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }
                }

            }
            
            String semester = itemMap.get("semester");
            String totalmarks = itemMap.get("totalmarks");
            String percentage = itemMap.get("percentage");
            String backlogs = itemMap.get("backlogs");
            String certificate = itemMap.get("certificate");
            String loginId = request.getSession().getAttribute(Globals.SessionId).toString();
            
            int subjectcount = Integer.parseInt(itemMap.get("subjectcount"));
            HashMap<String, String> subjectMarks = new HashMap<>();
            for (int i = 0; i < subjectcount; i++) {
                String subjectId = itemMap.get("subject" + i);
                String mark = itemMap.get("mark" + i);
                
                subjectMarks.put(subjectId, mark);
            }
            
            DBUtils.addAcademics(loginId, semester, totalmarks, percentage, backlogs, certificate, subjectMarks);
            
            
            request.getSession().setAttribute(Globals.ALERT_VALUE, "Accademic details submitted");
        
            response.sendRedirect("Student/academics.jsp");

        } catch (FileUploadException ex) {
            Logger.getLogger(Academics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
