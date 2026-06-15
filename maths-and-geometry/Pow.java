// Pow(x, n)

// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// Example 1:
// Input: x = 2.00000, n = 10
// Output: 1024.00000

// Example 2:
// Input: x = 2.10000, n = 3
// Output: 9.26100

// Example 3:
// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25

class Pow {
    public double myPow(double x, int n) {
        
        // Handle the base case where n is 0
        if(n==0) return 1;

        // Convert n to long to handle edge case when n == Integer.MIN_VALUE
        long N = n;

        // If n is negative, we need to handle reciprocal of x
        if(N < 0) {
            x=1/x;
            N = -N;
        }

        double result = 1;
        double currentProduct = x;

        // Exponentiation by squaring
        while(N > 0) {
            if(N%2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // Square the base
            N /= 2; // Divide the exponent by 2
        }

        return result;
    }

    public static void main(String[] args) {
        Pow obj = new Pow();

        double x = 2.00000;
        int n = 10;

        double result = obj.myPow(x, n);

        System.out.println("Input: x = " + x + ", n = " + n);
        System.out.println("Output: " + result);
    }
}


