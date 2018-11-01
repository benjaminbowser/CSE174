// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: September 25th, 2016
// Filename: TriangleMath.java
// Description: Prompts the user
// for points of a triangle and
// find measurments of triangle.

import java.util.Scanner;

public class TriangleMath {
   
   public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      
      String name, side1, side2, side3; // declare strings
      double v1x, v1y, v2x, v2y, v3x, v3y, length1, length2, length3, perimeter; // declare variables
      double area, centroidx, centroidy, incirclerad, incirclearea;
      
      System.out.println("Enter a three letter name for your triangle:");
      name = input.next(); 
      side1 = name.substring(0,1);   
      side2 = name.substring(1,2);
      side3 = name.substring(2,3); // Assign strings letters
      
      side1 = side1.toUpperCase();
      side2 = side2.toUpperCase();
      side3 = side3.toUpperCase(); // force assigned letter to uppercase
      
      System.out.println("Coordinates of vertex " + side1);
      v1x = input.nextDouble(); // begin prompting for coordinates
      v1y = input.nextDouble();
      
      System.out.println("Coordinates of vertex " + side2);
      v2x = input.nextDouble();
      v2y = input.nextDouble();
      
      System.out.println("Coordinates of vertex " + side3);
      v3x = input.nextDouble();
      v3y = input.nextDouble();
      
      length1 = Math.sqrt( (Math.pow(v2x-v1x,2)) + (Math.pow(v2y-v1y,2)) ); // Find lengths
      length2 = Math.sqrt( (Math.pow(v3x-v2x,2)) + (Math.pow(v3y-v2y,2)) ); // Uses 2 & 3
      length3 = Math.sqrt( (Math.pow(v3x-v1x,2)) + (Math.pow(v3y-v1y,2)) ); // Uses 3 & 1
      
      System.out.println("--- Side lengths ---");
      System.out.printf(side1 + side2 + ": " +"%.3f\n", length1); // Prints out lengths from above
      System.out.printf(side2 + side3 + ": " +"%.3f\n", length2);
      System.out.printf(side3 + side1 + ": " +"%.3f\n", length3);
      
      perimeter = length1 + length2 + length3; // find perimeter
      area = (Math.sqrt((perimeter *.5) * ((perimeter * .5) - length1)*((perimeter * .5) - length2)*((perimeter * .5) - length3))); // area
      centroidx = ((v1x + v2x + v3x) / 3); // x coords added divided by 3
      centroidy = ((v1y + v2y + v3y) / 3); // y coords added divided by 3
      incirclerad = area / (.5*perimeter); // Area/1/2 perimeter
      incirclearea =  Math.PI * Math.pow(incirclerad,2); // Standard pi r^2 for area of circle
      
      System.out.println("--- Other measures ---");
      System.out.printf("Perimeter       = " + "%.3f\n",perimeter); 
      System.out.printf("Area            = " + "%.3f\n",area); 
      System.out.printf("Centroid        = (" + "%.3f",centroidx); 
      System.out.printf(", " +"%.3f",centroidy); 
      System.out.printf(") \n"); // allows proper formatting while keeping decimal restriction in place
      System.out.printf("Incircle Radius = " + "%.3f\n",incirclerad);
      System.out.printf("Incircle Area   = " + "%.3f\n",incirclearea);
   } // end of main
} // end of class
