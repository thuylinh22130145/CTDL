package lab_2;

public class Test_1_1 {
	// S(n) = 1 - 2 + 3 - 4 + ... + ((-1)^(n+1)).n , n > 0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		} else {
			int sum = ((int) Math.pow(-1, n + 1)) * n;
			return sum + getSn1(n - 1);

		}
	}

	// S(n) = 1 + 1.2 + 1.2.3 + ... + 1.2.3...n, n > 0
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		} else {
			return getProduct(n) + getSn2(n - 1);
		}
	}

	private static int getProduct(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * getProduct(n - 1);
		}
	}

	// S(n) = 1^2 + 2^2 + 3^2 + .... + n^2 , n > 0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		} else {
			int term = n * n;
			return term + getSn3(n - 1);
		}
	}

	// S(n) = 1 + 1/2 + 1/(2.4) + 1/(2.4.6) + ... + 1/(2.4.6.2n), n >= 0
	public static double getSn4(int n) {
		if (n == 0) {
			return 1.0;
		} else {
			return 1.0 / getProduct(n) + getSn4(n - 1);
		}
	}

	private static double getProductt(int n) {
		if (n == 0) {
			return 1.0;
		} else {
			return (2 * n) * getProductt(n - 1);
		}
	}

	public static void main(String[] args) {
		int n = 4;

		// Calculate and print S(n) for each series
		System.out.println("S1(" + n + "): " + getSn1(n));
		System.out.println("S2(" + n + "): " + getSn2(n));
		System.out.println("S3(" + n + "): " + getSn3(n));
		System.out.println("S4(" + n + "): " + getSn4(n));

	}

}
