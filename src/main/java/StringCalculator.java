import java.util.stream.*;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;



public class StringCalculator {

  private int[] digits;
  private String[] numbersString;
  private String[] numbersStringNoDelims;

  public int add(String numbers){
    if(isEmpty(numbers))
      return 0;

      numbersString = stringSplitter(numbers);

    if(isDelimiter(numbersString)){
      numbersStringNoDelims= removeDelimiterFromString(numbersString);
      stringConvertor(numbersStringNoDelims);
    }

    if(!isDelimiter(numbersString)) {
      stringConvertor(numbersString);
    }

    if(isNegative(digits)){
      throw new IllegalArgumentException("No Negative numbers");
    }

    digits = removeAboveOneThousand(digits);
    int total = totaller(digits);
    return total;
  }

  private boolean isEmpty(String numbers){
    return numbers == "";
  }

  public int[] stringConvertor(String[] numbersString){
    digits = new int[numbersString.length];
    for (int digit = 0; digit < numbersString.length; digit++){
      digits[digit] = Integer.parseInt(numbersString[digit]);
    }
    return digits;
  }

  public String[] stringSplitter(String numbers){
    numbersString = numbers.split("\\s*(=>|,|\\s)\\s*");
    return numbersString;
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

  public boolean isDelimiter (String[] numbersString){
      System.out.println(numbersString[0]);
      boolean delilmiter = numbersString[0].contains("//");
      // boolean delilmiter = numbersString[0].equals("//[***]");
      return delilmiter;
  }


  public String[] removeDelimiter(String[] stringNumbers ) {
    String[] removedDelimiter = Arrays.stream(stringNumbers)
      .filter(e -> !e.equals("//[***]")).toArray(String[]::new);
         for (int digit = 0; digit < removedDelimiter.length; digit++){
         }
         return removedDelimiter;
   }

   public String whichDelimiter(String[] stringNumbers) {
     String delimiter = stringNumbers[0].replaceAll("[\\[\\]//]","");
    //  System.out.println(delimiter);
     return delimiter;
   }

   public String[] removeDelimiterFromString(String[] stringNumbers) {
      String delimiter = whichDelimiter(stringNumbers);
      numbersStringNoDelims = removeDelimiter(stringNumbers);
      for (int digit = 0; digit < numbersStringNoDelims.length; digit++){
      numbersStringNoDelims[digit] = numbersStringNoDelims[digit].replaceAll("\\*\\*\\*", ",");
      }
      String answer = numbersStringNoDelims[0];
      String[] answerArray = answer.split(",");
      return answerArray;
   }

}
