import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {
   private StringCalculator calc;

    protected void setUp() throws Exception {
      calc = new StringCalculator();
    }


  public void testTakesAnEmpty() throws Exception {
    assertEquals(0, calc.add(""));
  }
}
