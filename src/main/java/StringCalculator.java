import java.util.stream.*;

public class StringCalculator {

  private int[] digits;

  public int add(String numbers){
    // if(empty(numbers))

      return 0;
  }

  private boolean empty(String numbers){
    return numbers == "";
  }



  public int[] stringConvertor(String numbers){
    String[] numbersString = numbers.split("\\s*(=>|,|\\s)\\s*");
    digits = new int[numbersString.length];
    for (int digit = 0; digit < numbersString.length; digit++){
      digits[digit] = Integer.parseInt(numbersString[digit]);
    }
    return digits;
  }

}
