class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            HashMap<Character , Integer> map = new HashMap<>();
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] != '.'){
                    map.put(board[i][j] , map.getOrDefault(board[i][j],0) + 1);
                }
                if(map.containsValue(2)) return false;
            }
            HashMap<Character , Integer> map1 = new HashMap<>();
            for(int j=0;j<board[i].length;j++){
                if(board[j][i] != '.'){
                    map1.put(board[j][i] , map1.getOrDefault(board[j][i],0) + 1);
                }
                if(map1.containsValue(2)) return false;
            }
        }
        HashMap<Character , Integer> map = new HashMap<>();
        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();
        HashMap<Character , Integer> map3 = new HashMap<>();
        HashMap<Character , Integer> map4 = new HashMap<>();
        HashMap<Character , Integer> map5 = new HashMap<>();
        HashMap<Character , Integer> map6 = new HashMap<>();
        HashMap<Character , Integer> map7 = new HashMap<>();
        HashMap<Character , Integer> map8 = new HashMap<>();
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(board[i][j] != '.'){
                    map.put(board[i][j] , map.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map.containsValue(2)) return false;
            for(int j=3;j<=5;j++){
                if(board[i][j] != '.'){
                    map1.put(board[i][j] , map1.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map1.containsValue(2)) return false;
            for(int j=6;j<=8;j++){
                if(board[i][j] != '.'){
                    map2.put(board[i][j] , map2.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map2.containsValue(2)) return false;
        }
        for(int i=3;i<=5;i++){
           for(int j=0;j<=2;j++){
                if(board[i][j] != '.'){
                    map3.put(board[i][j] , map3.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map3.containsValue(2)) return false;
            for(int j=3;j<=5;j++){
                if(board[i][j] != '.'){
                    map4.put(board[i][j] , map4.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map4.containsValue(2)) return false;
            for(int j=6;j<=8;j++){
                if(board[i][j] != '.'){
                    map5.put(board[i][j] , map5.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map5.containsValue(2)) return false;
        }
        for(int i=6;i<=8;i++){
            for(int j=0;j<=2;j++){
                if(board[i][j] != '.'){
                    map6.put(board[i][j] , map6.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map6.containsValue(2)) return false;
            for(int j=3;j<=5;j++){
                if(board[i][j] != '.'){
                    map7.put(board[i][j] , map7.getOrDefault(board[i][j],0) + 1);
                }
            }
            if(map7.containsValue(2)) return false;
            for(int j=6;j<=8;j++){
                if(board[i][j] != '.'){
                    map8.put(board[i][j] , map8.getOrDefault(board[i][j],0) + 1);
                }
            if(map8.containsValue(2)) return false;
            }
        }
        return true;
    }
}
