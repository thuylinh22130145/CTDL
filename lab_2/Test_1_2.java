package lab_2;

public class Test_1_2 {
	public class Fibonacci {
		// get the nth value of the Fibonacci series
		public static int getFibonacci(int n) {
			// TODO
			if (n <= 0)
				return 1;
			else 

			return getFibonacci(n - 1) + getFibonacci(n - 2);

		}
		

	}
	public static void main(String[] args) {
		int n = 10;
		int fibonacciValue = getFibonacci(n);
        System.out.println("Fibonacci value at index " + n + ": " + fibonacciValue);
		
	}

	

}
