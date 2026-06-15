// Multiply Strings

// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Example 1:
// Input: num1 = "2", num2 = "3"
// Output: "6"

// Example 2:
// Input: num1 = "123", num2 = "456"
// Output: "56088"


class MultiplyStrings {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0")) return "0"; // If one of the numbers is 0, the result will be 0

        // Initialize an array to hold the result of the multiplication
        int[] result = new int[num1.length() + num2.length()];

        // Reverse both num1 and num2 for easier calculations (rightmost digits come first)
        for(int i=num1.length() - 1; i>=0; i--) {
            for(int j=num2.length() - 1; j>=0; j--) {
                // Multiply digits
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;

                // Find position in the result array where to add the product
                int posLow = i+j+1;
                int posHigh = i+j;

                // Add multiplication result to the current position and handle carry
                int sum = mul + result[posLow];

                result[posLow] = sum%10; // Set the current position to the remainder
                result[posHigh] += sum / 10; // Add the carry to the next higher position
            }
        }

        // Convert the result array into a string
        StringBuilder product = new StringBuilder();
        for(int num: result) {
            // Skip leading zeros
            if(!(product.length() == 0 && num == 0)) {
                product.append(num);
            }
        }

        // Return the product string
        return product.length() == 0 ? "0" : product.toString();
    }

    public static void main(String[] args) {

        MultiplyStrings obj = new MultiplyStrings();

        String num1 = "123";
        String num2 = "456";

        String result = obj.multiply(num1, num2);

        System.out.println("Input: num1 = \"" + num1 + "\", num2 = \"" + num2 + "\"");
        System.out.println("Output: \"" + result + "\"");
    }
}



