import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Arrange - Setup before each test
        calculator = new Calculator();
        System.out.println("Setup complete!");
    }

    @After
    public void tearDown() {
        // Teardown - Cleanup after each test
        calculator = null;
        System.out.println("Teardown complete!");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }
}

