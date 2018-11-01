// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: September 18th, 2016
// Filename: LineSegment.java
// Description: Prompt the user for 2 points with
//              calculation for midpoint and slope.

import java.util.Scanner;

public class LineSegment {
   
   public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      double firstx, secondx, firsty, secondy, midpointx, midpointy, slope;
      
      System.out.println("POINT 1: Enter x and y: "); 
      firstx = input.nextDouble();
      firsty = input.nextDouble(); // Use two doubles in a row to allow space between
      
      System.out.println("POINT 2: Enter x and y: ");
      secondx = input.nextDouble();
      secondy = input.nextDouble();
      
      System.out.println("Your points: ("+firstx + ", " +firsty +") and (" +secondx + ", " +secondy + ")"); // Reads points back out
      
      midpointx = (firstx + secondx) / 2;
      midpointy = (firsty + secondy) / 2;  // Midpoint formulas used
      slope = ((firsty - secondy) / (firstx - secondx)); // Slope formula
      
      System.out.println("Midpoint: (" +midpointx + ", " +midpointy +")");
      System.out.println("Slope: " +slope); // Output answer
      
   }
}

