// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: September 18th, 2016
// Filename: VanCalculator.java
// Description: Van calculator to
//              see how many vans needed.

import java.util.Scanner;

public class VanCalculator {
   
   // This method of calculating the number of vans needed works with all numbers,
   // as long as they are within the limits of java. If the user inputs a number 
   // that is over an interval of 20, it will round up the number until it reaches 
   // the next interval of 20.
   
   public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      int people, vans;
      
      System.out.println("Vans hold 20 people.");
      System.out.println("How many people need a ride?");
      people = input.nextInt();
      
      vans = (people + 19) / 20;   // By using this formula, the decimal that is lost will be slightly
      // below the next whole number, resulting in a correct answer each 
      // time, regardless of the number used.
      System.out.println("You need " +vans +" vans.");
      
   }
}


