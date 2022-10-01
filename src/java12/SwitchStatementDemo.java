package java12;

public class SwitchStatementDemo {

  public static void main(String[] args) {

    String name = "Gaurav Kumar Yadav";

    Boolean isValidName = switch (name) {
      case "Gaurav Kumar Yadav" -> true;

      default -> false;
    };
    
    if(isValidName) {
      System.out.print(name + " is a valid name");
    }

  }

}
