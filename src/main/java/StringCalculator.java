import java.util.stream.*;
import java.util.Arrays;

public class StringCalculator {

  private int[] digits;
  // set a boolean if delilmiter??

  public int add(String numbers){
    if(isEmpty(numbers))
    return 0;
    // System.out.println(numbers);
      stringConvertor(numbers);
    if(isNegative(digits))
      throw new IllegalArgumentException("No Negative numbers");
    digits = removeAboveOneThousand(digits);
    int total = totaller(digits);
    return total;
  }

  private boolean isEmpty(String numbers){
    return numbers == "";
  }

  public int[] stringConvertor(String numbers){
      // System.out.println(numbers);

      // extract this to its own method for single respons and also to check for delims before
      // it makes an int array (method doing spliting and inting )
    String[] numbersString = numbers.split("\\s*(=>|,|\\s)\\s*");
    // System.out.println(numbersString[0]);
    digits = new int[numbersString.length];
    for (int digit = 0; digit < numbersString.length; digit++){
      digits[digit] = Integer.parseInt(numbersString[digit]);
    }
    System.out.println(digits[0]);
    return digits;
  }

  public int totaller(int[] digits){
    int sum = IntStream.of(digits).sum();
    return sum;
  }

  public boolean isNegative(int[] digits) {
    boolean negatives = IntStream.of(digits).anyMatch(x -> x < 0);
    return negatives;
  }

  public int[] removeAboveOneThousand(int[] digits){
    int[] removed = Arrays.stream(digits)
      .filter(e -> e < 1000).toArray();
    return removed;
  }

  public boolean isDelimeter (String numbers){
    return true;
  }


}
