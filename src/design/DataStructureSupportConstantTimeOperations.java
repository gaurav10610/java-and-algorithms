package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure which supports following operations with expected
 * time complexity
 * 
 * Assumption - there are no duplicates inserted in the data structure
 * 
 * 1. boolean insert(element) - O(1)
 * 
 * 2. boolean search(element) - O(1)
 * 
 * 3. element remove(element) - O(1)
 * 
 * 4. element getRandom() - O(1)
 *
 */
public class DataStructureSupportConstantTimeOperations {

	public static void main(String[] args) {

		CustomDataStructure<Integer> collection = new CustomDataStructure<Integer>();
		collection.insert(1);
		collection.insert(2);
		collection.insert(3);
		collection.remove(3);
		collection.insert(4);
		collection.insert(5);
		collection.remove(5);
		collection.remove(1);
	}
}

class CustomDataStructure<T> {

	private List<T> list;
	private int size;
	private Map<T, Integer> map;

	public CustomDataStructure() {
		list = new ArrayList<>();
		size = 0;
		map = new HashMap<>();
	}

	public int size() {
		return size;
	}

	public boolean insert(T element) {
		System.out.println("Inserted " + element);
		list.add(element);
		map.put(element, size);
		size++;
		System.out.println("After insertion current elements: " + this + " | size: " + this.size);
		System.out.println();
		return true;
	}

	public boolean search(T element) {
		return map.containsKey(element);
	}

	public boolean remove(T element) {
		boolean isElementExist = true;
		if (!map.containsKey(element)) {
			isElementExist = false;
		} else {

			int listIndex = map.get(element);

			/**
			 * 
			 * check if the element which is going to be deleted is stored at last position
			 * in list or somewhere in between
			 * 
			 * a. if element is not the last element in list then replace it with the
			 * element stored at last index in array and subsequently update the index of
			 * the last element in the map as well then remove the last element from list
			 * and decrease the size
			 * 
			 * b. if element is the last element in the list then just remove it from the
			 * list and decrease the size
			 * 
			 */
			if (listIndex != (size - 1)) {
				map.put(list.get(size - 1), listIndex);
				list.set(listIndex, list.get(size - 1));
				list.remove(size - 1);
			} else {
				list.remove(size - 1);
			}
			size--;
			map.remove(element);
			System.out.println("Removed " + element);
			System.out.println("After deletion current elements: " + this + " | size: " + this.size);
			System.out.println();
		}
		return isElementExist;
	}

	public T getRandom() {
		return list.get((int) Math.random() % size);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.list.toArray());
	}
}
