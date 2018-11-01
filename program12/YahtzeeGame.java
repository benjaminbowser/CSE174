// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: December 4th, 2016
// Filename: YahtzeeGame.java
// Description: Allows the user
// to play Yahtzee in java

import java.util.Scanner;
import java.util.Arrays;

public class YahtzeeGame {
   // Create a global scanner any method can access
   static Scanner in = new Scanner(System.in);
   
   public static void main(String[] args) {
      // Create dice and begin the game
      int[] dice = new int[5];
      rollHandler(dice);
   }
   
   // Handle the rolls and asking if user wants to
   // play again. Also keep track of roll number so far.
   public static void rollHandler(int[] dice) {
      int rolls = 1;
      while (rolls <= 2) {
         if (rolls == 1) {
            System.out.println("Welcome to Yahtzee!");
            roll(dice);
         }
         System.out.print("Roll #" + rolls + ": ");
         System.out.println(toString(dice));
         scoreChoices(dice);
         rolls++;
         System.out.println("Roll Again?");
         String again = in.next().toLowerCase();
         while(validAgain(again) != true) { 
            System.out.println("Roll Again?");
            again = in.next();
         }
         if (again.equals("n")) {
            System.out.println("Your score is " +maxScore(dice) +". Goodbye."); // Line 17
            rolls = 4;
         }
         if (again.equals("y")) reroll(dice);
      }
      if (rolls == 3) {
         System.out.print("Roll #" + rolls + ": ");
         System.out.println(toString(dice));
         scoreChoices(dice);
         System.out.println("Your score is " +maxScore(dice) +". Goodbye.");
      }
   }
   
   // Throws the dice with random ints b/w 1-6
   public static void roll(int[] dice) {
      dice[0] = (int)(6 * Math.random() + 1);
      dice[1] = (int)(6 * Math.random() + 1);
      dice[2] = (int)(6 * Math.random() + 1);
      dice[3] = (int)(6 * Math.random() + 1);
      dice[4] = (int)(6 * Math.random() + 1);
      sort(dice);
   }
   
   // Sort the array of dice using
   // the bubble sort method
   public static void sort(int[] dice) {
      boolean swap = true;
      int pass = 0;
      
      while (swap && pass < dice.length - 1) {
         swap = false;
         
         for (int i = 0; i < dice.length - 1 - pass; i++) {
            
            if (dice[i] > dice[i + 1]) {
               int store = dice[i];
               dice[i] = dice[i + 1];
               dice[i + 1] = store;
               swap = true;
            }
         }
         pass++;
      }
      toString(dice);
   }
   
   // Converts the array to a string and cuts off 
   // brackets and removes commas
   public static String toString(int[] dice) {
      String reply = Arrays.toString(dice);
      int length = reply.length();
      reply = reply.substring(1, length - 1); // Remove brackets
      reply = reply.replace(",", ""); // Remove commas
      return reply;
   }
   
   // Check if the prompt asking if the user wants to
   // roll again is a valid entry
   public static boolean validAgain(String again) {
      if (again.length() != 1) {
         return false;
      }
      if (again.charAt(0) != 'n') {
         if (again.charAt(0) != 'y') {
            return false;
         }
      }
      return true;  
   }
   
   // Checks if user entereddice to be rolled string
   // is a valid entry by returning a boolean
   public static boolean validRoll(String check) {
      if (check.length() != 5) {
         return false;
      }
      if (check.equals("nnnnn")) {
         return false;
      }
      
      for (int i = 0; i < check.length(); i++) {
         if (check.charAt(i) != 'n') {
            if (check.charAt(i) != 'y') {
               return false;     
            }
         }
      }
      return true;
   }
   // Asks which dice to reroll, sends string to the validRoll method
   // which rolls the dice specified if they contain y
   public static void reroll(int[] dice) {
      System.out.println("Indicate which dice to roll using y and n: ");
      String check = in.next();
      
      while(validRoll(check) != true) { 
         System.out.println("Indicate which dice to roll using y and n: ");
         check = in.next();
      }
      
      if (check.charAt(0) == 'y') {
         dice[0] = (int) (6 * Math.random() + 1);
      }
      if (check.charAt(1) == 'y') {
         dice[1] = (int) (6 * Math.random() + 1);
      }
      if (check.charAt(2) == 'y') {
         dice[2] = (int) (6 * Math.random() + 1);
      }
      if (check.charAt(3) == 'y') {
         dice[3] = (int) (6 * Math.random() + 1);
      }
      if (check.charAt(4) == 'y') {
         dice[4] = (int) (6 * Math.random() + 1);
      }
      sort(dice);
   }
   
   // Return 50 if all dice are the same, 
   // return 0 if not
   public static int yahtzee(int[] dice) {
      int count = 0;
      for (int i = 0; i < dice.length-1; i++) {
         if (dice[i] == dice[i+1]) {
            count++;
         }
      }
      if (count == 4) {
         return 50;
      }
      else {
         return 0;
      }
   }
   
