package jvm;

public class JVMClassDemo {

	public static void main(String[] args) {

		MyList<String> list = new MyList<String>("Gaurav K Yadav");
		System.out.println(list.getObject());

	}
}

class MyList<T> {

	private T object;

	MyList(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
