package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Suppose there is a circle. There are n petrol pumps on that circle. You are
 * given two sets of data.
 * 
 * 1. The amount of petrol that every petrol pump has.
 * 
 * 2. Distance from that petrol pump to the next petrol pump.
 * 
 * Calculate the first point from where a truck will be able to complete the
 * circle (The truck will stop at each petrol pump and it has infinite
 * capacity).
 * 
 * Expected time complexity is O(n).
 * 
 * Assume for 1-litre petrol, the truck can go 1 unit of distance.
 * 
 * 
 * For example, let there be 4 petrol pumps with amount of petrol and distance
 * to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}.
 * 
 * The first point from where the truck can make a circular tour is 2nd petrol
 * pump. Output should be start = 1 (index of 2nd petrol pump).
 *
 */
public class CircularPetrolPumpVisit {

	public static void main(String[] args) {

		List<PetrolPump> list1 = new ArrayList<>();
		list1.add(new PetrolPump(0, 4, 6));
		list1.add(new PetrolPump(1, 6, 5));
		list1.add(new PetrolPump(2, 7, 3));
		list1.add(new PetrolPump(3, 4, 5));

		System.out.println("petrol pumps: " + Arrays.toString(list1.toArray()));
		System.out.println("start with petrol pump at index: " + findStartingPetrolPump(list1));
		System.out.println();

		List<PetrolPump> list2 = new ArrayList<>();
		list2.add(new PetrolPump(0, 6, 4));
		list2.add(new PetrolPump(1, 3, 6));
		list2.add(new PetrolPump(2, 7, 3));

		System.out.println("petrol pumps: " + Arrays.toString(list2.toArray()));
		System.out.println("start with petrol pump at index: " + findStartingPetrolPump(list2));
		System.out.println();
	}

	public static int findStartingPetrolPump(List<PetrolPump> list) {

		// this set is being kept to check what all pumps has been visited
		Set<Integer> set = new HashSet<>();

		int remainingPetrol = 0;
		int totalPetrolPumps = list.size();
		Queue<PetrolPump> queue = new LinkedList<>();

		int i = 0;
		while (i < Integer.MAX_VALUE) {

			// get the correct index in cyclic manner
			int j = i % totalPetrolPumps;
			PetrolPump pump = list.get(j);

			// covered all petrol pumps
			if (set.contains(pump.getIndex())) {
				return pump.getIndex();
			}

			// add the current petrol pump in the queue and update remaining petrol
			// accordingly
			queue.offer(pump);
			remainingPetrol = remainingPetrol + pump.getAmountOfPetrol();
			remainingPetrol = remainingPetrol - pump.getNextPetrolPumpDistance();

			// insert petrol pump's index in set to mark it visited
			set.add(pump.getIndex());

			// check if there is no sufficient petrol to go to next petrol pump
			if (remainingPetrol < 0) {

				/**
				 * start removing the visited petrol pumps from queue and set until we have
				 * sufficient petrol to visit next petrol pump from current position
				 * 
				 **/
				while (!queue.isEmpty() && remainingPetrol < 0) {

					// remove the visited petrol pump from the queue and update remaining petrol
					PetrolPump polledPump = queue.poll();
					remainingPetrol = remainingPetrol - polledPump.getAmountOfPetrol();
					remainingPetrol = remainingPetrol + polledPump.getNextPetrolPumpDistance();
					set.remove(polledPump.getIndex());
				}

				/**
				 * if queue is completely empty then start with the next petrol pump in the list
				 * and make remaining petrol as 0
				 * 
				 **/
				if (queue.isEmpty()) {
					remainingPetrol = 0;
				}
			}
			i++;
		}
		return -1;
	}

}

/**
 * 
 * class to represent petrol pump
 *
 */
class PetrolPump {

	private int index;
	private int amountOfPetrol;
	private int nextPetrolPumpDistance;

	public PetrolPump(int index, int amountOfPetrol, int nextPetrolPumpDistance) {
		this.index = index;
		this.amountOfPetrol = amountOfPetrol;
		this.nextPetrolPumpDistance = nextPetrolPumpDistance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getAmountOfPetrol() {
		return amountOfPetrol;
	}

	public void setAmountOfPetrol(int amountOfPetrol) {
		this.amountOfPetrol = amountOfPetrol;
	}

	public int getNextPetrolPumpDistance() {
		return nextPetrolPumpDistance;
	}

	public void setNextPetrolPumpDistance(int nextPetrolPumpDistance) {
		this.nextPetrolPumpDistance = nextPetrolPumpDistance;
	}

	@Override
	public String toString() {
		return "{" + amountOfPetrol + "," + nextPetrolPumpDistance + "} ";
	}
}
