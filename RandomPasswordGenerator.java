import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the desired password length
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        
        // Ask the user what types of characters they want in the password
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        // Generate the password
        String password = generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);

        // Display the generated password
        System.out.println("Your generated password is: " + password);

        // Close the scanner
        scanner.close();
    }

    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, 
                                           boolean includeUppercase, boolean includeSpecialChars) {
        // Define possible character sets
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        // Build the character pool based on user's choices
        StringBuilder charPool = new StringBuilder();

        if (includeNumbers) {
            charPool.append(numbers);
        }
        if (includeLowercase) {
            charPool.append(lowercase);
        }
        if (includeUppercase) {
            charPool.append(uppercase);
        }
        if (includeSpecialChars) {
            charPool.append(specialChars);
        }

        // Check if at least one character type was selected
        if (charPool.length() == 0) {
            return "Error: You must select at least one character type!";
        }

        // Initialize the random number generator
        Random random = new Random();

        // StringBuilder to hold the generated password
        StringBuilder password = new StringBuilder();

        // Generate the password
        for (int i = 0; i < length; i++) {
            // Randomly select a character from the character pool
            int randomIndex = random.nextInt(charPool.length());
            password.append(charPool.charAt(randomIndex));
        }

        return password.toString();
    }
}
