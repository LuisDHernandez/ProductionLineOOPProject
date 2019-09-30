package sample;
// example class for in class notes

public class CellPhone implements Item {
  // abstract class from which you cannot create an object

  public void printItemInfo() {
    System.out.println("This is my cellphone!");
  }
}

// use interfaces when classes that will be implemented is not related to each other
// use abstracts when classes are somewhat related
