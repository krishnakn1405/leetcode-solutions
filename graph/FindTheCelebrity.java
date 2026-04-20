// Find the Celebrity

// Description
// At a party with people, a celebrity is defined as someone whom everyone knows, but who knows no one. Your goal is to identify this person (or confirm no such person exists) by using a provided bool knows(a, b) API to ask if person a knows person b. The task is to implement int findCelebrity(n) to find the celebrity, returning their label or -1 if none exists. While input is provided as a graph, you can only interact with it through the API. 

// Examples
// Input: graph = [[1,1,0],[0,1,0],[1,1,1]] -> Output: 1 (1 is known by 0 and 2, but knows no one)
// Input: graph = [[1,0,1],[1,1,0],[0,1,1]] -> Output: -1 (No celebrity)

// The knows API is defined in the parent class Relation. boolean knows(int a, int b);

class Relation {
    static int[][] graph;

    public boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }
}

public class FindTheCelebrity extends Relation {

	private int numOfPeople;

	public int findCelebrity(int n) {
		numOfPeople = n;
		int celebCandiate = 0;

		for(int i=0; i<n; i++) {
			if(knows(celebCandiate, i)) {
				celebCandiate = i; 
			}
		}

		if(isCelebrity(celebCandiate)) {
			return celebCandiate;
		}

		return -1;
	}

	public boolean isCelebrity(int i) {
		
		for(int j=0; j<numOfPeople; j++) {
			if(i==j) {
				continue;
			}
			if(knows(i,j) || !knows(j,i)) {
				return false;
			}
		}

		return true;
	}

    // 🔽 MAIN METHOD
    public static void main(String[] args) {

        // Input graph
        graph = new int[][] {
            {1, 1, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        FindTheCelebrity obj = new FindTheCelebrity();
        int result = obj.findCelebrity(graph.length);

        System.out.println("Celebrity index: " + result);
    }
}


