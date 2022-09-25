package java9;

public class InterfacePrivateMethodDemo {
  
  public static void main(String[] args) {
    
    UsernameService usernameService = new UsernameServiceImpl();
    System.out.println(usernameService.getServiceName());
  }
}


@FunctionalInterface
interface UsernameService {
  public String getServiceName();

  default String getFirstName() {
    return getName("Gaurvav ");
  }

  default String getLastName() {
    return getName("Kumar Yadav");
  }

  private String getName(String name) {
    return name;
  }
}


class UsernameServiceImpl implements UsernameService {

  @Override
  public String getServiceName() {
    return getFirstName() + getLastName();
  }

}
