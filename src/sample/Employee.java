package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Luis D. Hernandez 12/2/2019 */
public class Employee {

  StringBuilder name;
  String username;
  String password;
  String email;

  /**
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
  }

  /** @param name - uses name to setup a username for the project program */
  private void setUsername(String name) {

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find();
    String lastName = nameAfterSpaceMatch.group(1);

    String initials = name.substring(0, 1) + lastName;

    this.username = initials.toLowerCase();
  }

  /**
   * @param name
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
        + password;
  }

  public String getName() {
    return name.toString();
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public String reverseString(String id) {
    //reverse db pw to make it more safe
    if (id.length() == 1){
      return id;
    }
    return reverseString(id.substring(1)) + id.charAt(0);
  }
}

