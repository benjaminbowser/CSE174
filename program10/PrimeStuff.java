// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: November 13th, 2016
// Filename: PrimeStuff.java
// Description: Asks the user for 
// input numbers and checks them
// to prime number options.

import java.util.Scanner;

public class PrimeStuff {
  
  static Scanner in = new Scanner(System.in);  
  
  public static void main(String[] args) {
    menuCaller(); // Calls the menu
  }
  public static void menuCaller() {
    System.out.println("What would you like to do?");
    System.out.println("1) Check if a number is prime");
    System.out.println("2) Factor a number");
    System.out.println("3) List prime numbers");
    System.out.println("4) Quit");
    System.out.println("Choice: ");
    int menuChoice = in.nextInt();
    
    while (menuChoice < 1 || menuChoice > 4) { 
      System.out.println("**** INVALID OPTION **** ");
      menuCaller();
    }
    // Sort the input and send the user in the right direction
    if (menuChoice == 1) {
      long entry = primeValid(0);
      boolean valid = primeCheck(entry);
      System.out.println(primeResolver(valid, entry));
      menuCaller();
    }
    if (menuChoice == 2) {
      System.out.println(factorNums(0));
      menuCaller();
    }
    if (menuChoice == 3) {
      long firstPrime = primeListValid(0);
      long numPrint = primeNumber(0);
      long rows = primeRow(0);
      primeReturn(firstPrime, numPrint, rows);
      menuCaller();
    }
  }
  public static long primeValid(long inputNumber) {
    
    inputNumber = 0L; // Treats number as a long
    System.out.println("Enter a number between 1 and 9223372036854775807:");
    inputNumber = in.nextLong();
    
    while(inputNumber > 9223372036854775807L || inputNumber < 1) { // Checks for length issues, then reloops
      System.out.println("Enter a number between 1 and 9223372036854775807:");
      inputNumber = in.nextLong();
    }
    return inputNumber;
  }
  public static boolean primeCheck(long primeValid) {
    // Checks if the number is prime
    boolean response = true;
    if (primeValid == 1) {
      response = false;
    }
    long i;
    for(i = 2; i < primeValid; i++){
      long failChecker = primeValid % i;
      if (failChecker == 0) {
        response = false;
        i = primeValid;    
      }
    } // Close the for loop
    
    if (i == primeValid) { 
      response = true; 
    }
    return response;
  }
  
  public static String primeResolver(boolean primeCheck, long primeValid) {
    // Resolves the boolean to a string
    if (primeCheck == true) {
      return "---> " + primeValid + " is prime.";
    }
    else {
      return "---> " + primeValid + " is not prime.";
    }
  }
  
  public static String factorNums(long inputNumber) {
    // Write a while loop with an if statement inside of it, but
    // call back to primeCheck to determine if the number is prime.
    // If the number is not prime, dump it, do not + to string.
    System.out.println("Enter a number between 1 and 9223372036854775807: ");
    long userInput = in.nextLong();
    String factorList = "";
    int i = 1;
    
    while (userInput >= i) {
      if (userInput % i == 0) { // If userInput = 0, input is a factor
        boolean isPrime = primeCheck(i);
        if (isPrime == true) {
          factorList = factorList + i + " * ";
        }
      }
      i++;
    }
    factorList = "---> "+ userInput + " = " + factorList;
    int factorLength = factorList.length();
    factorList = factorList.substring(0, factorLength-3); // Removes the last * that occurs
    return factorList;
  }
  
  public static long primeListValid(long inputNumber) {
    // This method is required and cannot reuse the prime valid
    // method from above because the println text is different.
    
    inputNumber = 0L;
    System.out.println("Enter starting number between 1 and 9223372036854775807: ");
    inputNumber = in.nextLong();
    
    while(inputNumber > 9223372036854775807L || inputNumber < 1) { // Checks for length issues, then reloops
      System.out.println("Enter starting number between 1 and 9223372036854775807: ");
      inputNumber = in.nextLong();
    }
    return inputNumber;
  }
  
  public static long primeNumber(long inputNumber) {
    inputNumber = 0L; // Makes sure number is a long
    System.out.println("How many primes (1-1000): ");
    inputNumber = in.nextLong();
    
    while(inputNumber > 1000L || inputNumber < 1) { // Checks for length issues, then reloops
      System.out.println("How many primes (1-1000): ");
      inputNumber = in.nextLong();
    }
    return inputNumber;
  }
  
  public static long primeRow(long inputNumber) {
    inputNumber = 0L; // Makes sure number is a long
    System.out.println("How many primes per row (1-20): ");
    inputNumber = in.nextLong();
    
    while(inputNumber > 20 || inputNumber < 1) { // Checks for length issues, then reloops
      System.out.println("How many primes per row (1-20): ");
      inputNumber = in.nextLong();
    }
    return inputNumber;
  }  
  
  public static void primeReturn(long firstPrime, long numPrint, long rows) {
    int spacer = 0;
    int counter = 0;
    for (int i = 0; i < numPrint; i++) {
      if (primeCheck(firstPrime + spacer)) {
        System.out.print(firstPrime + spacer + " "); // Adds the input value as requested in instructions
        if (counter % rows == 0)
          System.out.println(); // Creates a new line 
        counter++;
      }
      else i--; // Not a prime value, subtract
      spacer++;
    }
    // Adds a line at the end for spacing before calling the menu again
    System.out.println(); 
  }
}