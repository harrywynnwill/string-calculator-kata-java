import java.util.stream.*;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;



public class StringCalculator {

  private String delimiter;
  private int[] digits;
  private String[] numbersString;
  private String[] numbersStringNoDelims;
  private static final String DELIMITER = "//";


  public int add(String numbers){
    if(isEmpty(numbers))
      return 0;

      numbersString = stringSplitter(numbers);

    if(isDelimiter(numbersString)){
      delimiter = whichDelimiter(numbersString);
      System.out.println(delimiter);
      numbersStringNoDelims= removeDelimiterFromString(numbersString, delimiter);
      System.out.println(numbersStringNoDelims);
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
      boolean delilmiter = numbersString[0].contains(DELIMITER);
      return delilmiter;
  }


  public String[] removeDelimiter(String[] stringNumbers ) {
    String[] removedDelimiter = Arrays.stream(stringNumbers)
      .filter(e -> !e.contains(DELIMITER)).toArray(String[]::new);
         for (int digit = 0; digit < removedDelimiter.length; digit++){
         }
         return removedDelimiter;

   }

   public String whichDelimiter(String[] stringNumbers) {
     String delimiter = stringNumbers[0].replaceAll("[\\[\\]//]","");
     System.out.println(delimiter);
     return delimiter;
   }

   public String[] removeDelimiterFromString(String[] stringNumbers, String delimiter) {
      numbersStringNoDelims = removeDelimiter(stringNumbers);
      for (int digit = 0; digit < numbersStringNoDelims.length; digit++){
      // numbersStringNoDelims[digit] = numbersStringNoDelims[digit].replaceAll(delimiter, ",");
      }
      String answer = numbersStringNoDelims[0];
      System.out.println(answer);
      String[] answerArray = answer.split(",");
      return answerArray;
   }

}
