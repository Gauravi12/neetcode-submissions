class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            Set<Character> set = new HashSet<>();
            Set<Character> set1 = new HashSet<>();
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] != '.'){
                   if(set.contains(board[i][j])) return false;
                   set.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                   if(set1.contains(board[j][i])) return false;
                   set1.add(board[j][i]);
                }
            }
        }
        
        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                Set<Character> boxSet = new HashSet();
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                        if(board[i][j] != '.'){
                            if(boxSet.contains(board[i][j])) return false;
                            boxSet.add(board[i][j]);
                        } 
                    }
                }
            }
        }
        return true;
    }
}
