// Pascal's Triangle

// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Example 2:
// Input: numRows = 1
// Output: [[1]]

import java.util.List;
import java.util.ArrayList;

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for(int row=1; row<numRows; row++) {

            List<Integer> r = new ArrayList<>();
            List<Integer> prevList = ans.get(row-1);

            r.add(1);
            for(int j=1;j<row;j++) {
                r.add(prevList.get(j-1)+prevList.get(j));
            }
            r.add(1);
            ans.add(r);
        }

        return ans;

    }

    public static void main(String[] args) {

        PascalsTriangle obj = new PascalsTriangle();
        int numRows = 5;

        List<List<Integer>> result = obj.generate(numRows);

        // Print output
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}


