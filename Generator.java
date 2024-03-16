import java.util.Scanner;

public class Generator {
    private String characterPool = "";
    private static final Scanner scanner = new Scanner(System.in);

    public Generator() {
        buildCharacterPool();
    }

    private void buildCharacterPool() {
        System.out.println("Include uppercase letters (A-Z)? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) characterPool += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println("Include lowercase letters (a-z)? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) characterPool += "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Include numbers (0-9)? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) characterPool += "0123456789";

        System.out.println("Include symbols (!@#$...)? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) characterPool += "!@#$%^&*()-_=+\\/~?";

        if (characterPool.isEmpty()) {
            System.out.println("No character types selected, using default alphanumeric characters.");
            characterPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        }
    }

    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characterPool.length());
            password.append(characterPool.charAt(index));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Password Generator and Strength Checker");
        Generator generator = new Generator();

        System.out.println("Enter desired password length: ");
        int length = scanner.nextInt();
        String password = generator.generatePassword(length);
        System.out.println("Generated Password: " + password);

        Password passObj = new Password(password);
        System.out.println(passObj.calculateScore());
    }
}
