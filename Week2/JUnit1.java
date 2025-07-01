import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }
}