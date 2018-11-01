// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: December 9th, 2016
// Filename: Program13.java
// Description: Open and close
// lockers depending on which
// student controls it.

import java.util.Scanner;
import java.util.Arrays;

public class Program13 {
   public static Scanner in = new Scanner(System.in);
   
   public static void main(String[] args) {
      System.out.print("How many lockers?");
      int totalLocker = in.nextInt();
      boolean[] lockers = new boolean[totalLocker+1];
      Arrays.fill(lockers, true);
      stagePlayer(lockers, totalLocker);   
   }
   
   public static void stagePlayer(boolean[] lockers, int totalLocker) {
      System.out.print("Show stages? (y/n)");
      String stageCheck = in.next();
      if (showStages(stageCheck) == true) {
         lockerPlay(totalLocker, lockers);
         openLocker(totalLocker);
      }
      if (showStages(stageCheck) == false) {
         openLocker(totalLocker);
      }
   }
   
   public static boolean showStages(String stageCheck) {
      if (stageCheck.equals("y")) {
         return true;
      }
      if (stageCheck.equals("n")) {
         return false;
      }
      return false;
   }
   
   public static void lockerPlay(int totalLocker, boolean[] lockers) {
      for(int i = 1; i <= totalLocker; i++) {
         for(int a = i; a <= totalLocker; a = a + i) {
            lockers[a] = !lockers[a];
         }
        System.out.println(lockerResolver(lockers));
      }
   }

   public static String lockerResolver(boolean[] lockers) {
      String reply = "";
      for (int i = 1; i < lockers.length; i++) {
         if (lockers[i] == false) {
            reply = reply + "O";
         }
         if (lockers[i] == true) {
            reply = reply + "-";
         }
      }
      return reply;
   }
   
   public static void openLocker(int totalLocker) {
      String open = ""; 
      for (int i = 1; i <= totalLocker; i++) {
         int square = (int)(Math.sqrt(i));
         if (square * square == i) {
            open = open + ", " + i;
         } 
      }
      System.out.print("Open:");
      System.out.println(open.substring(1,open.length()));
   }
}