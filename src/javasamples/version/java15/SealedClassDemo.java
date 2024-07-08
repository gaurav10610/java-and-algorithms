package javasamples.version.java15;

import dsalgo.library.ConsoleUtils;

public class SealedClassDemo {

	public static void main(String[] args) {

		SealedChildClass sealedClassInstance = new SealedChildClass();
		System.out.printf("sealed class meassage: %s", sealedClassInstance.getFullName());

		ConsoleUtils.addNewLine();

		SealedInterface sealedInterfaceInstance = new SealedInterfaceImpl();
		System.out.printf("sealed interface meassage: %s", sealedInterfaceInstance.getText());
	}
}

sealed class SealedClass permits SealedChildClass {
	protected String getName() {
		return "Gaurav Kumar Yadav";
	}
}

final class SealedChildClass extends SealedClass {
	public String getFullName() {
		return getName();
	}
}

sealed interface SealedInterface permits SealedInterfaceImpl {
	public String getText();
}

final class SealedInterfaceImpl implements SealedInterface {

	@Override
	public String getText() {
		return "Hey, I am the dark knight";
	}

}
