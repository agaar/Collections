import org.junit.Test;

/**
 * Created by User on 2016-12-01.
 */

import static junit.framework.Assert.assertEquals;

public class CalculatorTest
{
    @Test
    public void shouldEvaluateConstants()
    {
        int result = Calculator.evaluate("1");
        assertEquals(1, result);
    }

    @Test
    public void shouldSupportAdding()
    {
        int result = Calculator.evaluate("1 + 2");
        assertEquals(3, result);
    }

    @Test
    public void shouldSupportSubtraction()
    {
        int result = Calculator.evaluate("1 - 2");
        assertEquals(-1, result);
    }

    @Test
    public void shouldComplexStatements()
    {
        int result = Calculator.evaluate("1 - 3 + 2 + 4");
        assertEquals(4, result);
    }
}
