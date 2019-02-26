package invariants.adts;

import org.junit.Test;
import static org.junit.Assert.*;

public class SparseMatrixTest {
    
    @Test
    public void transposeTest () {
        int [][] matrix = {
                { 0, 1, 2},
                { 1, 0, 0},
                { 2, 0, 1}
        };
        SparseMatrix sprMatrix = new SparseMatrix (matrix);
        int [][] result = {
                { 0, 0, 1, 2, 2},
                { 1, 2, 0, 0, 2},
                { 1, 2, 1, 2, 1}
        };
        assertArrayEquals(result, sprMatrix.transpose());
    }
    @Test
    public void symmetricalTest () {
        int [][] matrix = {
                { 0, 1, 2},
                { 1, 0, 0},
                { 2, 0, 1}
        };
        SparseMatrix sprMatrix = new SparseMatrix (matrix);
        boolean result = true;
        assertEquals(result, sprMatrix.symmetricalMatrix(sprMatrix));
    }
    
    @Test
    public void notSymmetricalTest () {
        int [][] matrix = {
                { 0, 1, 2, 0},
                { 1, 0, 0, 1},
                { 2, 0, 1, 0}
        };
        SparseMatrix sprMatrix = new SparseMatrix (matrix);
        boolean result = false;
        assertEquals(result, sprMatrix.symmetricalMatrix(sprMatrix));
    }
    
    @Test
    public void notSymmetricalTest2 () {
        int [][] matrix = {
                { 0, 1, 1},
                { 1, 0, 0},
                { 2, 0, 1}
        };
        SparseMatrix sprMatrix = new SparseMatrix (matrix);
        boolean result = false;
        assertEquals(result, sprMatrix.symmetricalMatrix(sprMatrix));
    }
    
    @Test
    public void multiplicationTest () {
        int [][] matrixA = {
                { 0, 1},
                { 1, 0}
        };
        int [][] matrixB = {
                { 0, 1, 1},
                { 1, 0, 1}
        };
        SparseMatrix sprMatrixA = new SparseMatrix (matrixA);
        SparseMatrix sprMatrixB = new SparseMatrix (matrixB);
        int [][] result = {
                { 0, 0, 1, 1},
                { 0, 2, 1, 2},
                { 1, 1, 1, 1}
        };
        assertArrayEquals(result, sprMatrixA.multiplication(sprMatrixB));
    }

}
