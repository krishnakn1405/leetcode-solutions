// Fizz Buzz

// Given an integer n, return a string array answer (1-indexed) where:

// answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
// answer[i] == "Fizz" if i is divisible by 3.
// answer[i] == "Buzz" if i is divisible by 5.
// answer[i] == i (as a string) if none of the above conditions are true.

// Example 1:
// Input: n = 3
// Output: ["1","2","Fizz"]

// Example 2:
// Input: n = 5
// Output: ["1","2","Fizz","4","Buzz"]

// Example 3:
// Input: n = 15
// Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 
import java.util.ArrayList;
import java.util.List;

class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        
        List<String> result = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(i%3 == 0 && i%5 == 0) {
                // Number is divisible by both 3 and 5
                result.add("FizzBuzz");
            } else if(i%3 == 0) {
                // Number is divisible by 3
                result.add("Fizz");
            } else if(i%5 == 0) {
                // Number is divisible by 5
                result.add("Buzz");
            } else {
                // Number is not divisible by 3 or 5
                result.add(Integer.toString(i));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int n = 15;

        FizzBuzz fb = new FizzBuzz();
        List<String> output = fb.fizzBuzz(n);

        System.out.println("Input: n = " + n);
        System.out.println("Output: " + output);
    }

}
