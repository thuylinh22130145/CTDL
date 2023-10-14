package lab4;

public class Task_2 {
	// sort by descending order
	public static void mergeSort(int[] array) {

		mergeSortRecursive(array, 0, array.length - 1);
	}

	private static void mergeSortRecursive(int[] array, int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;
			mergeSortRecursive(array, first, middle);
			mergeSortRecursive(array, middle + 1, last);
			merge(array, first, middle, last);
		}
	}

	private static void merge(int[] array, int first, int middle, int last) {
		int[] temp = new int[last - first + 1];

		int i = first;
		int j = middle + 1;
		int k = 0;

		while (i <= middle && j <= last) {
			if (array[i] >= array[j]) {
				temp[k] = array[i];
				i++;
			} else {
				temp[k] = array[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			temp[k] = array[i];
			i++;
			k++;
		}

		while (j <= last) {
			temp[k] = array[j];
			j++;
			k++;
		}

		for (i = first, k = 0; i <= last; i++, k++) {
			array[i] = temp[k];
		}
	}

}
