package recursion.assignment;


import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class SearchTest {

    
    @RunWith(Parameterized.class)
    public static class LinearSearchTest { 
        private int[] inputArray;
        private int inputElement;
        private int expectedResult;

        public LinearSearchTest (int[] input, int element, int expected){
            this.inputArray = input;
            this.inputElement = element;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {new int [] {5, 6, 7, 8, 9, 10, 1 ,0}, 5, 0},
                {new int [] {5, 6, 7, 8, 9, 10, 1 ,0}, 0, 7},
                {new int [] {5, 6, 7, 8, 9, 10, 1 ,0}, 8, 3},
               });
        }
        
        @Test
        public void linearSearchTest(){
            Search elementSearch = new Search();
            assertEquals(expectedResult, elementSearch.linearSearch(inputArray,inputElement));
        }
    }
    
    @RunWith(Parameterized.class)
    public static class BinarySearchTest { 
        private int[] inputArray;
        private int inputElement;
        private int expectedResult;

        public BinarySearchTest (int[] input, int element, int expected){
            this.inputArray = input;
            this.inputElement = element;
            this.expectedResult = expected;
        }
        
        @Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[] []{     
                {new int [] {0, 1, 2, 25, 45, 67, 100, 370, 1000}, 0, 0},
                {new int [] {0, 1, 2, 25, 45, 67, 100, 370, 1000}, 45, 4},
                {new int [] {0, 1, 2, 25, 45, 67, 100, 370, 1000}, 1000, 8},
                {new int [] {0, 1, 2, 25, 45, 67, 100, 370}, 25, 3},
               });
        }
        
        @Test
        public void binarySearchTest(){
            Search elementSearch = new Search();
            assertEquals(expectedResult, elementSearch.binarySearch(inputArray,inputElement));
        }
    }
    
    public static class ErrorTest {

        @Test(expected = AssertionError.class)
        public void linearSearchEmptyArrayTest(){
            int[] testArray = new int[0];
            Search elementSearch = new Search();
            elementSearch.linearSearch(testArray,4);
        }
        
        @Test(expected = AssertionError.class)
        public void linearSearchNoMatchArrayTest(){
            int[] testArray = {5, 6, 7, 8, 9, 10, 1 ,0};
            Search elementSearch = new Search();
            elementSearch.linearSearch(testArray,4);
        }
        
        @Test(expected = AssertionError.class)
        public void binarySearchEmptyArrayTest(){
            int[] testArray = new int[0];
            Search elementSearch = new Search();
            elementSearch.binarySearch(testArray,4);
        }
        
        @Test(expected = AssertionError.class)
        public void binarySearchNoMatchArrayTest(){
            int[] testArray = {0, 1, 2, 25, 45, 67, 100, 370, 1000};
            Search elementSearch = new Search();
            elementSearch.linearSearch(testArray,4);
        }
    }

}
