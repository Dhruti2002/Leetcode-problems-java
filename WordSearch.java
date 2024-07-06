class Solution {
        public boolean search(int index, int i, int j, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*'; // Mark as visited

        boolean ans = search(index + 1, i + 1, j, board, word) ||
                      search(index + 1, i, j + 1, board, word) ||
                      search(index + 1, i - 1, j, board, word) ||
                      search(index + 1, i, j - 1, board, word);

        board[i][j] = temp; // Restore the character

        return ans;
    }

    public boolean exist(char[][] board, String word) {
        int m = board[0].length;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && search(0, i, j, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
