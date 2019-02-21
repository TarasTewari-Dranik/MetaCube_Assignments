package recursion.assignment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class LcmAndHcfTest {
    
    @RunWith(Parameterized.class)
    public static class HcfTest {
        private int inputFirstNumber;
        private int inputSecondNumber;
        private int expectedResult;
        
        public HcfTest (int inputFirst, int inputSecond, int expected){
            this.inputFirstNumber = inputFirst;
            this.inputSecondNumber = inputSecond;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {0, 5, 5},
                {10, 90, 10},
                {25, 30, 5},
               });
        }
        
        @Test
        public void hcfTest(){
            LcmAndHcf mathematicalProblems = new LcmAndHcf();
            assertEquals(expectedResult, mathematicalProblems.highestCommonFactor(inputFirstNumber,inputSecondNumber));
        }
    }
    
    
    @RunWith(Parameterized.class)
    public static class LcmTest {
        private int inputFirstNumber;
        private int inputSecondNumber;
        private int expectedResult;
        
        public LcmTest (int inputFirst, int inputSecond, int expected){
            this.inputFirstNumber = inputFirst;
            this.inputSecondNumber = inputSecond;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {0, 5, 0},
                {10, 90, 90},
                {25, 30, 150},
               });
        }
        
        @Test
        public void hcfTest(){
            LcmAndHcf mathematicalProblems = new LcmAndHcf();
            assertEquals(expectedResult, mathematicalProblems.leastCommonMultiple(inputFirstNumber,inputSecondNumber));
        }
    }

}
