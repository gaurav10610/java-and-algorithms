package greedy;

import java.util.HashMap;
import java.util.Map;

public class ActivitySelection {

	public static void main(String[] args) {
		int startTime[] = { 1, 3, 0, 5, 8, 5 };
		int finishTime[] = { 2, 4, 6, 7, 9, 9 };
		int totalActivities = startTime.length;

		Map<Integer, Integer> indices = getMaxActivityCount(startTime, finishTime, totalActivities);
		indices.forEach((key, value) -> {
			System.out.print("Start time: " + key.intValue() + " Finish time: " + value.intValue());
			System.out.println();
		});
	}

	public static Map<Integer, Integer> getMaxActivityCount(int[] startTime, int[] finishTime, int totalActivities) {
		Map<Integer, Integer> selectedActivities = new HashMap<Integer, Integer>();

		// Sort activities by finish time
		for (int i = 0; i < totalActivities - 1; i++) {
			for (int k = i + 1; k < totalActivities; k++) {

				if (finishTime[i] > finishTime[k]) {

					int temp1 = startTime[i];
					int temp2 = finishTime[i];
					startTime[i] = startTime[k];
					finishTime[i] = finishTime[k];
					startTime[k] = temp1;
					finishTime[k] = temp2;
				}
			}
		}

		int lastSelectedActivity = 0;
		selectedActivities.put(startTime[0], finishTime[0]);
		for (int p = 1; p < totalActivities; p++) {

			/**
			 * if the start time of current activity is greater than or equal to the last
			 * selected activity's finish time then select it else skip it
			 */
			if (startTime[p] >= finishTime[lastSelectedActivity]) {
				selectedActivities.put(startTime[p], finishTime[p]);
				lastSelectedActivity = p;
			}
		}

		return selectedActivities;
	}

}
