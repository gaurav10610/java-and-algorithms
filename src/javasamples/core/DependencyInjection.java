package javasamples.core;

/**
 * Dependency Injection (DI):
 *
 * <p></p>
 *
 * Concept:
 * DI is a design pattern, a technique to implement DIP. It involves passing dependencies (objects that a class needs
 * to function) from outside the class rather than having the class create them internally.
 *
 * <p></p>
 *
 * Goal:
 * To achieve loose coupling between classes, making them easier to manage, test, and modify.
 *
 * <p></p>
 *
 * Implementation:
 * 	- Typically done through:
 * 		- Constructor Injection: Dependencies are passed as arguments to the class's constructor.
 * 		- Setter Injection: Dependencies are provided through setter methods.
 * 		- Interface Injection: Dependencies are provided through specialized interfaces.
 */
public class DependencyInjection {

	public static void main(String[] args) {
		BaseInterface obj1 = new Temp1();
		BaseInterface obj2 = new Temp2();
		MainClass test = new MainClass(obj1);

		test.getObj().doSomething();

		test = new MainClass(obj2);

		test.getObj().doSomething();
	}

}

class MainClass {

	BaseInterface obj;

	public MainClass(BaseInterface obj) {
		this.obj = obj;
	}

	public BaseInterface getObj() {
		return obj;
	}

	public void setObj(BaseInterface obj) {
		this.obj = obj;
	}
}

interface BaseInterface {
	public void doSomething();
}

class Temp1 implements BaseInterface {

	@Override
	public void doSomething() {
		System.out.println("This is class A");
	}

}

class Temp2 implements BaseInterface {

	@Override
	public void doSomething() {
		System.out.println("This is class B");
	}

}
