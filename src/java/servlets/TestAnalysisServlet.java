/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AlgorithmUtils;
import utils.kmeans.Dataset;
import utils.kmeans.SimpleInstance;

/**
 *
 * @author Admin
 */
public class TestAnalysisServlet extends HttpServlet {

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

        List<String[]> sem12 = AlgorithmUtils.readSemister("1&2");
        List<String[]> sem3 = AlgorithmUtils.readSemister("3");
        List<String[]> sem4 = AlgorithmUtils.readSemister("4");
        List<String[]> sem5 = AlgorithmUtils.readSemister("5");
        
        final String[] headerSem12 = sem12.get(0);
        final String[] headerSem3 = sem3.get(0);
        final String[] headerSem4 = sem4.get(0);
        final String[] headerSem5 = sem5.get(0);
        
        sem12 = sem12.stream().filter(sem->!Arrays.asList(sem).contains("ID")).collect(Collectors.toList());
        sem3 = sem3.stream().filter(sem->!Arrays.asList(sem).contains("ID")).collect(Collectors.toList());
        sem4 = sem4.stream().filter(sem->!Arrays.asList(sem).contains("ID")).collect(Collectors.toList());
        sem5 = sem5.stream().filter(sem->!Arrays.asList(sem).contains("ID")).collect(Collectors.toList());
        
        
        final List<String[]> sem12_final = sem12;
        final List<String[]> sem3_final = sem3;
        final List<String[]> sem4_final = sem4;
        final List<String[]> sem5_final = sem5;
        
        Dataset[] dataset = (Dataset[]) request.getSession().getAttribute("CLUSTERS");
        
        final List<String[]> allSemisters = new ArrayList<String[]>();
        
        allSemisters.addAll(sem12);
        allSemisters.addAll(sem3);
        allSemisters.addAll(sem4);
        allSemisters.addAll(sem5);
        
        String technical = request.getParameter("technical");
        String logical = request.getParameter("logical");
        String theoritcal= request.getParameter("theoritcal");
        String programming = request.getParameter("programming");
        
        final Long lTechnical = Long.parseLong(technical);
        final Long lLogical = Long.parseLong(logical);
        final Long lTheoritcal = Long.parseLong(theoritcal);
        final Long lProgramming = Long.parseLong(programming);
        
        int similarIndex = 0;
        double minDistance = Double.MAX_VALUE;
        
        int cluster = 0;
        for (Dataset dataset1 : dataset) {
            for (int i = 0; i < dataset1.size(); i++) {
                double[] studentMarks = dataset1.getInstance(i).toArray();
                double distance = Math.pow(studentMarks[0] - lTechnical, 2) + Math.pow(studentMarks[1] - lLogical, 2) + Math.pow(studentMarks[2] - lTheoritcal, 2) + Math.pow(studentMarks[3] - lProgramming, 2);
                
                if(distance < minDistance){
                    minDistance = distance;
                    similarIndex = cluster;
                }
                
            }
            cluster++;
        }
        
        PrintWriter pw = new PrintWriter(response.getOutputStream());
        
        pw.println("<table border=\"1\">");
        pw.flush();
        
        pw.println("<th>Company</th>");
        pw.flush();
        
        List<String> companies = new ArrayList<>();
        for (int i = 0; i < dataset[similarIndex].size(); i++) {
            String name = ((SimpleInstance)dataset[similarIndex].getInstance(i)).getStudentName();
            
            for (int j = 0; j < sem12.size(); j++) {
                if(sem12.get(j)[0].equals(name)){
                    if(!companies.contains(sem12.get(j)[13])){
                        companies.add(sem12.get(j)[13]);
                    }
                    
                }
            }
        }
        
        for (String company : companies) {
            pw.println("<tr><td>"+company+"</td></tr>");
                    pw.flush();
        }
//        companies.stream().forEach(company-> { pw.println("<tr><td>"+company+"</td></tr>"); pw.flush(); });
        
        pw.println("</table>");
        pw.flush();
        
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
        processRequest(request, response);
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
