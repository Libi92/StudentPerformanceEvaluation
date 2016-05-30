/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.predict;

import db.DBUtils;
import fuzzy.utils.DataEntity;
import fuzzy.utils.DataSet;
import fuzzy.utils.MarkEntry;
import fuzzy.utils.MarkList;
import fuzzy.utils.PlacementData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyberprism
 */
public class TestFileCreater {

    public static void createDataSet() {
        PrintWriter pw = null;
        String[] companyNames = new String[]{"INFOSYS", "TCS", "CTS", "UST", "IBM", "WIPRO"};
        try {
            File file = new File("test.in");
            File objectFile = new File("testObject.in");
            pw = new PrintWriter(file);

            List<PlacementData> data = new ArrayList<>();
            for (int k = 0; k < 60; k++) {
                DataSet dataSet = new DataSet();
                for (int i = 0; i < 8; i++) {
                    MarkList list = new MarkList();

                    for (int j = 0; j < 6; j++) {
                        String line = "";

                        String type;
                        double weight;

                        if (j < i) {
                            type = MarkEntry.TECHNICAL;
                            weight = MarkEntry.TECHNICALWEIGHT;
                        } else {
                            type = MarkEntry.NORMAL;
                            weight = MarkEntry.NORMALWEIGHT;
                        }
                        double mark = (60 + (Math.random() * 60));
                        line += type + "\t" + mark + "\t" + weight;

                        pw.println(line);
                        pw.flush();
                        MarkEntry entry = new MarkEntry(type, mark, weight);
                        list.add(entry);
                    }
                    pw.println();
                    pw.flush();
                    dataSet.add(list);
                }
                pw.println("---------------------------");
                pw.flush();
                DataEntity entity = new DataEntity(k, null, dataSet);
                List<String> companies = new ArrayList<>();

                for (int i = 0; i < (int) (Math.random() * 4); i++) {
                    int pos = (int) (Math.random() * 6);
                    companies.add(companyNames[pos]);
                }
                pw.println(companies.toString());
                pw.flush();

                PlacementData pd = new PlacementData(entity, companies);
                data.add(pd);
            }

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(objectFile))) {
                outputStream.writeObject(data);
                outputStream.flush();
            }

            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public static void read_excel() {
        String DIR_PATH = "C:\\Users\\Hp\\Documents\\StudentsData";
        File[] files = (new File(DIR_PATH)).listFiles();

        File objectFile = new File("testObject.in");
        List<PlacementData> data = new ArrayList<>();

        for (int k = 0; k < files.length; k++) {
            List<String> companies = null;
            BufferedReader br = null;
            try {
                File excelSheet = files[k];
                br = new BufferedReader(new FileReader(excelSheet));
                
                DataSet dataSet = new DataSet();
                
                String line = "";
                try{
                    br.readLine();
                }
                catch(Exception ex){}
                MarkList list = new MarkList();
                while ((line = br.readLine()) != null) {                    
//                    System.out.println(line);
                    
                    String type;
                    double mark;
                    double weight;
                    
                    
                    
                    if(line.startsWith("Sem")||(line.startsWith("COMPANIES"))){
                        dataSet.add(list);
                        list = new MarkList();
                        if(line.startsWith("COMPANIES")){
                            companies = Arrays.asList(line.split(",")[1].split(";"));
                            System.out.println(companies);
                        }
                    }
                    else{
                        System.out.println(line);
                        String[] subject = line.split(",");
                        if(subject[0].equals("TECHNICAL")){
                            type = MarkEntry.TECHNICAL;
                            weight = MarkEntry.TECHNICALWEIGHT;
                        }
                        else{
                            type = MarkEntry.NORMAL;
                            weight = MarkEntry.NORMALWEIGHT;
                        }
                        mark = Double.parseDouble(subject[1]);
                        
                        MarkEntry entry = new MarkEntry(type, mark, weight);
                        
                        list.add(entry);
                        
                    }
                    
                }
                name = excelSheet.getName();
                
                DataEntity entity = new DataEntity(k, name.substring(0, name.lastIndexOf(".")), dataSet);
                PlacementData pd = new PlacementData(entity, companies);
                data.add(pd);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
            outputStream.writeObject(data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static String name;

    public static List<PlacementData> readDataSet() {
        File objectFile = new File("testObject.in");
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(objectFile));
            List<PlacementData> data = (List<PlacementData>) inputStream.readObject();
            return data;
        } catch (IOException ex) {
            Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestFileCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void createDataEntry() {
        String[] companyNames = new String[]{"INFOSYS", "TCS", "CTS", "UST", "IBM", "WIPRO", "ACCENTURE", "SUTHERLAND", "FINGENT", "TEMENOS"};

        for (int i = 0; i < 120; i++) {

            String name = "Student_" + i;
            String rollno = "roll_" + i;
            String department = "department_" + i;
            String semester = "semester_" + i;
            String dob = "dob_" + i;
            String address = "address_" + i;
            String contact = "contact_" + i;
            String email = "email_" + i;
            String yearOfAdm = "";

            for (int j = 0; j < 8; j++) {

            }
        }
    }

    public static void main(String[] args) {
//        createDataSet();
        read_excel();
        
//        DBUtils.getStudentDataSet("15");
        
    }
}
