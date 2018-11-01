// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: September 18th, 2016
// Filename: Letters.java
// Description: Print out block
//              letters.

public class Letters {
   
   public static void main(String[]args) {
      
      final String LETTER_S = "       ***\n      *\n       *\n        *\n     ***\n";  // Stores the art used into strings
      final String LETTER_W = "  *     *     *\n   *   * *   *\n    * *   * *\n     *     *\n";
      final String LETTER_I = "    *******\n       *\n       *\n       *\n       *\n    *******\n";
      final String LETTER_F = "    *******\n    *\n    *****\n    *\n    *\n";
      final String LETTER_T = "   *******\n      *\n      *\n      *\n      *\n";
      
      System.out.println(LETTER_S);  // Begins printing out letters from string
      System.out.println(LETTER_W);  // to form the word "SWIFT"
      System.out.println(LETTER_I);
      System.out.println(LETTER_F);
      System.out.println(LETTER_T);
      
   }
}