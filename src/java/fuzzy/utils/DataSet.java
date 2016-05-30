/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author cyberprism
 */
public class DataSet extends ArrayList<MarkList> implements Serializable{
    public DataSet(){
        super();
    }
    
    public DataSet(Collection c){
        super(c);
    }
    
    public double getNormalMean(){
        double sum = 0;
        sum = this.stream().map((listItem) -> listItem.getNormalWeightedSum()).reduce(sum, (accumulator, _item) -> accumulator + _item);
        return sum / this.sizeNormal();
    }
    
    public double getTechnicalMean(){
        double sum = 0;
        sum = this.stream().map((listItem) -> listItem.getTechnicalWeightedSum()).reduce(sum, (accumulator, _item) -> accumulator + _item);
        return sum / this.sizeTechnical();
    }
    
    public int sizeNormal(){
        int count = 0;
        count = this.stream().map((listItem) -> listItem.sizeNormal()).reduce(count, Integer::sum);
        return count;
    }
    
    public int sizeTechnical(){
        int count = 0;
        count = this.stream().map((listItem) -> listItem.sizeNormal()).reduce(count, Integer::sum);
        return count;
    }
}
