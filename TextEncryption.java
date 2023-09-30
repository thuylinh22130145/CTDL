package lab_1;

import java.util.Scanner;

public class TextEncryption {
	private static final int ALPHABET_SIZE = 26;
	private static final int DEFAULT_SHIFT = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		

		System.out.println("Enter the text to encrypt:");
		String plainText = scanner.nextLine();

		System.out.println("Enter the encryption shift (default is 3):");
		int shift = scanner.nextInt();

		String encryptedText = encrypt(plainText, shift);
		System.out.println("Encrypted text: " + encryptedText);

		String decryptedText = decrypt(encryptedText, shift);
		System.out.println("Decrypted text: " + decryptedText);

		scanner.close();
	}

	public static String encrypt(String plainText, int shift) {
		StringBuilder encryptedText = new StringBuilder();

		for (char c : plainText.toCharArray()) {
			if (Character.isLetter(c)) {
				char shiftedChar = (char) (((c - 'A' + shift) % ALPHABET_SIZE) + 'A');
				encryptedText.append(shiftedChar);
			} else {
				encryptedText.append(c);
			}
		}

		return encryptedText.toString();
	}

	public static String decrypt(String encryptedText, int shift) {
		StringBuilder decryptedText = new StringBuilder();

		for (char c : encryptedText.toCharArray()) {
			if (Character.isLetter(c)) {
				char shiftedChar = (char) (((c - 'A' - shift + ALPHABET_SIZE) % ALPHABET_SIZE) + 'A');
				decryptedText.append(shiftedChar);
			} else {
				decryptedText.append(c);
			}
		}

		return decryptedText.toString();
	}

}
