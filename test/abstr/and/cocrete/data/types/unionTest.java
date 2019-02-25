package abstr.and.cocrete.data.types;

import static org.junit.Assert.*;

import org.junit.Test;

public class unionTest {
    
    @Test
    public void testUnion () {
        int[] a= {1,3,3,4,7,8,5,1};
        int [] b = {5,6};
        int [] union= {1,3,4,7,8,5,6};
        intSet newSet = new intSet(a);
        intSet unionSet = new intSet(b);
        assertArrayEquals(union,newSet.union(unionSet));
        
    }
    

}
