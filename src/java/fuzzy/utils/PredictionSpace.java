/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.utils;

import java.util.List;

/**
 *
 * @author cyberprism
 */
public class PredictionSpace {
    double TechnicalMean;
    double NormalMean;
    List<String> companies;
    
    public PredictionSpace(double TechnicalMean, double NormalMean, List<String> companies){
        this.TechnicalMean = TechnicalMean;
        this.NormalMean = NormalMean;
        this.companies = companies;
    }

    public double getTechnicalMean() {
        return TechnicalMean;
    }

    public void setTechnicalMean(double TechnicalMean) {
        this.TechnicalMean = TechnicalMean;
    }

    public double getNormalMean() {
        return NormalMean;
    }

    public void setNormalMean(double NormalMean) {
        this.NormalMean = NormalMean;
    }

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }
    
}
