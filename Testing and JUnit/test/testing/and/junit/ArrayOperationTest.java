package testing.and.junit;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class ArrayOperationTest {
    
    @RunWith(Parameterized.class)
    public static class MaxMirrorTest {
        private Integer[] inputArray;
        private Integer expectedResult;
        
        public MaxMirrorTest (Integer[] input, Integer expected){
            this.inputArray = input;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {new Integer [] {1, 2, 3, 8, 9, 3, 2, 1}, 3},
                {new Integer [] {7, 1, 4, 9, 7, 4, 1},2},
                {new Integer [] {1, 2, 1, 4}, 3},
                {new Integer [] {1, 4, 5, 3, 5, 4, 1}, 7}
               });
        }
        
        @Test
        public void maxMirrorTest(){
            assertEquals(expectedResult, ArrayOperation.maxMirror(inputArray));
        }
    }
    
    @RunWith(Parameterized.class)
    public static class CountClumpsTest {
        private Integer[] inputArray;
        private Integer expectedResult;
        
        public CountClumpsTest (Integer[] input, Integer expected){
            this.inputArray = input;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {new Integer [] {1, 2, 2, 3, 4, 4}, 2},
                {new Integer [] {1, 1, 2, 1, 1},2},
                {new Integer [] {1, 1, 1, 1, 1}, 1},
               });
        }
        
        @Test
        public void countClumpsTest(){
            assertEquals(expectedResult, ArrayOperation.countClumps(inputArray));
        }
    }
    
    @RunWith(Parameterized.class)
    public static class FixXYTest {
        private Integer[] inputArray;
        private Integer[] expectedResult;
        
        public FixXYTest (Integer[] input, Integer[] expected){
            this.inputArray = input;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {new Integer [] {5, 4, 9, 4, 9, 5}, new Integer [] {9, 4, 5, 4, 5, 9}},
                {new Integer [] {1, 4, 1, 5}, new Integer [] {1, 4, 5, 1}},
                {new Integer [] {1, 4, 1, 5, 5, 4, 1}, new Integer [] {1, 4, 5, 1, 1, 4, 5}},
               });
        }
        
        @Test
        public void fixXYTest(){
            assertArrayEquals(expectedResult, ArrayOperation.fixXY(inputArray,4,5));
        }
    }
    
    @RunWith(Parameterized.class)
    public static class SplitArrayTest {
        private Integer[] inputArray;
        private Integer expectedResult;
        
        public SplitArrayTest (Integer[] input, Integer expected){
            this.inputArray = input;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {new Integer [] {1, 1, 1, 2, 1}, 3},
                {new Integer [] {2, 1, 1, 2, 1},-1},
                {new Integer [] {10, 10}, 1},
               });
        }
        
        @Test
        public void splitArrayTest(){
            assertEquals(expectedResult, ArrayOperation.splitArray(inputArray));
        }

    }
    
    public static class errorTest {
        
        @Test(expected = NullPointerException.class)
        public void maxMirrorEmptyArrayTest(){
            Integer[] testArray = new Integer[0];
            ArrayOperation.maxMirror(testArray);
        }
        
        @Test(expected = NullPointerException.class)
        public void countClumpsEmptyArrayTest(){
            Integer[] testArray = new Integer[0];
            ArrayOperation.countClumps(testArray);
        }
        
        @Test(expected = AssertionError.class)
        public void fixXYEmptyArrayTest(){
            Integer[] testArray = new Integer[0];
            ArrayOperation.fixXY(testArray,4,5);
        }
        
        @Test(expected = AssertionError.class)
        public void unequalXAndYFixXYTest(){
            Integer[] testArray = {1, 4, 1, 0, 5, 4, 1};
            ArrayOperation.fixXY(testArray,4,5);
        }
        
        @Test(expected = AssertionError.class)
        public void twoAdjacentsXFixXYTest(){
            Integer[] testArray = {1, 4, 4, 1, 5, 5, 1};
            ArrayOperation.fixXY(testArray,4,5);
        }
        
        @Test(expected = AssertionError.class)
        public void xLastFixXYTest(){
            Integer[] testArray = {1, 4, 1, 5, 5, 1, 4};
            ArrayOperation.fixXY(testArray,4,5);
        }
        
        @Test(expected = NullPointerException.class)
        public void splitArrayEmptyArrayTest(){
            Integer[] testArray = new Integer[0];
            ArrayOperation.splitArray(testArray);
        }
    }
}
