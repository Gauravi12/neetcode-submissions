class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] < target){
                start++;
            }else if(matrix[i][0] == target){
                return true;
            }
        }
        start = start - 1;
        if(start == -1) return false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[start][i] == target){
                return true;
            }
        }
        return false;
    }
}
