// Reverse Integer

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Example 1:
// Input: x = 123
// Output: 321

// Example 2:
// Input: x = -123
// Output: -321

// Example 3:
// Input: x = 120
// Output: 21

class ReverseInteger {
    public int reverse(int x) {
        
        int rev = 0;

        while(x != 0) {
            
            // Extract the last digit
            int pop = x % 10;
            x /= 10;

            // Check for overflow before actually updating the reversed number
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Overflow case
            }

            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Underflow case
            }

            // Update the reversed number
            rev = rev * 10 + pop;
        }

        return rev;
    }

    public static void main(String[] args) {

        int x = -123;

        ReverseInteger obj = new ReverseInteger();
        int result = obj.reverse(x);

        System.out.println("Input: x = " + x);
        System.out.println("Output: " + result);
    }
}


