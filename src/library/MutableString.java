package library;

public class MutableString {

	char[] array;
	int capacity;
	int length;

	public MutableString(int capacity) {
		array = new char[capacity];
		this.capacity = capacity;
		this.length = 0;
	}

	public String toString() {
		return new String(array);
	}
}
