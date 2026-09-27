class Solution {
    public boolean bfs(String endWord,Queue<String> q,boolean[] visited,List<String> wordList){

        String remove = q.poll();

        if(remove.equals(endWord)) return true;

        for(int i=0;i<wordList.size();i++){

            if(visited[i]){
                continue;
            }

            int diff = 0;
            
            for(int j=0;j<wordList.get(i).length();j++){
                if(remove.charAt(j) != wordList.get(i).charAt(j)){
                    diff++;
                }
            }
            
            if(diff == 1){
                q.add(wordList.get(i));
                visited[i] = true;
            }
        }
        return false;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // if(!wordList.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        q.add(beginWord);
        int count = 1;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                if(bfs(endWord,q,visited,wordList)){
                    return count;
                }
            }
            count++;
        }
        return 0;
    }
}
