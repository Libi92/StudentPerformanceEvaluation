/**
 * SimpleInstance.java, 23-okt-2006
 *
 * This file is part of the Java Machine Learning API
 * 
 * The Java Machine Learning API is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * The Java Machine Learning API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with the Java Machine Learning API; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * Copyright (c) 2006, Thomas Abeel
 * 
 * Project: http://sourceforge.net/projects/java-ml/
 * 
 */
package utils.kmeans;

public class SimpleInstance implements Instance {

    private int hashCode = 0;

    private double[] values = null;;

    private boolean classSet = false;

    private int classValue = 0;

    private double weight = 1;
    
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Copy constructor, this makes a deep copy of the Instance
     * 
     * @param instance
     */
    public SimpleInstance(Instance instance) {
        this(instance.toArray(), instance.getWeight(), instance.isClassSet(), instance.getClassValue());

    }

    public void setClassValue(int classValue) {
        this.classValue = classValue;
    }

    @Override
    public boolean equals(Object obj) {
        Instance tmp = (Instance) obj;
        boolean equal = values.length == tmp.size();
        int pos = 0;
        while (equal && pos < values.length) {
            equal = equal && MathUtils.eq(values[pos], tmp.getValue(pos));
            pos++;
        }
        return equal;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        
//        String out = "[" + values[0];
//        for (int i = 1; i < values.length; i++) {
//            out += ";" + values[i];
//        }
//        out += ";w:" + this.weight;
//        if (this.classSet) {
//            out += ";C:" + this.classValue;
//        }
//        return out + "]";
        return "[" + studentName + "]";
    }

    public SimpleInstance(double[] values) {
        this(values, 1.0f);
    }

    public SimpleInstance(double[] values, float weight) {
        this(values, weight, false, 0);
    }

    public SimpleInstance(double[] values, double weight, boolean classSet, int classValue) {
        this.values = new double[values.length];
        System.arraycopy(values, 0, this.values, 0, values.length);

        this.weight = weight;
        this.classSet = classSet;
        this.classValue = classValue;
        for (double f : values) {
            hashCode += f;
        }

    }

   
    public double getValue(int index) {
        return values[index];
    }

    public int getClassValue() {
        return classValue;
    }

    public boolean isClassSet() {
        return classSet;
    }

    public boolean isCompatible(Instance instance) {
        return instance.size() == this.size();
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(float d) {
        this.weight = d;

    }

    public int size() {
        return values.length;
    }

    public double[] toArray() {
        double[] out = new double[values.length];
        System.arraycopy(this.values, 0, out, 0, this.values.length);
        return out;
    }

}
