import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import java.util.Arrays;



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

  // public void testTakesTwoNumbers() throws Exception {
  //   assertEquals(3, calc.add("1, 2"));
  // }

  public void testStringConverter() throws Exception {
      int[] expectedArray = {1,2};
      assertArrayEquals(expectedArray, calc.stringConvertor("1,2"));
  }



}
