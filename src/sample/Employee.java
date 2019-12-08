package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Employee class is used to help create employee objects in program that will allow a backlog to be
 * traced back to certain users.
 *
 * @author Luis D. Hernandez 12/2/2019
 */
public class Employee {

  StringBuilder name;
  String username;
  String password;
  String email;
  String encode;

  /**
   * Constructor takes in name and password inputs to create the employee username, email, and set
   * the name and password.
   *
   * @param name - name provided by user to indicate themselves
   * @param password - character string to keep project integrity to user
   */

  public Employee(String name, String password) {
    this.name = new StringBuilder(name);
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }

    if (isValidPassword(password) == true) {
      this.password = password;
    } else {
      this.password = "pw";
    }
    encode = reverseString(password);
  }

  /**
   * Username is created by splitting the name inputted by user.
   *
   * @param name - uses name to setup a username for the project program
   */
  private void setUsername(String name) {

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find();
    String lastName = nameAfterSpaceMatch.group(1);

    String initials = name.substring(0, 1) + lastName;

    this.username = initials.toLowerCase();
  }

  /**
   * This method checks if the name has a space to be properly used in a String Builder.
   *
   * @param name the name provided by the user
   * @return a boolean variable that is true if username exists
   */
  private boolean checkName(String name) {
    Pattern pattern = Pattern.compile("\\s");
    Matcher matcher = pattern.matcher(name);
    boolean found = matcher.find();
    return found;
  }

  private void setEmail(String name) {

    Pattern nameBeforeSpace = Pattern.compile("(.*)\\s", Pattern.MULTILINE);
    Matcher nameBeforeSpaceMatch = nameBeforeSpace.matcher(name);
    nameBeforeSpaceMatch.find();
    String firstName = nameBeforeSpaceMatch.group(1);

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find();
    String lastName = nameAfterSpaceMatch.group(1);

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@oracleacademy.Test";
  }

  private boolean isValidPassword(String password) {

    String regex = "^(?=.[A-Z])+^(?!.[^!a-zA-Z0-9@#$^+=])";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    boolean found = matcher.find();
    return found;
  }

  /**
   * Method that overrides the toString method to allow a desired output.
   *
   * @return the string value of the employee details such as username and email
   */
  public String toString() {
    return "Employee Details\n"
        + "Name : "
        + name
        + "\n"
        + "Username : "
        + username
        + "\n"
        + "Email : "
        + email
        + "\n"
        + "Initial Password : "
        + password
        + "\n"
        + "Encoded Password :"
        + encode;
  }

  public String getName() {
    return name.toString();
  }

  /**
   * Encrypts the password of the employee.
   *
   * @param id string value given by emp
   * @return the value entered is reversed as to encrypt the password of the employee
   */
  public String reverseString(String id) {
    // reverse emp pw to make it more safe
    if (id.length() == 1) {
      return id;
    }
    return reverseString(id.substring(1)) + id.charAt(0);
  }
}
