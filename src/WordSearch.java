public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)){
                    if (dfsHelper(board, word, row, col)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfsHelper(char [][] board, String word, int row, int col){
        if (word.length() == 0){
            return true;
        }

        if (row < 0 || col < 0 || row ==board.length || col == board[0].length){
            return false;
        }

        if (board[row][col] != word.charAt(0)){
            return false;
        }

        board[row][col] = '*';

        boolean exist = dfsHelper(board, word.substring(1), row+1, col)
                || dfsHelper(board, word.substring(1), row-1, col)
                || dfsHelper(board, word.substring(1), row, col+1)
                || dfsHelper(board, word.substring(1), row, col-1);

        board[row][col] = word.charAt(0);
        return exist;
    }
}
