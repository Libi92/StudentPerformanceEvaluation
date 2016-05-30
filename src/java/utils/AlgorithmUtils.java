/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class AlgorithmUtils {
    private static Hashtable<String,List<String>> categories = new Hashtable<String,List<String>>();
    
    static {
        
        final List<String> categoryTheoritcal = Arrays.asList(new String[] { "physics", "chemistry", 
            "technical communication and social science", "system programming" });
        final List<String> categoryLogical = Arrays.asList(new String[] { "maths", "mechanics", 
            "discrete computational structures", "operational research", "autometa" });
        final List<String> categoryProgramming = Arrays.asList(new String[] { "computer programming lab", "object oriented programming","object oriented programming lab", 
            "microprocessor", "data structure lab", "pc hardware and microprocessor lab", "mini project", "system programming lab" });
        final List<String> categoryTechnical = Arrays.asList(new String[] { "graphics", "civil and mechanical", 
            "electrical engineering and electronics", "computer programming", "electrical and mechanical workshop", "electrical technology", "electronic circuit and logic design",
            "computer organisation", "logic design lab", "data structure", "data communication", "software engineering","computer graphics and animation", "dbms", "knowledge engineering" });
        
        
        categories.put("theoritcal", categoryTheoritcal);
        categories.put("logical", categoryLogical);
        categories.put("programming", categoryProgramming);
        categories.put("technical", categoryTechnical);
        
    }
    
    public static List<String[]> readSemister(String semister) {
        final List<String[]> semister1 = new ArrayList<String[]>();

        FileInputStream fileIn = null;
        try {
            File csvFile = new File(Globals.semisterBasePath+"\\sem"+semister+".csv");
            fileIn = new FileInputStream(csvFile);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fileIn));

            String line = "";

            while((line=reader.readLine())!=null) {
                semister1.add(line.split(","));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgorithmUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlgorithmUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileIn.close();
            } catch (IOException ex) {
                Logger.getLogger(AlgorithmUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return semister1;
    }
    
    public static String getCategory(final String header) {
        try {
        return categories.keySet().stream()
                .filter(category->{
                            return categories.get(category).contains(header.toLowerCase())?true:false;
                })
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
        } catch(IndexOutOfBoundsException ex) {
            return "";
        }
    }
    
    public static List<String> getHeader(String category) {
        return categories.get(category);
    }
    
    public static Hashtable<String,Long> categorizeMarks(final List<String[]> marks) {
        final Hashtable<String,Long> categorized = new Hashtable<String,Long>();
        
        marks.stream()
                .map(mark->new String[] { mark[1], mark[2] })
                .forEach(mark -> {
             String category = getCategory(mark[1]);
            System.out.println("Category---------"+category);
            if(category==null || category.equals(""))
                return;
            
            Long tMarks = 0l;
            
            if(categorized.containsKey(category.toUpperCase()+ " SUBJECTS")) {
                tMarks = categorized.get(category.toUpperCase() + " SUBJECTS");
            }
            
            tMarks += Long.parseLong(mark[0]);
            
            categorized.put(category.toUpperCase()+ " SUBJECTS", tMarks);
        });
        
        return categorized;
    }
}
