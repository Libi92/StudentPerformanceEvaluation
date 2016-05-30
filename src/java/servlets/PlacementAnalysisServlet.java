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
import java.util.Vector;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AlgorithmUtils;
import utils.kmeans.Clusterer;
import utils.kmeans.Dataset;
import utils.kmeans.Instance;
import utils.kmeans.KMeans;
import utils.kmeans.SimpleDataset;
import utils.kmeans.SimpleInstance;

/**
 *
 * @author Admin
 */
public class PlacementAnalysisServlet extends HttpServlet {

    private static int index = 0;

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

        sem12 = sem12.stream().filter(sem -> !Arrays.asList(sem).contains("ID")).collect(Collectors.toList());
        sem3 = sem3.stream().filter(sem -> !Arrays.asList(sem).contains("ID")).collect(Collectors.toList());
        sem4 = sem4.stream().filter(sem -> !Arrays.asList(sem).contains("ID")).collect(Collectors.toList());
        sem5 = sem5.stream().filter(sem -> !Arrays.asList(sem).contains("ID")).collect(Collectors.toList());

        final List<String> studentNames = new ArrayList<String>();

        studentNames.addAll(sem12.stream()
                .map(sem -> sem[0])
                .filter(sem -> !studentNames.contains(sem))
                .collect(Collectors.toList()));

        studentNames.addAll(sem3.stream()
                .map(sem -> sem[0])
                .filter(sem -> !studentNames.contains(sem))
                .collect(Collectors.toList()));

        studentNames.addAll(sem4.stream()
                .map(sem -> sem[0])
                .filter(sem -> !studentNames.contains(sem))
                .collect(Collectors.toList()));

        studentNames.addAll(sem5.stream()
                .map(sem -> sem[0])
                .filter(sem -> !studentNames.contains(sem))
                .collect(Collectors.toList()));

        final Hashtable<String, Hashtable<String, Long>> marks = new Hashtable<String, Hashtable<String, Long>>();

        final List<String[]> sem12_final = sem12;
        final List<String[]> sem3_final = sem3;
        final List<String[]> sem4_final = sem4;
        final List<String[]> sem5_final = sem5;

        studentNames.stream().forEach(studentname -> {
            final Hashtable<String, Long> studentMarks = new Hashtable<String, Long>();

            sem12_final.stream().filter(sem -> sem[0].equals(studentname)).forEach(sem -> {
                if (!Arrays.asList(sem).contains("LATERAL ENTRY")) {
                    for (int i = 2; i < sem.length - 1; i++) {
                        Long marks1 = 0l;
                        if (studentMarks.containsKey(headerSem12[i])) {
                            marks1 = studentMarks.get(headerSem12[i]);
                        }

                        marks1 += Long.parseLong(sem[i]);

                        studentMarks.put(headerSem12[i], marks1);
                    }
                }
            });

            sem3_final.stream().filter(sem -> sem[0].equals(studentname)).forEach(sem -> {
                if (!Arrays.asList(sem).contains("LATERAL ENTRY")) {
                    for (int i = 2; i < sem.length - 1; i++) {
                        Long marks1 = 0l;
                        if (studentMarks.containsKey(headerSem3[i])) {
                            marks1 = studentMarks.get(headerSem3[i]);
                        }

                        marks1 += Long.parseLong(sem[i]);

                        studentMarks.put(headerSem3[i], marks1);
                    }
                }
            });

            sem4_final.stream().filter(sem -> sem[0].equals(studentname)).forEach(sem -> {
                if (!Arrays.asList(sem).contains("LATERAL ENTRY")) {
                    for (int i = 2; i < sem.length - 1; i++) {
                        Long marks1 = 0l;
                        if (studentMarks.containsKey(headerSem4[i])) {
                            marks1 = studentMarks.get(headerSem4[i]);
                        }

                        marks1 += Long.parseLong(sem[i]);

                        studentMarks.put(headerSem4[i], marks1);
                    }
                }
            });

            sem5_final.stream().filter(sem -> sem[0].equals(studentname)).forEach(sem -> {
                if (!Arrays.asList(sem).contains("LATERAL ENTRY")) {
                    for (int i = 2; i < sem.length - 1; i++) {
                        Long marks1 = 0l;
                        if (studentMarks.containsKey(headerSem5[i])) {
                            marks1 = studentMarks.get(headerSem5[i]);
                        }

                        marks1 += Long.parseLong(sem[i]);

                        studentMarks.put(headerSem5[i], marks1);
                    }
                }
            });

            marks.put(studentname, studentMarks);
        });

