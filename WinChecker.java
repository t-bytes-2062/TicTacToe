public class WinChecker {

    // UC9: Check if a player has won
    public static boolean checkWin(char[][] board, char symbol) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            // Row check
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }

            // Column check
            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol) {
                return true;
            }
        }

        // Diagonal checks
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    // Test
    public static void main(String[] args) {

        char[][] board = {
            {'X', 'X', 'X'},
            {'-', 'O', '-'},
            {'O', '-', '-'}
        };

        if (checkWin(board, 'X')) {
            System.out.println("Player X wins!");
        } else {
            System.out.println("No winner yet.");
        }
    }
}
