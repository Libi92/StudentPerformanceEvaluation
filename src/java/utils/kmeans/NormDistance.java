/**
 * NormDistance.java
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
 * Copyright (c) 2006-2007, Thomas Abeel
 * 
 * Project: http://sourceforge.net/projects/java-ml/
 * 
 */
package utils.kmeans;

/**
 * The norm distance or
 * 
 * 
 * This class implements the Norm distance. This is a generalization of the
 * Euclidean distance, in this respect that the power we use becomes a parameter
 * instead of being fixed to two.
 * 
 * The x-Norm distance between two points P=(p1,p2,...,pn) and Q=(q1,q2,...,qn)
 * in the Euclidean n-space is defined as: ((p1-q1)^x + (p2-q2)^x + ... +
 * (pn-qn)^x)^(1/x)
 * 
 * Special instances are x=0, the Manhattan- or taxicab norm. Or x=infinity
 * gives the
 * 
 * The default is the Euclidean distance where x=2.
 * 
 * @linkplain http://en.wikipedia.org/wiki/Norm_%28mathematics%29
 * @author Thomas Abeel
 * 
 */
public class NormDistance extends AbstractDistance {
    /**
     * XXX add doc
     */
    public NormDistance() {
        this(2);
    }

    /**
     * XXX add doc
     */
    private double power;

    /**
     * XXX add doc
     */
    public NormDistance(double power) {
        this.power = power;
    }

    /**
     * XXX add doc
     */
    public double calculateDistance(Instance x, Instance y) {
        if (x.size() != y.size()) {
            throw new RuntimeException("Both instances should contain the same number of values.");
        }
        double sum = 0;
        for (int i = 0; i < x.size(); i++) {
            sum += Math.pow(Math.abs(y.getValue(i) - x.getValue(i)), power);
        }
        return Math.pow(sum, 1 / power);
    }

    /**
     * XXX add doc
     */
    public double getMaximumDistance(Dataset data) {
        return calculateDistance(data.getMaximumInstance(), data.getMinimumInstance());
    }

    /**
     * XXX add doc
     */
    public double getMinimumDistance(Dataset data) {
        return 0;
    }

}
