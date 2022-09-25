package java9;

import java.util.Arrays;

public class ProcessApiDemo {

  public static void main(String[] args) {

    ProcessHandle.allProcesses().forEach((processHandle) -> {
      if (processHandle.info().command().isPresent()) {
        System.out.println();
        System.out.println("process id: " + processHandle.pid());
      }


      processHandle.info().command()
          .ifPresent(command -> System.out.println("process command: " + command));

      processHandle.info().arguments().ifPresent(
          arguments -> System.out.println("process arguments: " + Arrays.toString(arguments)));
    });

  }

}
