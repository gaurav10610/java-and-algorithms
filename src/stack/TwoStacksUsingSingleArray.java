package stack;

import library.TwoStacks;

/**
 * 
 * Implement two stack using single array in a space efficiant way
 * 
 *
 */
public class TwoStacksUsingSingleArray {

	public static void main(String[] args) {
		TwoStacks<Integer> twoStacks = new TwoStacks<Integer>(5);

		twoStacks.push1(5);
		twoStacks.push2(10);
		twoStacks.push2(15);
		twoStacks.push1(11);
		twoStacks.push2(7);

		System.out.println("Popped element from" + " stack1 is " + twoStacks.pop1());
		twoStacks.push2(40);
		System.out.println("Popped element from" + " stack2 is " + twoStacks.pop2());
	}

}
