package lab_1;

public class MyCaesar {
	 public static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
	            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	    private int n; // shift steps (right shift)

	    public MyCaesar(int shiftSteps) {
	        this.n = shiftSteps;
	    }

	    // Encrypt a character according to the given shift steps.
	    // Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET array
	    public char encryptChar(char c) {
	        if (Character.isLetter(c)) {
	            int index = Character.toUpperCase(c) - 'A';
	            int shiftedIndex = (index + n) % ALPHABET.length;
	            return ALPHABET[shiftedIndex];
	        } else {
	            return c;
	        }
	    }

	    // Encrypt a text using the above function for encrypting a character.
	    public String encrypt(String input) {
	        StringBuilder encryptedText = new StringBuilder();
	        for (char c : input.toCharArray()) {
	            encryptedText.append(encryptChar(c));
	        }
	        return encryptedText.toString();
	    }

	    // Decrypt a character according to the given shift steps.
	    // Decrypt: Dn(x) = (x - n) mod 26. x represents the index of c in the ALPHABET array
	    public char decryptChar(char c) {
	        if (Character.isLetter(c)) {
	            int index = Character.toUpperCase(c) - 'A';
	            int shiftedIndex = (index - n + ALPHABET.length) % ALPHABET.length;
	            return ALPHABET[shiftedIndex];
	        } else {
	            return c;
	        }
	    }

	    // Decrypt an encrypted text using the above function for decrypting a character.
	    public String decrypt(String input) {
	        StringBuilder decryptedText = new StringBuilder();
	        for (char c : input.toCharArray()) {
	            decryptedText.append(decryptChar(c));
	        }
	        return decryptedText.toString();
	    }

	    public static void main(String[] args) {
	        MyCaesar caesar = new MyCaesar(3);
	        
	        // Test encryption
	        String plainText = "HELLO";
	        String encryptedText = caesar.encrypt(plainText);
	        System.out.println("Encrypted text: " + encryptedText);
	        
	        // Test decryption
	        String decryptedText = caesar.decrypt(encryptedText);
	        System.out.println("Decrypted text: " + decryptedText);
	    }

}
