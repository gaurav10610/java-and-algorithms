package dsalgo.library;

/**
 * 
 * Two stack data structure uses one array to store contents of both the stacks
 *
 * @param <T>
 */
public class TwoStacks<T> {

	private Object[] array;

	private int top1;

	private int top2;

	private int initialArraySize;

	public TwoStacks(int initialArraySize) {
		this.initialArraySize = initialArraySize;
		this.array = new Object[initialArraySize];
		this.top1 = -1;
		this.top2 = initialArraySize;
	}

	@SuppressWarnings("unchecked")
	public T pop1() {
		T topElement = null;
		if (top1 != -1) {
			topElement = (T) array[top1];
			top1--;
		}
		return topElement;
	}

	@SuppressWarnings("unchecked")
	public T pop2() {
		T topElement = null;
		if (top2 != initialArraySize) {
			topElement = (T) array[top2];
			top2++;
		}
		return topElement;
	}

	public void push1(T value) throws RuntimeException {
		if ((top1 + 1) < top2) {
			top1++;
			array[top1] = value;
		} else {
			throw new RuntimeException("No space for new element in stack");
		}
	}

	public void push2(T value) throws RuntimeException {
		if ((top2 - 1) > top1) {
			top2--;
			array[top2] = value;
		} else {
			throw new RuntimeException("No space for new element in stack");
		}
	}
}
