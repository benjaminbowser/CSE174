// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: October 30th, 2016
// Filename: Program8.java
// Description: Practice writing multiple
// methods that will be called.


// This program is not perfect, not all dates return properly for leap years
// especially days before leap day. But this will be a perfect example to talk
// about in a job interview when the question of "Name a time you tried your
// hardest and wasn't able to succeed" comes up.

import java.util.Scanner;

public class Program8 {
   
   public static int parseMonth(String date) {
      
      int monthLocation = date.indexOf("-", 1);
      String month = date.substring(0,monthLocation);
      return (int)(Double.parseDouble(month));
      // This method extracts the month from the user entered string
   }
   
   public static int parseDay(String date) {
      int monthLocation = date.indexOf("-", 1);
      int dateLocation = date.indexOf("-", 3);
      String day = date.substring(monthLocation+1,dateLocation);
      return (int)(Double.parseDouble(day));
      // This method extracts the date from the user entered string
   }
   
   public static int parseYear(String date) {
      
      int lengthOfString = date.length();
      int dateLocation = date.indexOf("-", 3);
      String year = date.substring(dateLocation+1, lengthOfString);
      return (int)(Double.parseDouble(year));
      // This method extracts the year from the user entered string
   }
   
   public static boolean isLeapYear(int year) {
      
      boolean leapYear = ((year % 4 == 0) && (year % 100 != 0)|| (year % 400 == 0));
      return leapYear;
      // This method determines if the user input year is a leap year or not
      
   }
   
   public static int daysInMonth(boolean leap, int month) {
      if (leap == false) {
         int daysInMonth;
         switch (month) {
            
            case 1:  daysInMonth = 31;
            break;
            case 2:  daysInMonth = 28;
            break;
            case 3:  daysInMonth = 31;
            break;
            case 4:  daysInMonth = 30;
            break;
            case 5:  daysInMonth = 31;
            break;
            case 6:  daysInMonth = 30;
            break;
            case 7: daysInMonth = 31;
            break;
            case 8: daysInMonth = 31;
            break;
            case 9: daysInMonth = 30;
            break;
            case 10: daysInMonth = 31;
            break;
            case 11: daysInMonth = 30;
            break;
            case 12: daysInMonth = 31;
            break;
            default: daysInMonth = -1;
            break;
         }
         return daysInMonth;
      }
      else {
         int daysInMonth;
         switch (month) {
            
            case 1:  daysInMonth = 31;
            break;
            case 2:  daysInMonth = 29;
            break;
            case 3:  daysInMonth = 31;
            break;
            case 4:  daysInMonth = 30;
            break;
            case 5:  daysInMonth = 31;
            break;
            case 6: daysInMonth = 30;
            break;
            case 7: daysInMonth = 31;
            break;
            case 8: daysInMonth = 31;
            break;
            case 9: daysInMonth = 30;
            break;
            case 10: daysInMonth = 31;
            break;
            case 11: daysInMonth = 30;
            break;
            case 12: daysInMonth = 31;
            break;
            default: daysInMonth = -1;
            break;
         }
         return daysInMonth;
      }
      // This method declares the number of days in a month depending on the
      // boolean result returned regarding a leap year
   }
   
   public static boolean isValid(int month, int day, int year) {
      
      if (month >= 13 || month < 1) { 
         return false; // returns false for impossible months
      }
      if (year < 0) {
         return false; // returns false for impossible years
      }
      if (day < 1) {
         return false; // returns false for impossible days
      }
      if (isLeapYear(year) == false) {
         if (month == 2) 
            if (day > 28) 
            return false;
      }
      if (isLeapYear(year) == true) {
         int monthDays = daysInMonth(true, month);
         if (monthDays < day) 
            return false;
      }
      if (isLeapYear(year) == false) {
         int monthDays = daysInMonth(false, month);
         if (monthDays < day)
            return false;
      }
      
      return true;
      // This method checks if the entered date is valid
   }
   
   
   public static int daysRemaining(int month, int day, int year) {
      int endOfYear = (365 * year) + (year/4) - (year/100) + (year/400) + 31 + (153 * 12 + 8) / 5;
      // Using an int works well because we always want to round down
      int currentDate = (365 * year) + (year/4) - (year/100) + (year/400) + day + (153 * month + 8) / 5;
      
      int daysLeft = endOfYear - currentDate;
      if (isLeapYear(year) == false && month <= 2 && day < 28) {
         daysLeft = daysLeft - 1;
      }
      
      return daysLeft;
      // This method checks the number of days remaining in a year
      // found here: http://mathforum.org/library/drmath/view/66857.html
   }
   
