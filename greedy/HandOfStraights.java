// Hand of Straights

// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

// Example 1:
// Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// Output: true
// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

// Example 2:
// Input: hand = [1,2,3,4,5], groupSize = 4
// Output: false
// Explanation: Alice's hand can not be rearranged into groups of 4.

import java.util.TreeMap;

class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0) return false; // Early exit if not divisible

        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        // Count each card
        for(int card: hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        // Attempt to form groups
        while(!cardCounts.isEmpty()) {
            int first = cardCounts.firstKey(); // Start with the smallest card
            for(int i=0; i<groupSize; i++) {
                int currentCard = first+i;
                if(!cardCounts.containsKey(currentCard)) {
                    return false; // Can't form a group
                }

                // Decrease count or remove card if count is 0
                int count = cardCounts.get(currentCard);
                if(count == 1) {
                    cardCounts.remove(currentCard);
                } else {
                    cardCounts.put(currentCard, count - 1);
                }
            }
        }

        return true;
    }


    // Main method
    public static void main(String[] args) {

        HandOfStraights obj = new HandOfStraights();

        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;

        boolean result = obj.isNStraightHand(hand, groupSize);

        System.out.println("Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3");
        System.out.println("Output: " + result);
    }

}
