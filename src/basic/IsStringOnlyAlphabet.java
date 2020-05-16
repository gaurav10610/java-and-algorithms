package basic;

public class IsStringOnlyAlphabet {

  public static void main(String[] args) {
    String string1 = "Gaurav";
    String string2 = "Gaurav123Yadav";

    System.out.println(
        isOnlyAlphabet(string1) ? "String1 is only alphabets" : "String1 is not only alphabets");

    System.out.println(
        isOnlyAlphabet(string2) ? "String2 is only alphabets" : "String2 is not only alphabets");
  }

  public static boolean isOnlyAlphabet(String string) {
    return string != null && !string.equals("") && string.chars().allMatch(Character::isAlphabetic);
  }

}
