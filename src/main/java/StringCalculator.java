import java.util.stream.*;

public class StringCalculator {

  public int add(String numbers){
    if(empty(numbers))
      return 0;
    int digits = stringConvertor(numbers);

  }

  private boolean empty(String numbers){
    return numbers == "";
  }

  private int stringConvertor(String numbers){
    String[] numbersString = numbers.split("\\s*(=>|,|\\s)\\s*");


    for (int i= 0; i < numbersString.length; i++){
      System.out.println(numbersString[i]);
    }

    return Integer.parseInt(numbersString);
  }

}
