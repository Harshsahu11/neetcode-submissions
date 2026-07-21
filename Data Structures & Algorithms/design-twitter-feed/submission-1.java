
class Twitter {
    // Global timestamp to strictly order tweets across all users
    private int timestamp = 0;
    private Map<Integer, User> userMap;

    // --- INNER CLASSES ---
    
    private class Tweet {
        int id;
        int time;
        Tweet next; // Forms a linked list of a user's tweets

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // Users intrinsically follow their own feed
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            // Cannot unfollow yourself
            if (id != this.id) {
                followed.remove(id);
            }
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            // Insert at the head so the list is intrinsically sorted newest to oldest
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    // --- TWITTER API METHODS ---

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        
        // Max-Heap: Order by timestamp descending (newest first)
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> (b.time - a.time));

        // Add the most recent tweet of every followed user to the heap
        for (int user : users) {
            Tweet t = userMap.get(user).tweetHead;
            if (t != null) {
                maxHeap.add(t);
            }
        }

        // Pull the top 10 most recent tweets
        int n = 0;
        while (!maxHeap.isEmpty() && n < 10) {
            Tweet t = maxHeap.poll();
            res.add(t.id);
            n++;
            
            // If the author has older tweets, queue up the next one
            if (t.next != null) {
                maxHeap.add(t.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}