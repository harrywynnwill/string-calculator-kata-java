import java.util.stream.*;
import java.util.Arrays;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;



public class StringCalculator {

  private int[] digits;
  private String[] numbersString;
  private String[] numbersStringNoDelims;
  // set a boolean if delilmiter??

  public int add(String numbers){
    if(isEmpty(numbers))
      return 0;
    numbersString = stringSplitter(numbers);



    // for ( int i =0 ; i < numbersString.length; i++){
    //
    //   System.out.println(numbersString[i]);
    // }


    if(isDelimiter(numbersString))
      numbersStringNoDelims= removeDelimiterFromString(numbersString);
      stringConvertor(numbersStringNoDelims);
    if(isNegative(digits))
      throw new IllegalArgumentException("No Negative numbers");
    digits = removeAboveOneThousand(digits);
    int total = totaller(digits);
    return total;
  }

  private boolean isEmpty(String numbers){
    return numbers == "";
  }

  public int[] stringConvertor(String[] numbersString){
    String numbers = numbersString[0];
    System.out.println(numbers);

    String[] items = numbers.split(",");
    for (int digit = 0; digit < items.length; digit++){

       System.out.println(items[digit]);

    }


    digits = new int[items.length];
    for (int digit = 0; digit < items.length; digit++){

      // System.out.println(numbersString[digit]);
      digits[digit] = Integer.parseInt(items[digit]);
    }
    // System.out.println(digits[0]);
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
      boolean delilmiter = numbersString[0].equals("//[***]");
      return delilmiter;
  }


  public String[] removeDelimiter(String[] stringNumbers ) {
    // String[] removeddelimiter = ArrayUtils.removeElement(stringNumbers, 0);

    String[] removedDelimiter = Arrays.stream(stringNumbers)
      .filter(e -> !e.equals("//[***]")).toArray(String[]::new);

     return removedDelimiter;

   }

   public String whichDelimiter(String[] stringNumbers) {
     String delimiter = stringNumbers[0].replaceAll("[\\[\\]//]","");
     return delimiter;
   }

   public String[] removeDelimiterFromString(String[] stringNumbers) {
      String delimiter = whichDelimiter(stringNumbers);
      numbersStringNoDelims = removeDelimiter(stringNumbers);
      for (int digit = 0; digit < numbersStringNoDelims.length; digit++){
      numbersStringNoDelims[digit] = numbersStringNoDelims[digit].replaceAll("\\*\\*\\*", ",");
    }
      return numbersStringNoDelims;
   }




  // public static String[] removedelimiters(String[] numbersString) {
  //   for (int digit = 0; digit < numbersString.length; digit++){
  //     System.out.println(numbersString[digit]);
  //   }
  //  numbersString = ArrayUtils.remove(numbersString, 0);
  //  //removeElement(numbersString,"//[***]");
  //
  //   //  .filter(e -> e == "//[***]").toArray(String[]::new);
  //
  //     for (int digit = 0; digit < numbersString.length; digit++){
  //       System.out.println(numbersString[digit]);
  //     }
  //   return numbersString;
  // }

}
