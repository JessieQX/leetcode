public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //left to right
            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            //up to down
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][rowEnd]);
            }
            colEnd--;
            
            //right to left
            for (int i = colEnd; i >= colBegin; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            
            //down to up
            for (int i = rowEnd; i>= rowBegin; i--) {
                result.add(matrix[i][rowBegin]);
            }
            rowBegin++;
        }
        return result;
    }
    
}