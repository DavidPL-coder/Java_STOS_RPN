import org.junit.*;
import static org.junit.Assert.*;

public class ReversePolishCalculatorTest {
    @Test
    public void testAddNumbers() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        int result = calculator.calculate("2 3 +");

        assertEquals("expression should be equals 5", 5, result);
    }

    @Test
    public void testSubtractNumbers() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        int result = calculator.calculate("4 1 -");

        assertEquals("expression should be equals 3", 3, result);
    }

    @Test
    public void testMultiplyNumbers() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        int result = calculator.calculate("3 2 *");

        assertEquals("expression should be equals 6", 6, result);
    }

    @Test
    public void testDivideNumbers() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        int result = calculator.calculate("8 4 /");

        assertEquals("expression should be equals 2", 2, result);
    }

    @Test
    public void testCalculateUsingManyOperators() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        int result = calculator.calculate("29 5 10 8 4 / * + -");

        assertEquals("expression should be equals 4", 4, result);
    }

    @Test
    public void testCalculateWhenExpressionDoesNotHaveOperatorsAndNumbers() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        IllegalArgumentException exceptionForNull = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(null));
        assertEquals("Expression is null or empty", exceptionForNull.getMessage());

        IllegalArgumentException exceptionForEmpty = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(""));
        assertEquals("Expression is null or empty", exceptionForEmpty.getMessage());

        IllegalArgumentException exceptionForWhitespaces = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("\t \t \t"));
        assertEquals("Expression is null or empty", exceptionForWhitespaces.getMessage());
    }

    @Test
    public void testCalculateWhenCalculatedValuesAreNegative() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        int result = calculator.calculate("0 1 - 0 2 - +");

        assertEquals("expression should be equals -3", -3, result);
    }

    @Test
    public void testCalculateWhenExpressionHasManyWhitespaces() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        int result = calculator.calculate("\t \t3 8   *\t5\t-  \t");

        assertEquals("expression should be equals 19", 19, result);
    }

    @Test
    public void testCalculateWhenNotEnoughNumbersBeforeOperator() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("- 2 3"));
        assertEquals("Not enough numbers in expression", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("2 -"));
        assertEquals("Not enough numbers in expression", ex2.getMessage());
    }

    @Test
    public void testCalculateWhenExpressionHasInvalidOperatorOrLetters() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("2 3 |"));
        assertEquals("Invalid operator in expression", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("a 2 3 +"));
        assertEquals("Invalid operator in expression", ex2.getMessage());
    }

    @Test
    public void testCalculateWhenNotEnoughOperators() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1 2 3 +"));
        assertEquals("Not enough operators in expression so stack has more than one number after calculating", ex.getMessage());
    }

    @Test
    public void testCalculateWhenThereIsDividingByZero() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1 0 /"));
        assertEquals("Cannot divide by zero", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1 3 3 - /"));
        assertEquals("Cannot divide by zero", ex2.getMessage());
    }

    @Test
    public void testCalculateWhenCalculatedValuesAreHigherThanIntMax() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calculator.calculate("2147483647 1 +"));
        assertEquals("The calculated values are outside the range of the Int type", ex.getMessage());
    }

    @Test
    public void testCalculateWhenCalculatedValuesAreLowerThanIntMin() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calculator.calculate("0 2147483647 - 0 2 - +"));
        assertEquals("The calculated values are outside the range of the Int type", ex.getMessage());
    }

    @Test
    public void testCalculateWhenAtLeastOneOfProvidedNumberIsHigherThanIntMax() {
        ReversePolishCalculator calculator = new ReversePolishCalculator();

        NumberFormatException ex = assertThrows(NumberFormatException.class, () -> calculator.calculate("2147483648 0 +"));
        assertEquals("The given number outside the range of type int", ex.getMessage());
    }
}