// Name: Benjamin Bowser
// Instructor: Norm Krumpe
// CSE 174, Section F
// Date: October 2nd, 2016
// Filename: program5.java
// Description: Prompts the user for a name
// telephone number, and address, then formats
// them into a nice output.


/*/    Test Cases for program5
 *     Name Tests: 
 *     BOWSER  ,   Benjamin leonard    >>>  Benjamin L. Bowser
 *     smiTH    ,   mAry        JEAN  >>>  Mary J. Smith 
 *     smith, mary jean  >>>  Mary J. Smith
 * 
 *     Telephone number Tests:
 *     6 1 4- 5 60  - 34  1 3  >>>  (614)560-3413
 *     61    4   - 56 0 - 3413 >>> (614)560-3413
 *     614 - 560 -3413  >>> (614)560-3413
 * 
 *     Address Tests:
 *     301 S. Campus Ave, Oxford, OH 45056  >>> 301 S. Campus Ave
                                                Oxford, OH 45056
 
 *     5262 Brown Road, Apt. 2131, Oxford, Ohio 45056 >>> 5262 Brown Road, Apt. 2131
                                                          Oxford, Ohio 45056
 * 
 *     123 Sesame Street, 3rd Floor, Left Hallway, Last Door on the Left, New York, New York 45056
                            >>>  123 Sesame Street, 3rd Floor, Left Hallway, Last Door on the Left
                                 New York, New York 45056
                                 
 /*/
import java.util.Scanner;

public class program5 {
   
   public static void main (String[] args) {
      
      Scanner keyboard = new Scanner(System.in);
      // Declare variables below
      String fullName, phoneNumber, address, firstName, firstMiddleName, lastName, middleName, firstLetterFirstName, restOfFirstName, middleInitial;
      String firstLetterLastName, restOfLastName, areaCode, firstThreePhone, lastFourPhone, stateZip, city;
      
      System.out.println("Name: ");
      fullName = keyboard.nextLine(); 
      fullName = fullName.replaceAll("\\s+"," "); // Remove extra spaces from name, allows compatibility with many spaces during input
      
      System.out.println("Phone: ");
      phoneNumber = keyboard.nextLine();
                                       // Prompting user for phone and address in this area
      System.out.println("Address: ");
      address = keyboard.nextLine();
      
      //Begin Name section
      // Int's declared as needed to avoid confusion with Strings
      int commaLocation = fullName.indexOf(",", 1); // Find the integer location of the first comma
      
      lastName = fullName.substring(0,commaLocation);  //Stores the last name by itself 
      
      int nameLength = fullName.length(); // Find length of fullName and send it to nameLength
      
      firstMiddleName = fullName.substring(commaLocation + 1, nameLength); // Added +1 to set the position to 1 past comma for formatting purposes
      int firstMiddleNameLength = firstMiddleName.length();
      
      int spaceLocationLastMiddle = firstMiddleName.indexOf(" ", 2) + 1;  // See previous note
      
      firstName = firstMiddleName.substring(1, spaceLocationLastMiddle);  // Pull out the first and middle name from string
      middleName = firstMiddleName.substring(spaceLocationLastMiddle,firstMiddleNameLength); 
      
      int firstNameLength = firstName.length(); // Stores the lengths of these strings as int's
      int lastNameLength = lastName.length(); 
      
      firstName = firstName.toLowerCase(); // Sets first name to lowercase
      middleName = middleName.toUpperCase(); // Sets middle name to uppercase, will only use 1st letter later
      lastName = lastName.toLowerCase(); // Sets last name to lowercase
      
      firstLetterFirstName = firstName.substring(0,1); // Stores the first letter of first name by itself
      firstLetterFirstName = firstLetterFirstName.toUpperCase(); // Sets the first letter to uppercase
      restOfFirstName = firstName.substring(1,firstNameLength); // Stores the remaining part of name by itself
      
      middleInitial = middleName.substring(0,1); // Stores the first letter of the middle name by itself, already uppercase
      
      firstLetterLastName = lastName.substring(0,1); // Stores the first letter of the last name
      firstLetterLastName = firstLetterLastName.toUpperCase(); // Sets the letter to uppercase
      restOfLastName = lastName.substring(1,lastNameLength); // Stores the remaining part of last name by itself
      
      // End of name section
      // Begin phone number area
      phoneNumber = phoneNumber.replaceAll("\\s+",""); // Remove spaces that may exist in the phone number
      
      areaCode = phoneNumber.substring(0,3); // Breaking down entire phone number
      firstThreePhone = phoneNumber.substring(4,7);
      lastFourPhone = phoneNumber.substring(8,12); // It would also be possible to just divide the area code
      
      // End of phone section
      // Begin address section
      
      stateZip = address.substring(address.lastIndexOf(',')); // Finds last comma in address, then stores rest as State and zip
      stateZip = stateZip.replace(',',' '); // Replaces comma before state with a space
      stateZip = stateZip.trim(); // Removes extra space before state and zip
      
      address = address.substring(0, address.lastIndexOf(',')); // Eliminates the state and zip code from address
      
      city = address.substring(address.lastIndexOf(',')); // Finds the city in the string at the end of address
      city = city.replace(',',' '); // Replaces comma before city with a space
      city = city.trim(); // Removes a space before city
      
      address = address.substring(0, address.lastIndexOf(',')); // Removes city from the main address string
      // End of address Section
      
      System.out.println("***** Results *****");
      System.out.println(firstLetterFirstName + restOfFirstName + middleInitial+". " + firstLetterLastName + restOfLastName);
      System.out.println("(" + areaCode + ")" +firstThreePhone + "-" + lastFourPhone); 
      System.out.println(address);
      System.out.println(city + ", " + stateZip);
      
   }
}