   public static int dayOfWeek(int month, int day, int year) {   
      
      int mathMonth = 0;
      
      if (month == 1 || month == 10) { // 0 
         mathMonth = 0;
      }
      
      if (month == 5) { // 1 
         mathMonth = 1;
      }
      
      if (month == 8) { // 2
         mathMonth = 2;
      }
      
      if (month == 2 || month == 3 || month == 11) { //3
         mathMonth = 3;
      }
      
      if (month == 6) { // 4
         mathMonth = 4;
      }
      
      if (month == 9 || month == 12) { // 5
         mathMonth = 5;
      }
      
      if (month == 4 || month == 7) {// 6
         mathMonth = 6;
      }
      
      if (month > 12 || month < 1) {
         return -1; // return -1 if invalid
      }
      
      int mathYear = 0;
      
      if (year >= 1600 && year < 1700) {
         mathYear = 0;
      }
      if (year >= 1700 && year < 1800) {
         mathYear = 5;
      }
      if (year >= 1800 && year < 1900) {
         mathYear = 3;
      }
      if (year >= 1900 && year < 2000) {
         mathYear = 1;
      }
      if (year >= 2000) {
         mathYear = 0;
      }
      
      
      int mathDayWeek = 0;
      int lastTwoYear = year % 100; // Cuts off the first 2 numbers in year
      
      mathDayWeek = ((day + mathMonth + lastTwoYear + (lastTwoYear/4) + mathYear) % 7)-1;
      // This subtracts the number 1 because the original mathmatical formula has
      // the value for each day as 1 more than the program instructions say.
      // mathMonth = # from a math table, lastTwoYear = last 2 numbers of year,
      // mathYear = # from a math table of years
      
      if (mathDayWeek == -1) {
       return mathDayWeek = 6; 
         // Because this math formula makes Saturday a -1, swapping it with a 6
         // will fix an issue with a valid date returning -1.
      }
      
      return mathDayWeek;
      
      // I found this mathmatical formula in multiple places: 
      // http://www.wikihow.com/Calculate-the-Day-of-the-Week
      // https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
      // I converted this mathmatical method to java entirely myself, using the number
      // tables that were found on both websites. It is not perfect for leap years.
      
      // This method determines the day of the week based on the
      // user entered date and the next date method.
      
   }
   
   
   public static String getDayName(int day) {  
      String dayName;
      switch (day) {
         case 0:  dayName = "Sunday";
         break;
         case 1:  dayName = "Monday";
         break;
         case 2:  dayName = "Tuesday";
         break;
         case 3:  dayName = "Wednesday";
         break;
         case 4:  dayName = "Thursday";
         break;
         case 5:  dayName = "Friday";
         break;
         case 6:  dayName = "Saturday";
         break;
         default: dayName = "ERROR";
         break;
      }
      return dayName;
      // This method assigns string names for integer values of days of the week
      // If the integer is not in range, "ERROR" is returned
      
   }
   public static String getMonthName(int month) {
      String monthName;
      switch (month) {
         case 1:  monthName = "January";
         break;
         case 2:  monthName = "February";
         break;
         case 3:  monthName = "March";
         break;
         case 4:  monthName = "April";
         break;
         case 5:  monthName = "May";
         break;
         case 6:  monthName = "June";
         break;
         case 7:  monthName = "July";
         break;
         case 8:  monthName = "August";
         break;
         case 9:  monthName = "September";
         break;
         case 10: monthName = "October";
         break;
         case 11: monthName = "November";
         break;
         case 12: monthName = "December";
         break;
         default: monthName = "ERROR";
         break;
      }
      return monthName;
      // This method is similar to the week method above, but instead
      // assigns string values for integers of months
      // If the integer is not in range, "ERROR" is returned
   } 
   
   public static String dateString(int month, int day, int year) {
      
      String nameMonth = getMonthName(month);
      int dayNumber = dayOfWeek(month, day, year);
      String nameDay = getDayName(dayNumber);
      String yearString = Integer.toString(year);
      if (isValid(month,day,year) == false) {
         return "ERROR";
      }
      
      return nameDay + ", " + nameMonth + " " + day + ", " + yearString;
      // This method pieces together parsed data into a string with the
      // name of the day, month, date, and year
   }
   
   public static String nextDateString(int month, int day, int year) {
   int newMonth = 0, newDay = 0, newYear = 0; // Initializes
   String monthName = getMonthName(month);
   int dayValue = dayOfWeek(month, day, year);
   dayValue = dayValue + 1; // This increases value of the day by 1

   boolean leap = isLeapYear(year); // Check for leap year
   int daysMonth = daysInMonth(leap, month); // Gets days in the given month
   newMonth = month;
   newDay = day + 1;
   newYear = year;
   
   if (isValid(month,day,year) == false) { // If the date is not valid at all, return error
      return "ERROR";
   }
  if (dayValue == 6) {
     dayValue = 0; // Resets a date that is out of range to Sunday
  }
   if (day == daysMonth) { // If specified date is final day of month
      newMonth = month + 1;
      newDay = 1;
   }
   if (day == 31 && month == 12) { // Accounts for final day of year
      newMonth = 1;
      newDay = 1; // January 1st
      newYear = year + 1;
     
   }
   if (day == 28 && month == 2) {
      if (leap == false) {
         newDay = 1;
         newMonth = 3;
      }
   }
   
   return dateString(newMonth, newDay, newYear);
   // This method determines the next date following the user entered date
   // If the value is not valid at all, it will return "ERROR"
   }

   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter a date:");
      String date = keyboard.nextLine();
      int month = parseMonth(date);
      int day = parseDay(date);
      int year = parseYear(date);
      boolean leap = isLeapYear(year);
      
      if (isValid(month,day,year) == false) {
         System.out.println("This is not a valid date.");
      }
      else {
      System.out.println(dateString(parseMonth(date),parseDay(date),parseYear(date)));
      System.out.println("Days in " + getMonthName(parseMonth(date)) + ", " + parseYear(date) + ": " + daysInMonth(leap, month));
      System.out.println("Days remaining in " + parseYear(date) + ": "+ daysRemaining(parseMonth(date),parseDay(date),parseYear(date)));
      boolean leapYearTruth = isLeapYear(parseYear(date));
      String leapYearString;
      if (leapYearTruth == true) {
         leapYearString = "yes";
      }
      else {
         leapYearString = "no";
      }
      System.out.println("Leap year: " + leapYearString);
      System.out.println("Next day: "+ nextDateString(parseMonth(date), parseDay(date), parseYear(date)));
     
      }                  
   }
   // This is the main method, which takes user input and gives output from methods
   // In the event that the date entered is not valid, "This is not a valid date" is 
   // all that will be displayed in the output window, for example 2-29-2015
   
}