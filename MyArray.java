package lab_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class MyArray {
	
	private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    // Method to get the mirror image of the array
    public int[] mirror() {
        int[] mirrorArray = new int[array.length * 2];
        int index = 0;

        // Copy elements in original order
        for (int i = 0; i < array.length; i++) {
            mirrorArray[index] = array[i];
            index++;
        }

        // Copy elements in reverse order
        for (int i = array.length - 1; i >= 0; i--) {
            mirrorArray[index] = array[i];
            index++;
        }

        return mirrorArray;
    }

    // Method to remove duplicate elements from the array
    public int[] removeDuplicates() {
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int element : array) {
            uniqueElements.add(element);
        }

        int[] uniqueArray = new int[uniqueElements.size()];
        int index = 0;

        for (int element : uniqueElements) {
            uniqueArray[index] = element;
            index++;
        }

        return uniqueArray;
    }

    // Method to get missing values in a sequence
    public int[] getMissingValues() {
        Arrays.sort(array);
        ArrayList<Integer> missingValues = new ArrayList<>();

        for (int i = array[0]; i < array[array.length - 1]; i++) {
            if (Arrays.binarySearch(array, i) < 0) {
                missingValues.add(i);
            }
        }

        int[] missingArray = new int[missingValues.size()];
        for (int i = 0; i < missingValues.size(); i++) {
            missingArray[i] = missingValues.get(i);
        }

        return missingArray;
    }

    // Method to fill missing values in a sequence
    public int[] fillMissingValues(int k) {
        ArrayList<Integer> filledValues = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            filledValues.add(array[i]);

            if (i < array.length - 1) {
                int diff = array[i + 1] - array[i];
                if (diff > 1) {
                    for (int j = 1; j < Math.min(diff, k); j++) {
                        filledValues.add(array[i] + j);
                    }
                }
            }
        }

        int[] filledArray = new int[filledValues.size()];
        for (int i = 0; i < filledValues.size(); i++) {
            filledArray[i] = filledValues.get(i);
        }

        return filledArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 1, 3, 7, 9, 8};
        MyArray myArray = new MyArray(array);

        // Test mirror method
        int[] mirroredArray = myArray.mirror();
        System.out.println("Mirror array: " + Arrays.toString(mirroredArray));

        // Test removeDuplicates method
        int[] uniqueArray = myArray.removeDuplicates();
        System.out.println("Unique array: " + Arrays.toString(uniqueArray));

        // Test getMissingValues method
        int[] missingValues = myArray.getMissingValues();
        System.out.println("Missing values: " + Arrays.toString(missingValues));

        // Test fillMissingValues method
        int[] filledValues = myArray.fillMissingValues(3);
        System.out.println("Filled values: " + Arrays.toString(filledValues));
    }
	

}
