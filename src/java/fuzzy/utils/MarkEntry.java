/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.utils;

import java.io.Serializable;

/**
 *
 * @author cyberprism
 */
public class MarkEntry implements Serializable{
    
    public static final String NORMAL = "NORMAL";
    public static final String TECHNICAL = "TECHNICAL";
    
    public static final double NORMALWEIGHT = 1.0;
    public static final double TECHNICALWEIGHT = 3.4;
    
    String type;
    double mark;
    double weight;
    
    public MarkEntry(String type, double mark, double weight){
        this.type = type;
        this.mark = mark;
        this.weight = weight;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public double getlocalWeight(){
        return this.mark * this.weight;
    }
    
    
}
