package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a list of fish sizes and their direction of swim in a tank, find out
 * which all fishes will not get eaten up once the fish fight is over
 * 
 * 1. A fish will get eaten up in the fight only if there is some bigger fish
 * swimming in the opposite direction of it.
 * 
 * Example - [1-> <-2 1-> 6-> <-7]
 * 
 * after 1-> get eaten by <-2 [<-2 1-> 6-> <-7]
 * 
 * after 6-> get eaten by <-7 [<-2 1-> <-7]
 * 
 * after 1-> get eaten by <-7 [<-2 <-7]
 * 
 * Now, no more fish will get eaten up [<-2 <-7]
 *
 */
public class FishFight {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int[] fishSizes = { 1, 2, 1, 6, 7 };

		/**
		 * -1 denotes that fish is swimming in left direction
		 * 
		 * 1 denotes that fish is swimming in right direction
		 */
		int[] swimDirection = { 1, -1, 1, 1, -1 };

		Object[] result = getRemainingFishesAfterFight(fishSizes, swimDirection);

		List<Integer> remainingFishes = (List<Integer>) result[0];
		List<Integer> remainingFishDirection = (List<Integer>) result[1];

		/**
		 * 
		 * print remaining fish sizes along with their direction
		 * 
		 */
		for (int i = 0; i < remainingFishes.size(); i++) {
			System.out.printf("fishSize: '%d' and swim direction: '%d' \n", remainingFishes.get(i),
					remainingFishDirection.get(i));
		}
	}

	/**
	 * return the sizes of all the fishes along with their direction of swim after
	 * the fish fight
	 * 
	 * @param fishSizes
	 * @param swimDirection
	 * @return
	 */
	public static Object[] getRemainingFishesAfterFight(int[] fishSizes, int[] swimDirection) {
		Object[] fightResult = new Object[2];

		List<Integer> remainingFishes = new ArrayList<Integer>();
		List<Integer> remainingFishDirection = new ArrayList<Integer>();

		fightResult[0] = remainingFishes;
		fightResult[1] = remainingFishDirection;

		for (int i = 0; i < fishSizes.length; i++) {

			boolean isEaten = false;
			if (swimDirection[i] == -1) {

				/**
				 * if fish is swimming in the left direction then check in the left of the fish
				 * for any bigger fish swimming in the right direction
				 * 
				 */
				int j = i - 1;
				while (j >= 0) {
					if (fishSizes[j] > fishSizes[i] && swimDirection[j] == 1) {
						isEaten = true;
						break;
					}
					j--;
				}
			} else {

				/**
				 * if fish is swimming in the right direction then check in the right of the
				 * fish for any bigger fish swimming in the left direction
				 * 
				 */
				int j = i + 1;
				while (j < fishSizes.length) {
					if (fishSizes[j] > fishSizes[i] && swimDirection[j] == -1) {
						isEaten = true;
						break;
					}
					j++;
				}
			}

			/**
			 * if fish will not get eaten up at the end of the fight then keep it in the
			 * result set
			 * 
			 */
			if (!isEaten) {
				remainingFishes.add(fishSizes[i]);
				remainingFishDirection.add(swimDirection[i]);
			}
		}
		return fightResult;
	}
}