   // Return sum of dice if 4 are alike, 0 otherwise
   public static int fourOfAKind(int[] dice) {
      int sum = 0;
      for (int i = 0; i < dice.length - 3; i++) {
         if (dice[i] == dice[i+1] && dice[i+1] == dice[i+2] && dice[i+2] == dice[i+3]) {
            for (int a = 0; i < dice.length; i++) {
               sum = sum + dice[i];
            }
            return sum;
         }
      }
      return 0;
   }
   
   // Return sum of dice if 3 are alike, 0 otherwise
   public static int threeOfAKind(int[] dice) {
      sort(dice);
      int count = 0;
      for (int i = 0; i < dice.length-2; i++) {
         if (dice[i] == dice[i+1] && dice[i+1] == dice[i+2]) {
            return chance(dice);
         }
      }
      return 0;   
   }
   
   // Checks for a sequence of 5
   public static int largeStraight(int[] dice) {
      sort(dice);
      int counter = 1; 
      if (dice[0] == 2 || dice[0] == 1) {
         for (int i = 0; i < dice.length -1; i++) {
            if (dice[i] == dice[i+1] - 1) {
               counter++;
            }
         }
      }
      if (counter == 5) {
         return 40;
      }
      else {
         return 0;
      }
   }
   
   // Checks for sequence of 4
   public static int smallStraight(int[] dice) {
      sort(dice);
      
      if (dice[0] + 1 == dice[1] && dice[1] + 1 == dice[2] && dice[2] + 1 == dice[3]) {
         return 30;
      }
      if (dice[1] + 1 == dice[2] && dice[2] + 1 == dice[3] && dice[3] + 1 == dice[4]) {
         return 30;
      }
      return 0;
   }
   
   // Check for 3 of a kind and 2 of a kind
   public static int fullHouse(int[] dice) {
      sort(dice);
      int counter = 0;
      if(dice[0] == dice[1] && dice[2] == dice[3] && dice[3] == dice[4]) {
         counter++;
      }
      if (dice[0] == dice[1] && dice[1] == dice[2] && dice[3] == dice[4]) {
         counter++;
      }
      if(counter >= 1){
         return 25;
      }
      else {
         return 0;
      }
   }
   
   // Total sum of dice with the input key
   public static int sum(int[] dice, int key) {
      int counter = 0;
      int total = 0;
      for (int i = 0; i < dice.length; i++) {
         if (dice[i] == key) {
            counter++;
         }
      }
      total = key * counter;
      return total;
   }
   
   // Sum of all dice
   public static int chance(int[] dice) {
      int sum = 0;
      for (int i = 0; i < dice.length; i++) {
         sum = sum + dice[i];
      }
      return sum;
   } 
   
   // Returns the possiblt scoring methods
   // depending on the roll
   public static void scoreChoices(int[] dice) {
      int yahtzee = yahtzee(dice);
      int fourOfAKind = fourOfAKind(dice);
      int threeOfAKind = threeOfAKind(dice);
      int largeStraight = largeStraight(dice);
      int smallStraight = smallStraight(dice);
      int fullHouse = fullHouse(dice);
      int chance = chance(dice);

      diceTotals(dice);
      if (threeOfAKind > 0) {
         System.out.println("3 of a kind: " +threeOfAKind);
      }
      if (fourOfAKind > 0) {
         System.out.println("4 of a kind: " +fourOfAKind);
      }
      if (largeStraight == 40) {
         System.out.println("large straight: 40");
      }
      if (smallStraight == 30) {
         System.out.println("small straight: 30");
      }
      if (fullHouse == 25) {
         System.out.println("full house: 25");
      }
      System.out.println("chance: " +chance);
      if (yahtzee == 50) {
         System.out.println("yahtzee: 50");
      }
   }
   
   // Counts how many of each number were rolled
   public static void diceTotals(int[] dice) {
      sort(dice);
      int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
      for (int i = 0; i < dice.length; i++) {
         if (dice[i] == 1)  ones++;
         if (dice[i] == 2) twos++;
         if (dice[i] == 3) threes++;
         if (dice[i] == 4) fours++;
         if (dice[i] == 5) fives++;
         if (dice[i] == 6) sixes++;
      }
      if (ones > 0) System.out.println("1 total: " +ones);
      if (twos > 0) System.out.println("2 total: " + 2*twos);
      if (threes > 0) System.out.println("3 total: " + 3*threes);
      if (fours > 0) System.out.println("4 total: " + 4*fours);
      if (fives > 0) System.out.println("5 total: " + 5*fives);
      if (sixes > 0) System.out.println("6 total: " + 6*sixes);
   }
   
   // Finds the max score of all scoring
   // possibilities
   public static int maxScore(int[] dice) {
      int largest = 0;
      int[] max = new int[7];
      max[0] = yahtzee(dice);
      max[1] = fourOfAKind(dice);
      max[2] = threeOfAKind(dice);
      max[3] = largeStraight(dice);
      max[4] = smallStraight(dice);
      max[5] = fullHouse(dice);
      max[6] = chance(dice);
      
      for (int i = 0; i < max.length; i++) {
         if (max[i] > largest) {
            largest = max[i];
         }
      }   
      return largest;
   }
}