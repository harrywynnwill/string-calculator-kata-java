import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.Arrays;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;
public class StringCalculatorTest extends TestCase {
   private StringCalculator calc;
   private int[] digits = {1,2};
   private int[] negativeDigits = {-1,2};
   private int[] oneThousandDigits = {1000, 2};
   private int[] oneThousandDigitsRemoved = {2};



    protected void setUp() throws Exception {
      calc = new StringCalculator();
    }


  public void testTakesAnEmpty() throws Exception {
    assertEquals(0, calc.add(""));
  }

  public void testTakesOneNumber() throws Exception {
    assertEquals(1, calc.add("1"));
  }

  public void testTakesTwoNumbers() throws Exception {
    assertEquals(3, calc.add("1, 2"));
  }

  public void testStringConverter() throws Exception {
    assertArrayEquals(digits, calc.stringConvertor("1,2"));
  }

  public void testTotaller() throws Exception {
    assertEquals(3, calc.totaller(digits));
  }

  public void testHandlesUnknowNumbers() throws Exception {
    assertEquals(15, calc.add("1,2,3,4,5"));
  }

  public void testHandlesNewLine() throws Exception {
    assertEquals(6, calc.add("1,\n2,3"));
  }

  // public void testNegativeNumber() throws Exception {
  //
  //   assertEquals()
  // }
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void NegativesThrow() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("No Negative numbers");
    calc.add("-1,2,3");
  }

  public void testIgnoresNumbersAboveOneThousand() {
    assertEquals(2, calc.add("1000,2"));
  }

  public void testIsNegative() {
    assertEquals(true, calc.isNegative(negativeDigits));
  }

  public void testRemoveNumbersAboveOneThousand() {
    assertArrayEquals(oneThousandDigitsRemoved, calc.removeAboveOneThousand(oneThousandDigits));
  }



}
