/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import fuzzy.utils.DataEntity;
import fuzzy.utils.DataSet;
import fuzzy.utils.MarkEntry;
import fuzzy.utils.MarkList;
import fuzzy.utils.PlacementData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Boss
 */
public class DBUtils {

    static Connection con;
    static Statement stmt;

    public static void connect() {

        if (con == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentperformance", "root", "mysql");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    public static int insertAndGetKey(String sql){
        connect();
        try {
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return  rs.getInt(1);
//            return stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ResultSet getData(String sl) {

        ResultSet rs = null;

        try {

            connect();

            stmt = con.createStatement();

            rs = stmt.executeQuery(sl);

        } catch (SQLException ex) {

            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static int insertData(String str) {

        int i = 0;

        try {
            connect();

            stmt = con.createStatement();

            i = stmt.executeUpdate(str);

        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public static String getNthCellcontentAsString(String sql, int n) {
        try {
            ResultSet rs = getData(sql);
            if (rs.next()) {
                return rs.getString(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }

    public static int getNthCellcontentAsInteger(String sql, int n) {
        try {
            ResultSet rs = getData(sql);
            if (rs.next()) {
                return rs.getInt(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int getNthCellcontentAsInteger(String sql, String field) {
        try {
            ResultSet rs = getData(sql);
            if (rs.next()) {
                return rs.getInt(field);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static boolean isExists(String sql) {

        try {
            ResultSet rs = getData(sql);

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String[] login(String username, String password) {

        String sql = "SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "' AND status=1";
        ResultSet rs = getData(sql);
        try {
            if(rs.next()){
                return new String[]{rs.getString("type"), rs.getString("loginid")};
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String[]{"false"};
    }

    public static String getMaximumFrom(String table) {
        String sql = "SELECT MAX(id) FROM " + table;
        return getNthCellcontentAsString(sql, 1);
    }

    private static String getUserId(String username) {
        String sql = "SELECT loginid FROM login WHERE username='" + username + "'";
        return getNthCellcontentAsString(sql, 1);
    }

    public static String RegisterStudent(String name, String roll, String dept, String sem, String dob, String address, String contact, String email, String admisnyear){
        String username = name.toLowerCase() + "_" + roll;
        String sql = "INSERT INTO login (username, password, type, status) VALUES ('" + username + "', 'student', 'Student', '1')";
        insertData(sql);
        String loginId = getUserId(username);
        sql = "INSERT INTO student (name, rollno, department, semester, dob, address, contact, email, yearofadmission, loginid) VALUES ('" + name + "', '" + roll + "', '" + dept + "', '" + sem + "', '" + dob + "', '" + address + "', '" + contact + "', '" + email + "', '" +admisnyear + "', '" + loginId + "')";
        System.out.println(sql);
        insertData(sql);
        
        return username;
    }
    
    public static ResultSet getStudentsDetails(String dept, String sem){
        String sql = "SELECT * FROM student WHERE department = '" + dept + "' AND semester = '" + sem + "'";
        return getData(sql);
    }
    
    public static String RegisterPlacementOfficer(String name, String stffid, String address, String contact, String email){
        String username = name.toLowerCase() + "_" + stffid;
        String sql = "INSERT INTO login (username, password, type, status) VALUES ('" + username + "', 'officer', 'PlacementOfficer', '1')";
        insertData(sql);
        String loginId = getUserId(username);
        sql = "INSERT INTO placementofficers (name, staffId, address, contact, email, loginid) VALUES ('" + name + "', '" + stffid + "', '" + address + "', '" + contact + "', '" + email + "', '" + loginId + "')";
        insertData(sql);
        
        return username;
    }
    
    public static ResultSet getPlacementOfficer(){
        String sql = "SELECT * FROM placementofficers";
        return getData(sql);
    }
    
    public static void addAcademics(String loginid, String semester, String total_mark, String percentage, String backlogs, String certificate, HashMap<String, String> subjectMarks){
        String sql = "INSERT INTO academics (loginid, semester, totalmarks, percentage, backlogs, certificate, status) VALUES (" + loginid + ", '" + semester + "', '" + total_mark + "', '" + percentage + "', '" + backlogs + "', '" + certificate + "', 0)";
        int acId = insertAndGetKey(sql);
        
        for (Map.Entry<String, String> entrySet : subjectMarks.entrySet()) {
            String subjectId = entrySet.getKey();
            String mark = entrySet.getValue();
            sql = "INSERT INTO subjectmarks (loginid, academicid, subjectid, mark) VALUES (" + loginid + ", " + acId + ", " + subjectId + ", '" + mark + "')";
            insertData(sql);
        }
        
    }
    
    public static ResultSet getPendingAcademics(){
        String sql = "SELECT student.name, student.department, academics.* FROM student, academics WHERE student.loginid = academics.loginid AND academics.status = 0";
        return getData(sql);
    }

    public static void academicAction(String id, String action){
        String sql = "UPDATE academics SET status = " + action + " WHERE academicsId = " + id;
        insertData(sql);
    }
    
    public static void addCompanies(String name, String location, String platforms){
        String sql = "INSERT INTO companies (name, location, platforms) VALUES ('" + name + "', '" + location + "', '" + platforms + "')";
        insertData(sql);
    }
    
    public static ResultSet getCompanies(){
        String sql = "SELECT * FROM companies";
        return getData(sql);
    }
    
    public static HashMap<String, String> getCompanyList(){
        try {
            String sql = "SELECT * FROM companies";
            ResultSet rs = getData(sql);
            HashMap<String, String> data = new HashMap<>();
            while (rs.next()) {
                data.put(rs.getString("companyid"), rs.getString("name"));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void addPlacementDrive(String companyid, String venue, String date, String time, String post, String minpercentage, String maxbacklog){
        String sql = "INSERT INTO placementdrive (companyid, venue, date, time, post, minpercentage, maxbacklogs, status) VALUES (" + companyid + ", '" + venue + "', '" + date + "', '" + time + "', '" + post + "', '" + minpercentage + "', '" + maxbacklog + "', 0)";
        insertData(sql);
    }
    
    public static ResultSet getPlacementDrives(String id){
        String sql;
        if(id.equals("0")){
            sql = "SELECT placementdrive.*, companies.name FROM placementdrive, companies WHERE placementdrive.companyid = companies.companyid AND placementdrive.status = 0";
        }
        else{
            sql = "SELECT 'ACCEPT' AS opt, placementdrive.*, companies.name FROM placementdrive, companies WHERE companies.companyid = placementdrive.companyid AND placementdrive.status = 0";
        }
        
        System.out.println(sql);
        return getData(sql);
    }
    
    public static String applyPlacementDrive(String placementid, String loginid){
        try {
            String sql = "SELECT AVG(percentage) AS percentage FROM academics WHERE loginid = " + loginid + " AND STATUS = 1";
            
            float percentage = 0.0f;
            int baclogs = 0;
            
            ResultSet rs = getData(sql);
            if(rs.next()){
                percentage = rs.getFloat("percentage");
            }
            
            sql = "SELECT SUM(backlogs) AS backlogs FROM academics WHERE loginid = " + loginid + " AND STATUS = 1";
            rs = getData(sql);
            if(rs.next()){
                baclogs = rs.getInt("backlogs");
            }
            
            sql = "SELECT minpercentage, maxbacklogs, companyid FROM placementdrive WHERE placementid = " + placementid;
            rs = getData(sql);
            
            float criteriaPercentage = 0.0f;
            int criteriaBacklogs = 0;
            String companyId = "";
            
            if(rs.next()){
                criteriaPercentage = rs.getFloat("minpercentage");
                criteriaBacklogs = rs.getInt("maxbacklogs");
                companyId = rs.getString("companyid");
            }
            
            if((percentage >= criteriaPercentage) && (baclogs <= criteriaBacklogs)){
                sql = "INSERT INTO placement (driveid, companyid, studentid, status) VALUES (" + placementid + "," + companyId + ", " + loginid + ", 0)";
                insertData(sql);
                return "Applied for placement";
            }
            else{
                return "You do not meet the criteria";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "You do not meet the criteria";
    }
    
    public static HashMap<String, String> getPlacementStudentsList(String driveId){
        try {
            HashMap<String, String> students = new HashMap<>();
            String sql = "SELECT student.loginid, student.name FROM student, placement WHERE placement.studentid = student.loginid AND placement.driveid = " + driveId;
            ResultSet rs = getData(sql);
            while (rs.next()) {
                students.put(rs.getString("loginid"), rs.getString("name"));
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void updateSelectedStudents(String driveid, String[] students){
        String sql;
        
        for (String student : students) {
            sql = "UPDATE placement SET status = 1 WHERE driveid = " + driveid + " AND studentid = " + student;
            insertData(sql);
        }
    }
    
    public static void AddSubject(String subject, String department, String semester, String type){
        String sql = "INSERT INTO subjects (subject, semester, department, type) VALUES ('" + subject + "', '" + semester + "', '" + department + "', '" + type + "')";
        insertData(sql);
    }
    
    public static ResultSet GetSubjects(String department, String semester){
        String sql;
        if(department==null && semester==null){
            sql = "SELECT * FROM subjects";
        }
        else{
            sql = "SELECT * FROM subjects WHERE department='" + department + "' AND semester='" + semester + "'";
        }
        
        return getData(sql);
    }
    
    public static String getDepartment(String loginid){
        String sql = "SELECT department FROM student WHERE loginid = " + loginid;
        return getNthCellcontentAsString(sql, 1);
    }
    
    public static void closePlacementDrive(String id){
        String sql = "UPDATE placementdrive SET status = 1 WHERE placementid = " + id;
        insertData(sql);
    }
    
    public static String changePassword(String loginId, String password, String newpassword){
        try {
            String sql = "SELECT password FROM login WHERE loginid = " + loginId;
            ResultSet rs = getData(sql);
            if (rs.next()) {
                String dbpassword = rs.getString("password");
                if(dbpassword.equals(password)){
                    sql = "UPDATE login SET password = '" + newpassword + "' WHERE loginid = " + loginId;
                    insertData(sql);
                    return "Password Changed";
                }
                else{
                    return "Password doesn't match";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Cannot be changed now";
    }
    
    public List<PlacementData> getPlacementDataList(){
        List<PlacementData> placementDatas = new ArrayList<>();
        
        return placementDatas;
    }
    
    public static DataEntity getStudentDataSet(String id){
        String sql = "SELECT * FROM subjects WHERE semester != 'Semester 6'";
        ResultSet rs = getData(sql);
        
        try {
            MarkList list1 = new MarkList();
            MarkList list3 = new MarkList();
            MarkList list4 = new MarkList();
            while (rs.next()) {
                String subjectId = rs.getString("subjectid");
                String type = rs.getString("type").toUpperCase();
                String semester = rs.getString("semester");
                double weight = (type.equals(MarkEntry.TECHNICAL)) ? MarkEntry.TECHNICALWEIGHT : MarkEntry.NORMALWEIGHT;
                
                sql = "SELECT * FROM subjectmarks WHERE loginid = " + id + " AND subjectid = " + subjectId;
                
                ResultSet rs2 = getData(sql);
                
                if (rs2.next()) {                    
                    double mark = rs2.getDouble("mark");
                    System.out.println(type + " - " + mark);
                    MarkEntry entry = new MarkEntry(type, mark, weight);
                    switch(semester){
                        case "Semester 1":
                            list1.add(entry);
                            break;
                        case "Semester 3":
                            list3.add(entry);
                            break;
                        case "Semester 4":
                            list4.add(entry);
                            break;
                    }
                    
                }
            }
            
            DataSet dataSet = new DataSet();
            dataSet.add(list1);
            dataSet.add(list3);
            dataSet.add(list4);
            sql = "SELECT NAME FROM student WHERE loginid = 15";
            ResultSet rs3 = getData(sql);
            rs3.next();
            DataEntity entity = new DataEntity(Integer.parseInt(id), rs3.getString("name"), dataSet);
            
            return entity;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static List<String[]> getAllMarks(String loggedInId) {
        final List<String[]> marks = new ArrayList<String[]>();
        
        try {
            
            String sql = "SELECT stud.name,marks.mark,subject1.subject "
                    + "FROM subjectmarks marks,subjects subject1,student stud "
                    + "WHERE marks.loginid="+ loggedInId + " AND stud.loginid=marks.loginid AND subject1.subjectid=marks.subjectid";
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                final String[] mark = new String[rs.getMetaData().getColumnCount()];
                
                for(int i=0;i<mark.length;i++) {
                    mark[i] = rs.getString(i+1);
                }
                
                marks.add(mark);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return marks;
    }
}
