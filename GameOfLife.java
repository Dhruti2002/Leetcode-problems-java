class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Directions for the eight neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };
        
        // First pass: calculate the next state
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;
                
                for (int[] direction : directions) {
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && (board[r][c] == 1 || board[r][c] == 2)) {
                        liveNeighbors++;
                    }
                }
                
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2;  // Live cell dies
                } else if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 3;  // Dead cell becomes live
                }
            }
        }
        
        // Second pass: update the board to the final state
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 0;
                } else if (board[row][col] == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }
    
}
