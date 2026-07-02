// Sum of Two Integers

// Given two integers a and b, return the sum of the two integers without using the operators + and -.

// Example 1:
// Input: a = 1, b = 2
// Output: 3

// Example 2:
// Input: a = 2, b = 3
// Output: 5


class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        
        while(b != 0) {
            int temp = a^b;
            int carry = (a & b) << 1;
            a = temp;
            b = carry;
        }

        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();

        int a = 1;
        int b = 2;

        System.out.println("Input: a = " + a + ", b = " + b);
        System.out.println("Output: " + solution.getSum(a, b));
    }
}
