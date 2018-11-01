// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: October 9th, 2016
// Filename: MathGame.java
// Description: Takes max numbers and gives the
// user multiplication & division problems that 
// will not exceed the inputted numbers.

import java.util.Scanner;

public class MathGame {
   public static void main(String args []) {
      
      Scanner keyboard = new Scanner(System.in);
      
      int multLimit, mult, multRoot, divLimit, userAnswer, solution, multCount = 0, divCount = 0, totalCount, divRoot, div, answerToSwap;
      double multPercent, divPercent, totalPercent;
      
      // multCount and divCount both are assigned 0 because they must be initialized 
      // before multCount++ and divCount++ will work
      
      System.out.println("Welcome to my Math Quiz!");
      System.out.println("This quiz will give you three multiplication problems,\nand then three division problems.");
      System.out.println("-----------------------------------------------------");
      
      System.out.println("Enter the multiplication limit:");
      multLimit = keyboard.nextInt(); 
      System.out.println("Enter the division limit:");
      divLimit = keyboard.nextInt();
      
      System.out.println("The timer starts...now!\n");
      long timeStart = System.currentTimeMillis();
      
      System.out.println("-MULTIPLICATION--------------------------------------");
      
      // First question
      multRoot = (int)((Math.sqrt(multLimit*Math.random()))) +1;
      mult = (int)(1 + multRoot * Math.random());
      // Takes the multiplication limit, multiplies it by a random number,
      // with a square root of the answer, then adds 1. (int) added because
      // we don't want decimals in the problem.
      
      System.out.println(multRoot + " * " + mult + " = ");
      userAnswer = keyboard.nextInt();
      
      solution = multRoot * mult;
      
      if (userAnswer == solution) {
         multCount++;
         System.out.println("Yes! You have " + multCount + " correct so far.");
      }
      else {
         System.out.println("Sorry, " +multRoot + " * " +mult +" = "+solution);
      }
      // Solves the problem and stores it in solution, then checks if the input
      // is equal to the solution. If correct, the value in multCount is increased
      // by 1, then displays number correct. If the user enters an incorrect answer,
      // the else statement will tell them the answer.
      
      // Second Question
      multRoot = (int)((Math.sqrt(multLimit*Math.random()))) +1;
      mult = (int)(1 + multRoot * Math.random());
      
      System.out.println(multRoot + " * " + mult + " = ");
      userAnswer = keyboard.nextInt();
      
      solution = multRoot * mult;
      
      if (userAnswer == solution) {
         multCount++;
         System.out.println("Yes! You have " + multCount + " correct so far.");
      }
      else {
         System.out.println("Sorry, " +multRoot + " * " +mult +" = "+solution);
      }
      
      // Third Question
      multRoot = (int)((Math.sqrt(multLimit*Math.random()))) +1;
      mult = (int)(1 + multRoot * Math.random());
      
      System.out.println(multRoot + " * " + mult + " = ");
      userAnswer = keyboard.nextInt();
      
      solution = multRoot * mult;
      
      if (userAnswer == solution) {
         multCount++;
         System.out.println("Yes! You have " + multCount + " correct so far.");
      }
      else {
         System.out.println("Sorry, " +multRoot + " * " +mult +" = "+solution);
      }
      
      // End of multiplication area
      // Start of division area
      
      System.out.println("-DIVISION--------------------------------------------");
      // First question
      divRoot = (int)((Math.sqrt(divLimit*Math.random())));
      div = (int)(1 + divRoot * Math.random());
      answerToSwap = div * divRoot;
      solution = answerToSwap / div;
      
      System.out.println(answerToSwap + " / " + div + " = ");
      userAnswer = keyboard.nextInt();

      if (userAnswer == solution) {
         divCount++;
         System.out.println("Yes! You have " + divCount + " correct so far.");
      }
      else {
         System.out.println("Sorry, " +answerToSwap + " / " +div +" = "+solution);
      }
      
      // Division problems have more content than the multiplication do because
      // of swapping. The computational formulas are similar to multiplication
      // but once the numbers are generated, they are multiplied together. The user
      // is shown the product and one of the random numbers.
      
      // Second question
      divRoot = (int)((Math.sqrt(divLimit*Math.random())));
      div = (int)(1 + divRoot * Math.random());
      answerToSwap = div * divRoot;
      solution = answerToSwap / div;
      
      System.out.println(answerToSwap + " / " + div + " = ");
      userAnswer = keyboard.nextInt();
      
      if (userAnswer == solution) {
         divCount++;
         System.out.println("Yes! You have " + divCount + " correct so far.");
      }
      else {
         System.out.println("Sorry, " +answerToSwap + " / " +div +" = "+solution);
      }
      
      // Third question
      divRoot = (int)((Math.sqrt(divLimit*Math.random())));
      div = (int)(1 + divRoot * Math.random());
      answerToSwap = div * divRoot;
      solution = answerToSwap / div;
      
      System.out.println(answerToSwap + " / " + div + " = ");
      userAnswer = keyboard.nextInt();
      
      if (userAnswer == solution) {
         divCount++;
         System.out.println("Yes! You have " + divCount + " correct so far.");
      }
      else {
         System.out.println("Sorry, " +answerToSwap + " / " +div +" = "+solution);
      }
      
      // End of Division area
      long timeEnd = System.currentTimeMillis();
      long timeElapsed = timeEnd - timeStart;
      timeElapsed = timeElapsed / 1000;
      System.out.println("The timer stops... now! You answered in " +timeElapsed + " seconds!");
      // The timer will record the time that it ends, then will calculate how much time has
      // passed between the start and finish. This number is divided by 1000 because the original
      // number is in milliseconds.
      
      System.out.println("-RESULTS---------------------------------------------");
      multPercent = (multCount / 3.0) * 100; 
      divPercent = (divCount / 3.0) * 100;
      totalPercent = ((multCount + divCount) / 6.0) * 100;
      totalCount = multCount + divCount;
      // Multiply by 100 because we are returning a percent
      // Must escape the % sign because printf is used below
      System.out.printf("Multiplication score: %d out of 3 (%.3f"+ "%%)" +"\n", multCount, multPercent); 
      System.out.printf("Division score: %d out of 3 (%.3f"+ "%%)" +"\n", divCount, divPercent); 
      System.out.printf("Overall score: %d out of 6 (%.3f"+ "%%)" +"\n", totalCount, totalPercent);      
      
   }  
}