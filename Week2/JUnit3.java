import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        
        assertEquals(5, 2 + 3);

        
        assertTrue(5 > 3);

        
        assertFalse(5 < 3);

        
        Object obj = null;
        assertNull(obj);

        
        Object newObj = new Object();
        assertNotNull(newObj);

        
        String str = "hello";
        String sameStr = str;
        assertSame(str, sameStr);

        
        String a = new String("test");
        String b = new String("test");
        assertNotSame(a, b);

        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }
}
