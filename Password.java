public class Password {
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public String calculateScore() {
        int length = value.length();
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        int score = (hasUpper ? 1 : 0) + (hasLower ? 1 : 0) + (hasDigit ? 1 : 0) + (hasSpecial ? 1 : 0) + (length >= 8 ? 1 : 0) + (length >= 16 ? 1 : 0);

        if (score >= 6) return "Very strong password";
        else if (score >= 4) return "Strong password";
        else if (score >= 2) return "Weak password";
        else return "Very weak password";
    }

    @Override
    public String toString() {
        return value;
    }
}
