package corejava;

public enum FamilyEnum {

  FATHER("Ravinder Singh Yadav"), MOTHER("Nirmala Devi Yadav"), BROTHER("Paras Yadav"), SISTER(
      "Suman Yadav");

  String value;

  FamilyEnum(String value) {
    this.value = value;
  }
}
