/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.predict;

import db.DBUtils;
import fuzzy.utils.DataEntity;
import fuzzy.utils.DataSet;
import fuzzy.utils.PlacementData;
import fuzzy.utils.PredictionSpace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author cyberprism
 */
public class FuzzyPredict {
    
    List<PredictionSpace> predictionSpaces;
    double fuzzyTechFactor;
    double fuzzyNormalFactor;
    double tolerance = 0.0d;
    
    public FuzzyPredict(List<PlacementData> data){
        predictionSpaces = new ArrayList<>();
        
        for (PlacementData placementData : data) {
            DataSet dataSet = placementData.getEntity().getDataSet();
            PredictionSpace predictionSpace = new PredictionSpace(dataSet.getTechnicalMean(), dataSet.getNormalMean(), placementData.getCompanies());
            predictionSpaces.add(predictionSpace);
        }
    }
    
    public void computeSpace(){
        double finalTechMean = 0.0d;
        double finalNormalMean = 0.0d;
        double fuzzyTechSquare = 0.0d;
        double fuzzyNormalSquare = 0.0d;
        
        for (PredictionSpace predictionSpace : predictionSpaces) {
            finalTechMean += predictionSpace.getTechnicalMean();
            finalNormalMean += predictionSpace.getNormalMean();
        }
        
        finalTechMean /= predictionSpaces.size();
        finalNormalMean /= predictionSpaces.size();
        
        for (PredictionSpace predictionSpace : predictionSpaces) {
            fuzzyTechSquare += Math.pow((predictionSpace.getTechnicalMean() - finalTechMean), 2);
            fuzzyNormalSquare += Math.pow((predictionSpace.getNormalMean() - finalNormalMean), 2);
        }
        
        fuzzyTechSquare /= predictionSpaces.size();
        fuzzyNormalSquare /= predictionSpaces.size();
        
        fuzzyTechFactor = Math.sqrt(fuzzyTechSquare);
        fuzzyNormalFactor = Math.sqrt(fuzzyNormalSquare);
    }
    
    public List<String> getCompaniesInSpace(double techMean, double normalMean){
        List<String> companies = new ArrayList<>();
        for (PredictionSpace predictionSpace : predictionSpaces) {
            if(((predictionSpace.getTechnicalMean() + fuzzyTechFactor) > techMean) && ((predictionSpace.getTechnicalMean() - fuzzyTechFactor) < techMean)){
                if(((predictionSpace.getNormalMean() + fuzzyNormalFactor) > normalMean) && ((predictionSpace.getNormalMean() - fuzzyNormalFactor) < normalMean)){
                    companies.addAll(predictionSpace.getCompanies());
                }
            }
        }
        
        HashSet<String> set = new HashSet<>(companies);
        companies = new ArrayList<>(set);
        
        return companies;
    }
    
    public List<PlacementData> predict(List<DataEntity> studentList){
        computeSpace();
        List<PlacementData> ouput = new ArrayList<>();
        
        for (DataEntity student : studentList) {
            double techMean = student.getDataSet().getTechnicalMean();
            double normalMean = student.getDataSet().getNormalMean();
            
            List<String> companies = getCompaniesInSpace(techMean, normalMean);
            
            PlacementData placementData = new PlacementData(student, companies);
            ouput.add(placementData);
        }
        return ouput;
    }
    
    public static void main(String[] args) {
        List<PlacementData> data = TestFileCreater.readDataSet();
        
        for (PlacementData placementData : data) {
            System.out.println(placementData.toString());
        }
        
        System.out.println(data.size());
        List<DataEntity> studentList = new ArrayList<>();
        studentList.add(DBUtils.getStudentDataSet("22"));
//        studentList.add(data.get(7).getEntity());
        
        FuzzyPredict fuzzyPredict = new FuzzyPredict(data);
        List<PlacementData> output = fuzzyPredict.predict(studentList);
        
        for (PlacementData result : output) {
            System.out.println(result.getEntity().getItemId());
            System.out.println(result.getCompanies());
            System.out.println("---------------");
        }
    }
}
