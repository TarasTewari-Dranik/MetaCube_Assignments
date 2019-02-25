package abstr.and.cocrete.data.types;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IsMemberTest {
    
    @Test
    public void testIsMember () {
        int[] a= {1,3,3,4,7,8,5,1};
        intSet newSet = new intSet(a);
        int x = 3;
        boolean result = true;
        assertEquals(result,newSet.isMember(x));
        
    }
    
    @Test
    public void testIsNotMember () {
        int[] a= {1,3,3,4,7,8,5,1};
        intSet newSet = new intSet(a);
        int x = 10;
        boolean result = false;
        assertEquals(result,newSet.isMember(x));
        
    }
    
    @Test
    public void testSize () {
        int[] a= {1,3,3,4,7,8,5,1};
        intSet newSet = new intSet(a);
        int result = 6;
        assertEquals(result,newSet.size());
        
    }
    

}