        final Hashtable<String, Hashtable<String, Long>> totals = new Hashtable<String, Hashtable<String, Long>>();

        marks.keySet().stream().forEach(studentname -> {
            final Hashtable<String, Long> total = new Hashtable<String, Long>();
            final Hashtable<String, Long> marks2 = marks.get(studentname);

            marks2.keySet().stream()
                    .map(header -> AlgorithmUtils.getCategory(header))
                    .filter(category -> (category != null && !category.equals("")))
                    .distinct()
                    .forEach(category -> {
                        Long tMarks = 0l;

                        if (total.containsKey(category.toUpperCase() + " SUBJECTS")) {
                            tMarks = total.get(category.toUpperCase() + " SUBJECTS");
                        }

                        if (marks2.keySet().stream()
                        .filter(header -> AlgorithmUtils.getHeader(category).contains(header.toLowerCase())).count() > 0) {
                            tMarks += marks2.keySet().stream()
                            .filter(header -> AlgorithmUtils.getHeader(category).contains(header.toLowerCase()))
                            .map(header -> marks2.get(header))
                            .mapToLong(m1 -> m1).sum();

                            total.put(category.toUpperCase() + " SUBJECTS", tMarks);
                        }
                    });

            totals.put(studentname, total);
        });

        System.out.println("Totals -> " + totals);

        Vector<Instance> data = new Vector<>();

        totals.keySet().stream().forEach(studentname -> {
            final Hashtable<String, Long> marks2 = totals.get(studentname);

            final Long technicalMarks = marks2.get("TECHNICAL SUBJECTS");
            final Long logicalMarks = marks2.get("LOGICAL SUBJECTS");
            final Long theoritcalMarks = marks2.get("THEORITCAL SUBJECTS");
            final Long programmingMarks = marks2.get("PROGRAMMING SUBJECTS");

            SimpleInstance instance = new SimpleInstance(new double[]{technicalMarks, logicalMarks, theoritcalMarks, programmingMarks});
            instance.setStudentName(studentname);

            data.add(instance);
        });

        Dataset dataset = new SimpleDataset(data);
        Clusterer kmeans = new KMeans(4, 100);
        Dataset[] clusters = kmeans.executeClustering(dataset);
        
        request.getSession().setAttribute("CLUSTERS", clusters);

        for (int i = 0; i < clusters.length; i++) {
            System.out.println(clusters[i] + "\n");
        }

        PrintWriter pw = new PrintWriter(response.getOutputStream());

        pw.println("<font color=\"#ff0000\">Analysis Complete</font>");
        pw.flush();
        pw.println("<br/>");
        pw.flush();

        pw.println("<table border=\"1\">");
        pw.flush();

        pw.println("<th>Student Name</th>");
        pw.println("<th>TECHNICAL SUBJECTS</th>");
        pw.println("<th>LOGICAL SUBJECTS</th>");
        pw.println("<th>THEORITICAL SUBJECTS</th>");
        pw.println("<th>PROGRAMMING SUBJECTS</th>");
        pw.flush();

        int no = 1;
        for (Dataset cluster : clusters) {
            pw.println("<tr><td colspan=\"5\" style=\"color: #0044ff;\">Cluster " + no++ + "</td></tr>");

            for (int i = 0; i < cluster.size(); i++) {
                String studentname = ((SimpleInstance) cluster.getInstance(i)).getStudentName();

                Hashtable<String, Long> marks2 = totals.get(studentname);

                pw.println("<tr>");
                pw.flush();

                pw.println("<td>" + studentname + "</td>");
                pw.flush();
                pw.println("<td>" + marks2.get("TECHNICAL SUBJECTS") + "</td>");
                pw.flush();
                pw.println("<td>" + marks2.get("LOGICAL SUBJECTS") + "</td>");
                pw.flush();
                pw.println("<td>" + marks2.get("THEORITCAL SUBJECTS") + "</td>");
                pw.flush();
                pw.println("<td>" + marks2.get("PROGRAMMING SUBJECTS") + "</td>");
                pw.flush();

                pw.println("</tr>");
                pw.flush();
            }
        }


        pw.println("</table>");
        pw.flush();

        pw.close();

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
