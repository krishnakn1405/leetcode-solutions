// Design Twitter

// Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

// Implement the Twitter class:
// Twitter() Initializes your twitter object.
// void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
// List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
// void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
// void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 
// Example 1:
// Input
// ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
// [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
// Output
// [null, null, [5], null, null, [6, 5], null, [5]]

// Explanation
// Twitter twitter = new Twitter();
// twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
// twitter.follow(1, 2);    // User 1 follows user 2.
// twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
// twitter.unfollow(1, 2);  // User 1 unfollows user 2.
// twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

class DesignTwitter {

    private static int timeStamp = 0;

    // User class to represent each user in Twitter
    private class User {

        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // User should follow themself
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            if(id != this.id) {
                followed.remove(id);
            }
        }

        public void post(int id) {
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    // Tweet class to represent each tweet
    private class Tweet {

        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    private Map<Integer, User> userMap;

    // Initialize your data structure here
    public DesignTwitter() {
        userMap = new HashMap<>();
    }
    
    // Compose a new tweet
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
            User newUser = new User(userId);
            userMap.put(userId, newUser);
        }
        userMap.get(userId).post(tweetId);
    }
    
    // Retrieve the 10 most recent tweet ids in the user's news feed
    // Each item in the news feed must be posted by users who the user followed or by the user themselves.
    // Tweets must be ordered from most recent to least recent.
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> newsFeed = new LinkedList<>();
        if(!userMap.containsKey(userId)) return newsFeed;

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(followedUsers.size(), (a,b) -> b.time - a.time);

        for(int user: followedUsers) {
            Tweet tweet = userMap.get(user).tweetHead;
            if(tweet != null) {
                tweetHeap.add(tweet);
            }
        }

        int count = 0;
        while(!tweetHeap.isEmpty() && count<10) {
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id);
            count++;
            if(tweet.next != null) {
                tweetHeap.add(tweet.next);
            }
        }

        return newsFeed;
    }
    
    // Follower follows a followee
    public void follow(int followerId, int followeeId) {
        
        if(!userMap.containsKey(followerId)) {
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }

        if(!userMap.containsKey(followeeId)) {
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    // Follower unfollows a followee
    public void unfollow(int followerId, int followeeId) {
        
        if(userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    public static void main(String[] args) {

        String[] operations = {
            "Twitter", "postTweet", "getNewsFeed", "follow",
            "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"
        };

        int[][] values = {
            {}, {1, 5}, {1}, {1, 2},
            {2, 6}, {1}, {1, 2}, {1}
        };

        DesignTwitter twitter = null;
        Object[] output = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Twitter":
                    twitter = new DesignTwitter();
                    output[i] = null;
                    break;

                case "postTweet":
                    twitter.postTweet(values[i][0], values[i][1]);
                    output[i] = null;
                    break;

                case "getNewsFeed":
                    output[i] = twitter.getNewsFeed(values[i][0]);
                    break;

                case "follow":
                    twitter.follow(values[i][0], values[i][1]);
                    output[i] = null;
                    break;

                case "unfollow":
                    twitter.unfollow(values[i][0], values[i][1]);
                    output[i] = null;
                    break;
            }
        }

        System.out.println(Arrays.toString(output));
    }

}

