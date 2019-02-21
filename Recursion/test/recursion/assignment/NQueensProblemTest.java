package recursion.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NQueensProblemTest {
    private int inputDimension;
    private Boolean expectedResult;
        
    public NQueensProblemTest (int input, Boolean expected){
        this.inputDimension = input;
        this.expectedResult = expected;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[] []{     
            {2, false},
            {3, false},
            {4, true},
            {5, true},
           });
    }
    
    @Test
    public void nQueensProblemTest(){
        NQueensProblem nProblem = new NQueensProblem();
        assertEquals(expectedResult, nProblem.solutionNQueens(inputDimension));
    }
}
