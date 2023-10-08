package lab_3.copy;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

// To find the index of the target in the array. If the target 
// is not found in the array, then the method returns -1.
// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
// Output: -1
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelper(target, 0);

	}

private int recursiveLinearSearchHelper(int target, int index) {
	{
		if (index >=array.length) {
			return -1;
		}
		if (array[index]== target) {
			return index;
		}
		return recursiveLinearSearchHelper(target, index + 1);
	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return -1;

	}
	public int recursiveBianrySearch(int target) {
		return recursiveBianrySearchHelper(target, 0 , array.length -1);
	
	}

	private int recursiveBianrySearchHelper(int target, int left, int right) {
		 if (left > right) {
	            return -1;
	        }

	        int mid = left + (right - left) / 2;

	        if (array[mid] == target) {
	            return mid;
	        } else if (array[mid] < target) {
	            return recursiveBianrySearchHelper(target, mid + 1, right);
	        } else {
	            return recursiveBianrySearchHelper(target, left, mid - 1);
	        }
	}
}

	    

	


