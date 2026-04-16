// Course Schedule

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();

        for(int[] pre: prerequisites) {
            if(courseGraph.containsKey(pre[1])) {
                courseGraph.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(pre[0]);
                courseGraph.put(pre[1], nextCourses);
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        for(int currentCourse = 0; currentCourse<numCourses; currentCourse++) {
            if(courseSchedule(currentCourse, visited, courseGraph) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean courseSchedule(int course, HashSet<Integer> visited, HashMap<Integer, List<Integer>> courseGraph) {

        if(visited.contains(course)) {
            return false;
        }

        if(courseGraph.get(course) == null) {
            return true;
        }

        visited.add(course);
        for(int pre: courseGraph.get(course)) {
            if(courseSchedule(pre, visited, courseGraph) == false) {
                return false;
            }
        }
        visited.remove(course);
        courseGraph.put(course, null);
        return true;
    }

    public static void main(String[] args) {
        
        CourseSchedule obj = new CourseSchedule();

        int numCourses = 2;
        int[][] prerequisites = {
            {1, 0},
            {0, 1}
        };

        boolean result = obj.canFinish(numCourses, prerequisites);

        System.out.println("Output: " + result);
    }
}



