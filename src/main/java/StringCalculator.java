import java.util.stream.*;
import java.util.Arrays;

public class StringCalculator {

  private int[] digits;

  public int add(String numbers){
    if(empty(numbers))
    return 0;
      stringConvertor(numbers);
    if(isNegative(digits))
      throw new IllegalArgumentException("No Negative numbers");
    digits = removeAboveOneThousand(digits);  
    int total = totaller(digits);
    return total;
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


}
