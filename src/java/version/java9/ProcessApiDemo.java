package java.version.java9;

import java.util.Arrays;

public class ProcessApiDemo {

	public static void main(String[] args) {

		ProcessHandle.allProcesses().filter(processHandle -> processHandle.info().command().isPresent())
				.forEach((processHandle) -> {

					System.out.println();
					System.out.println("process id: " + processHandle.pid());

					System.out.println("process command: " + processHandle.info().command().get());

					processHandle.info().arguments().ifPresent(
							arguments -> System.out.println("process arguments: " + Arrays.toString(arguments)));
				});

	}

}
