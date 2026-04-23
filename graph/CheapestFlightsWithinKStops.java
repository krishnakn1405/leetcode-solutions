// Cheapest Flights Within K Stops

// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

// Example 1:
// Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output: 700
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

// Example 2:
// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
// Output: 200
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

// Example 3:
// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
// Output: 500
// Explanation:
// The graph is shown above.
// The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

import java.util.Arrays;

class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] costs = new int[n];
        java.util.Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        for(int i=0; i<=k; i++) {
            int[] temp = costs.clone(); // Clone the costs array to use for this iteration
            for(int[] flight: flights) {
                int u = flight[0], v = flight[1], cost = flight[2];
                if(costs[u] == Integer.MAX_VALUE) continue; // If the source node u is not reachable
                if(temp[v] > costs[u] + cost) {
                    temp[v] = costs[u] + cost;
                }
            }
            costs = temp;
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int result = obj.findCheapestPrice(n, flights, src, dst, k);

        System.out.println("Cheapest price: " + result);
    }
}




