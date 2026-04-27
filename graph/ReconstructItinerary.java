// Reconstruct Itinerary

// You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

// All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

// Example 1:
// Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
// Output: ["JFK","MUC","LHR","SFO","SJC"]

// Example 2:
// Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
// Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;

class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        // Create a map to store the list of destinations for each departure airport
        Map<String, List<String>> graph = new HashMap<>();
        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        // Sort the destinations for each departure airport in lexical order
        for(List<String> destinations: graph.values()) {
            Collections.sort(destinations);
        }

        // Start the itinerary from "JFK"
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    private static void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinerary)  {

        List<String> destinations = graph.get(airport);
        while(destinations != null && !destinations.isEmpty()) {
            // Remove the next destination to avoid revisiting the same path
            String next = destinations.remove(0);
            dfs(next, graph, itinerary);
        }

        // Add the airport to the itinerary at the beginning to build the itinerary in reverse order
        itinerary.addFirst(airport);
    }

    public static void main(String[] args) {

        // Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        ReconstructItinerary obj = new ReconstructItinerary();
        List<String> result = obj.findItinerary(tickets);

        // Print output in array format
        System.out.println(result);
    }
}

