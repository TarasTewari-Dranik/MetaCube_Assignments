package abstr.and.cocrete.data.types;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PolyTest {
    
    private static final double DELTA = 1e-15;
    
    @Test
    public void evaluateTest() {
        double result = 3*Math.pow(2, 3)+2*Math.pow(2, 2);
        int [][] polyArray = new int[][] {
                                    {3,3},
                                    {2,2}
                                    };
        Poly polinom = new Poly(polyArray);
        float x = 2.0f;
        assertEquals(result,polinom.evaluate(x),DELTA);
    }
    
    @Test
    public void degreeTest() {
        int result = 3;
        int [][] polyArray = new int[][] {
            {3,3},
            {2,2}
            };
        Poly polinom = new Poly(polyArray);
        assertEquals(result,polinom.degree());
        
    }
    
    @Test
    public void addTest() {
        int [][] polyArray = new int[][] {
            {3,3},
            {2,2}
            };
        int [][] polyArray2 = new int[][] {
            {5,3},
            {2,6}
            };
        int [][] result = new int [][] {
            {8,3},
            {2,2},
            {2,6},
            {0,0}
            };
        Poly polinom = new Poly(polyArray);
        Poly polinom2 = new Poly(polyArray2);
        assertArrayEquals(result,polinom.addPoly(polinom,polinom2));
    }
    
    @Test
    public void multiTest() {
        int [][] polyArray = new int[][] {
            {3,3},
            {2,2}
            };
        int [][] polyArray2 = new int[][] {
            {5,3},
            {2,6}
            };
        int [][] result = new int [][] {
            {15,6},
            {6,9},
            {10,5},
            {4,8}
            };
        Poly polinom = new Poly(polyArray);
        Poly polinom2 = new Poly(polyArray2);
        assertArrayEquals(result,polinom.multiplyPoly(polinom,polinom2));
    }
}
