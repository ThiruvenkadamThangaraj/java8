public class sumofDigits {
    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Original number: " + number);
        System.out.println("Sum of digits: " + sumOfDigits(number));
    }
    private static int sumOfDigits(int number) {
        return String.valueOf(number)
                .chars()
                .map(c -> c - '0') // Convert char to int
                .sum();
    }
    
}