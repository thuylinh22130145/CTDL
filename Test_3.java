package lab_1;

public class Test_3 {

	private static final int ALPHABET_SIZE = 26;
	    private static final int DEFAULT_SHIFT = 3;
	
	    public static void main(String[] args) {
	        String plainText = "Hello, World!";
	        int shift = 5;
	
	        String encryptedText = encrypt(plainText, shift);
	        System.out.println("Encrypted text: " + encryptedText);
	
	        String decryptedText = decrypt(encryptedText, shift);
	        System.out.println("Decrypted text: " + decryptedText);
	    }
	
	    public static String encrypt(String plainText, int shift) {
	        StringBuilder encryptedText = new StringBuilder();
	
	        for (char c : plainText.toCharArray()) {
	            if (Character.isLetter(c)) {
	                char shiftedChar = (char) ((c - ' ' + shift) % ALPHABET_SIZE + ' ');
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
	                char shiftedChar = (char) ((c - ' ' - shift + ALPHABET_SIZE) % ALPHABET_SIZE + ' ');
	                decryptedText.append(shiftedChar);
	            } else {
	                decryptedText.append(c);
	            }
	        }
	
	        return decryptedText.toString();
	    }
	

}
