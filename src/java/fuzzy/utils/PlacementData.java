/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.utils;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cyberprism
 */
public class PlacementData implements Serializable{
    DataEntity entity;
    List<String> companies;
    
    public PlacementData(DataEntity entity, List<String> companies){
        this.entity = entity;
        this.companies = companies;
    }

    public DataEntity getEntity() {
        return entity;
    }

    public void setEntity(DataEntity entity) {
        this.entity = entity;
    }

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }
    
    public String toString(){
        String result = getEntity().getName() + "\n" + getEntity().getDataSet().getTechnicalMean() + "\n" + getEntity().getDataSet().getTechnicalMean() + "\n" + getCompanies().toString() + "\n-------------------------------------------------\n";
        
        return result;
    }
    
}
