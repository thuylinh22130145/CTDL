package lab4;

public class Task_1 {
	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[i] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;

		}
	}

	// sort by descending order
	public static void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0;j< n -i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

				}
			}

		}
	}

	// sort by descending order
	public static void insertionSort(int[] array) {

		int n = array.length;
		for (int i = 1; i < n; i++) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] < key) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = key;
		}

	}

}
