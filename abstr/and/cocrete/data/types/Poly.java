package abstr.and.cocrete.data.types;

/**
 * Implement the immutable class Poly using an array to represent single variable polynomial. 
 * @author tarasdranik
 *
 */

public final class Poly {
    private final int[][] polynom;
    private final int coefficient = 0;
    private final int power = 1;
    
    public Poly (int[][] array) {
        int [][] data = new int[array.length][2];
        for (int i=0; i < data.length; i++) {
            data[i][coefficient] = array [i][coefficient];
            data[i][power] = array [i][power];
        }
        this.polynom = data;
    }
    
    // Return coefficient
    
    public int getCoefficient (int i) {
        return this.polynom[i][coefficient];
    }
    
    //Return power
    
    public int getPower (int i) {
        return this.polynom[i][power];
    }
    
    //Calculate number of the elements in polynom
    
    public int size() {
        return this.polynom.length;
    }
    
    /**
     * Calculate the value of the polynom for given x
     * @param x Float number of the variable
     * @return double evaluation the value of the polynomial for the given value of the variable
     */
    
    public double evaluate(float x) {
        double evaluation=0;
        for (int i=0; i < polynom.length; i++) {
            evaluation = evaluation + polynom[i][coefficient]*Math.pow(x, polynom[i][power]);
        }
        return evaluation;
    }
    
    /**
     * Checking the degree of the polynom
     * @return Integer the highest numbe of the power.
     */
    
    public int degree() {
        int degree = polynom[0][power];
        for (int i=1; i< polynom.length; i++) {
            if (polynom[i][power]>degree) degree = polynom[i][power];
        }
        return degree;
    }
    
    /**
     * Adds two polynoms together
     * @param p1 Poly first polynomial 
     * @param p2 Poly second polynomial
     * @return 2D Array of Integers which represent sum of two polynomials where the first column is coeficients and second is powers.
     */
    
    public int [][] addPoly(Poly p1, Poly p2) {
        int [][] sumPoly = new int [p1.size()+p2.size()][2];
        for (int i = 0; i < p1.size(); i++) {
            sumPoly[i][coefficient] = p1.getCoefficient(i);
            sumPoly[i][power] = p1.getPower(i);
        }
        
        
        for (int i = 0; i < p2.size(); i++) {
            for (int j = 0; j < sumPoly.length; j++) {
                if (p2.getPower(i) == sumPoly[j][power]) {
                    sumPoly[j][coefficient] = sumPoly[j][coefficient]+p2.getCoefficient(i);
                    break;
                }
                if (sumPoly[j][coefficient] == 0) {
                    sumPoly[j][coefficient] = p2.getCoefficient(i);
                    sumPoly[j][power] = p2.getPower(i);
                    break;
                }
            }
        }
        
        return sumPoly;
    }
    
    /**
     * Multiply two polynoms
     * @param p1 Poly first polynomial
     * @param p2 Poly second polynomial
     * @return 2D Array of Integers which represent result of multiplication of two polynomials where the first column is coeficients and second is powers.
     */
    
    public int [] [] multiplyPoly(Poly p1, Poly p2) {
        int [][] multiPoly = new int [p1.size()*p2.size()][2];
        int j = 0;
        
        for (int i = 0; i < p1.size(); i++) {
            for (int k = 0; k < p2.size(); k++) {
                multiPoly [j][coefficient] = p2.getCoefficient(k)*p1.getCoefficient(i);
                multiPoly [j][power] = p2.getPower(k)+p1.getPower(i);;
                j+=1;
            }
        }
        
        //Adds coefficients which have the same power, and set the first appearance of the same to power to the resulting sum, and second appearance to zero
        
        for (int i=0; i < multiPoly.length; i++) {
            if (i < multiPoly.length - 1) {
            for (int e = i+1; e < multiPoly.length; e++) {
                if (multiPoly [i][power] == multiPoly [e][power] && multiPoly [i][coefficient]!=0 && multiPoly [e][coefficient]!=0) {
                    multiPoly [i][coefficient] = multiPoly [i][coefficient]+multiPoly [e][coefficient];
                    multiPoly [e][coefficient] = 0;
                    multiPoly [e][power] = 0;
                }
            }
            }
        }
        
        int counter = 0;
        //Counts all non-zero elements
        for (int i=0; i < multiPoly.length; i++) if (multiPoly [i][coefficient]!=0) counter +=1;
        
        //Creats empty 2D array 
        int [][] multiPolyResult = new int [counter][2];
        
        int y = 0;
        //Sets all non-zero elemnt two new array.
        for (int i = 0; i < multiPoly.length; i++) {
            if (multiPoly [i][coefficient]!=0) {
                multiPolyResult[y][coefficient] = multiPoly [i][coefficient];
                multiPolyResult[y][power] = multiPoly [i][power];
                y+=1;
            }
        }
        return multiPolyResult;
    }
    

}
