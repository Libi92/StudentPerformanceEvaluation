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
public class DataEntity implements Serializable{
    int itemId;
    String name;
    DataSet dataSet;
    
    public DataEntity(int itemId, String name, DataSet dataSet){
        this.itemId = itemId;
        this.name = name;    
        this.dataSet = dataSet;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }
    
}
