package abstr.and.cocrete.data.types;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsSubSetTest {
    private int[] inputArray;
    private int[] subSetArray;
    private boolean expectedResult;
    
    public IsSubSetTest (int[] input, int[] subSet, boolean expected){
        this.inputArray = input;
        this.subSetArray = subSet;
        this.expectedResult = expected;
    }
    
    
    
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[] []{     
            {new int [] {1, 2, 2, 3, 4, 4}, new int[] {1,2}, true },
            {new int [] {1, 2, 2, 3, 4, 4}, new int[] {5,6,10,12,56}, false },
            {new int [] {1, 2, 2, 3, 4, 4}, new int[] {5,6}, false },
           });
    }
    
    
    
    @Test
    public void testIsSubSet() {
        intSet newSet = new intSet(inputArray);
        intSet newSubSet = new intSet(subSetArray);
        assertEquals(expectedResult, newSet.isSubSet(newSubSet));
        
    }

}
