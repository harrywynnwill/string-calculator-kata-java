import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {
   private StringCalculator calc;

    protected void setUp() throws Exception {
      calc = new StringCalculator();
    }


  // public void testTakesAnEmpty() throws Exception {
  //   assertEquals(0, calc.add(""));
  // }
  //
  //  public void testTakesOneNumber() throws Exception {
  //   assertEquals(1, calc.add("1"));
  // }

  public void testTakesTwoNumbers() throws Exception {
    assertEquals(3, calc.add("1, 2"));
  }


}
