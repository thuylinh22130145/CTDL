package thuylinh_22130145;


	public class PascalTriangle {
	    // This method is used to display a Pascal triangle based on the parameter n.
	    // Where n represents the number of rows
	    public static void printPascalTriangle(int row) {
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j <= i; j++) {
	                System.out.print(getPascalTriangle(i) + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Get the nth row of Pascal's Triangle
	    // For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	    public static int[] getPascalTriangle(int n) {
	        if (n == 0) {
	            return new int[]{1};
	        } else {
	            int[] prevRow = getPascalTriangle(n - 1);
	            return generateNextRow(prevRow);
	        }
	    }

	    // Generate the next row based on the previous row
	    // Ex. prevRow = {1} ==> nextRow = {1, 1}
	    // Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	    public static int[] generateNextRow(int[] prevRow) {
	        int[] nextRow = new int[prevRow.length + 1];
	        nextRow[0] = 1;
	        nextRow[nextRow.length - 1] = 1;
	        for (int i = 1; i < nextRow.length - 1; i++) {
	            nextRow[i] = prevRow[i - 1] + prevRow[i];
	        }
	        return nextRow;
	    }

	    public static void main(String[] args) {
	        int rows = 5;

	        // Print Pascal's Triangle
	        System.out.println("Pascal's Triangle:");
	        printPascalTriangle(rows);
	    }
	}