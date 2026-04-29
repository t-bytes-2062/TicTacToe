public class DrawChecker {

    // UC10: Check if game is draw
    public static boolean isDraw(char[][] board) {

        // Traverse entire board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If any cell is empty → not a draw
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        // No empty cells → draw
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };

        if (isDraw(board)) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Game still in progress.");
        }
    }
}
