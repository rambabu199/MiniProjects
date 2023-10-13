/*
4. Data validator: Create a menu based application that can display list of options:
--> Email Verifier: Create a method that takes an email address as input and verifies if it is in the correct format using regular expressions.
--> Username and password Verifier: Create a method that takes an username and password as input and verifies these are following basic rules(having 1 uppercase, lowercase, 1 digit, 1 special character etc....)
--> Mobile number Verifier: Create a method that  takes a mobile number as input and verifies it contains only digits or not, length should be 10 digits, starts with 6 or 7 or 8 or 9.
  */

import java.util.*;

class DataValidator {
  public static void main(String ar[]) {
    Scanner sc = new Scanner(System.in);
    DataValidator sp = new DataValidator();
    System.out.println("Enter the credentials");
    sp.Emailenter();
    sp.Userpassword();
    sp.Mobilenumber();
  }

  void Emailenter() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Email - ");
    String email = sc.nextLine();
    if (email.contains("@gmail.com") || email.contains("@yahoo.com")) {
      System.out.println("The email entered is valid");
      System.out.println(email);
    } else {
      System.out.println("Invalid email address");
    }
  }

  void Userpassword() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the username" + '\n' + "Username must have minimum 3 characters");
    String username = sc.nextLine();
    if ((username.length() >= 3) && (!username.isWhitespace())) {
      System.out.println("Valid username");
    } else {
      System.out.println("Username not valid" + '\n' + "Please create a username with minimum 3 characters");
    }
    System.out.println("Create a password" + '\n'
        + "NOTE :- The password must consist of atleast a Lowercase character, Uppercase character, a digit and a special Symbol"
        + '\n' + "Password must have minimum 8 Characters");
    String password = sc.nextLine();
    char pd[] = password.toCharArray();
    boolean valid = false;
    if (pd.length < 8) {
      System.out.println("Password must have minimum 8 Characters. Please try again");
    } else {
      for (int i = 0; i < pd.length; i++) {
        char c = pd[i];
        if (Character.isUpperCase(c)) {
          valid = true;
          break;
        }
        if (Character.isLowerCase(c)) {
          valid = true;
          break;
        }
        if (Character.isDigit(c)) {
          valid = true;
          break;
        }
        if (!Character.isUpperCase(c) && !Character.isLowerCase(c) && !Character.isDigit(c)
            && !Character.isWhitespace(c)) {
          valid = true;
          break;
        }
      }
      if (valid) {
        System.out.println("The password entered is valid");
      } else {
        System.out.println("Password is weak");
      }
    }
  }

  void Mobilenumber() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the mobile number");
    long number = sc.nextLong();
    String num = String.valueOf(number);
    if (num.length() == 10) {
      if ((num.charAt(0) == '6') || (num.charAt(0) == '7') || (num.charAt(0) == '8') || (num.charAt(0) == '9')) {
        System.out.println("Entered mobile number is valid");
      } else {
        System.out.println("Invalid number! Please reverify and enter your number");
      }
    } else {
      System.out.println("Invalid mobile number! Please reverify and enter your number ");
    }
  }
}