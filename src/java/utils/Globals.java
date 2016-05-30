/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author cyberprism
 */
public class Globals {
    public static final String SessionId = "SessionId";
    public static final String CSE_KEY = "CSE";
    public static final String ECE_KEY = "ECE";
    public static final String EEE_KEY = "EEE";
    public static final String CE_KEY = "CE";
    public static final String MECH_KEY = "MECH";
    public static final String SELECT_KEY = "SELECT";
    
    public static final String CERTIFICATE_DIRECTORY = "certificates";
    
    public static final String ALERT_VALUE = "ALERTVALUE";
    
    public static LinkedHashMap<String, String> Departments = new LinkedHashMap<>();
    public static String[] Semesters = new String[]{SELECT_KEY, "Semester 1 & 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
    public static String[] SubjectTypes = new String[]{"Theoretical", "Technical", "Logical", "Programming"};
    public static final String semisterBasePath="F:\\Projects\\StudentPerformanceEvaluation\\Student";
    
    public static void init(){
        Departments.put(SELECT_KEY, SELECT_KEY);
        Departments.put(CSE_KEY, "Computer Science And Engineering");
        Departments.put(CSE_KEY, "Information Technology");
        Departments.put(ECE_KEY, "Electronics And Communication Engineering");
        Departments.put(EEE_KEY, "Electrical And Electronics Engineering");
        Departments.put(CE_KEY, "Civil Engineering");
        Departments.put(MECH_KEY, "Mechanical Engineering");
    }
    
}
