class Twitter {

    HashMap<Integer, List<int[]>> post = new HashMap<>();
    HashMap<Integer, List<Integer>> follow = new HashMap<>();
    int time = 0;

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        post.putIfAbsent(userId , new ArrayList<>());
        post.get(userId).add(new int[]{tweetId,time});
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1] - a[1]
        );

        List<Integer> list = new ArrayList<>();

        if(post.containsKey(userId)){
            for(int i=0;i<post.get(userId).size();i++){
                pq.add(post.get(userId).get(i));
            }
        }

        if(follow.containsKey(userId)){
            for(int i = 0; i < follow.get(userId).size(); i++){
                int followeeId = follow.get(userId).get(i);
                if(post.containsKey(followeeId)){
                    for(int j = 0; j < post.get(followeeId).size(); j++){
                        pq.add(post.get(followeeId).get(j));
                    }
                }
            }
        }

        int size = Math.min(pq.size(), 10);

        for(int i=0;i<size;i++){
            list.add(pq.poll()[0]);
        }

        return list;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        follow.putIfAbsent(followerId, new ArrayList<>());
        if(!follow.get(followerId).contains(followeeId)){
            follow.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId)) {
            follow.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}