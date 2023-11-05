package library;

public class HeapUtils {

	/**
	 * make min heap out of array
	 * 
	 * @param heap      array to make heap
	 * @param size      heap size
	 * @param rootIndex index of heap's element
	 * 
	 */
	public static void minHeapify(int[] heap, int size, int rootIndex) {
		int smallest = rootIndex;
		int leftChild = 2 * rootIndex + 1;
		int rightChild = 2 * rootIndex + 2;

		if (leftChild < size && heap[leftChild] < heap[smallest]) {
			smallest = leftChild;
		}

		if (rightChild < size && heap[rightChild] < heap[smallest]) {
			smallest = rightChild;
		}

		if (smallest != rootIndex) {
			int temp = heap[rootIndex];
			heap[rootIndex] = heap[smallest];
			heap[smallest] = temp;
			minHeapify(heap, size, smallest);
		}
	}

	/**
	 * make max heap out of array
	 * 
	 * @param heap      array to make heap
	 * @param size      heap size
	 * @param rootIndex index of heap's element
	 * 
	 */
	public static void maxHeapify(int[] heap, int size, int rootIndex) {
		int largest = rootIndex;
		int leftChild = 2 * rootIndex + 1;
		int rightChild = 2 * rootIndex + 2;

		if (leftChild < size && heap[leftChild] > heap[largest]) {
			largest = leftChild;
		}

		if (rightChild < size && heap[rightChild] > heap[largest]) {
			largest = rightChild;
		}

		if (largest != rootIndex) {
			int temp = heap[rootIndex];
			heap[rootIndex] = heap[largest];
			heap[largest] = temp;
			maxHeapify(heap, size, largest);
		}
	}

}
