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
public class MarkList extends ArrayList<MarkEntry> implements Serializable{
    public MarkList(){
        super();
    }
    
    public MarkList(Collection c){
        super(c);
    }
    
    public double getNormalWeightedSum(){
        double sum = 0;
        sum = this.stream()
                .filter((entry) -> (entry.type.equals(MarkEntry.NORMAL)))
                .map((entry) -> (entry.getlocalWeight()))
                .reduce(sum, (accumulator, _item) -> accumulator + _item);
        return sum;
    }
    
    public double getTechnicalWeightedSum(){
        double sum = 0;
        sum = this.stream()
                .filter((entry) -> (entry.type.equals(MarkEntry.TECHNICAL)))
                .map((entry) -> (entry.getlocalWeight()))
                .reduce(sum, (accumulator, _item) -> accumulator + _item);
        return sum;
    }
    
    public int sizeNormal(){
        int count = 0;
        count = this.stream().filter((entry) -> (entry.type.equals(MarkEntry.NORMAL))).map((_item) -> 1).reduce(count, Integer::sum);
        return count;
    }
    
    public int sizeTechnical(){
        int count = 0;
        count = this.stream().filter((entry) -> (entry.type.equals(MarkEntry.TECHNICAL))).map((_item) -> 1).reduce(count, Integer::sum);
        return count;
    }
}
