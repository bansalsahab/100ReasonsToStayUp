class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]  = new int [n][n];
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = n - 1;
        int val =1;
        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j]= val;
                val++;
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                matrix[i][endCol]= val;
                val++;
            }

            // bottom
            for (int j = endCol - 1; j >= startCol && startRow != endRow; j--) {
                matrix[endRow][j]= val;
                val++;
            }

            // left
            for (int i = endRow - 1; i > startRow && startCol != endCol; i--) {
                matrix[i][startCol]= val;
                val++;
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

        return matrix;
    }
}
