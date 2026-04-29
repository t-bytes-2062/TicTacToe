import java.util.Scanner;

public class GameLoop {

    static Scanner sc = new Scanner(System.in);

    // UC3: Player input
    public static int getPlayerMove() {
        int slot;
        while (true) {
            System.out.print("Enter slot (1-9): ");
            if (sc.hasNextInt()) {
                slot = sc.nextInt();
                if (slot >= 1 && slot <= 9) return slot;
                else System.out.println("Invalid! Enter 1–9.");
            } else {
                System.out.println("Invalid input!");
                sc.next();
            }
        }
    }

    // UC4: Slot → row/col
    public static int[] convertSlot(int slot) {
        return new int[]{(slot - 1) / 3, (slot - 1) % 3};
    }

    // UC5: Validate move
    public static boolean isValidMove(char[][] board, int r, int c) {
        return (r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == '-');
    }

    // UC6: Update board
    public static void updateBoard(char[][] board, int r, int c, char sym) {
        board[r][c] = sym;
    }

    // Print board
    public static void printBoard(char[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }

    // Check win
    public static boolean checkWin(char[][] b, char s) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == s && b[i][1] == s && b[i][2] == s) return true; // row
            if (b[0][i] == s && b[1][i] == s && b[2][i] == s) return true; // col
        }
        if (b[0][0] == s && b[1][1] == s && b[2][2] == s) return true;
        if (b[0][2] == s && b[1][1] == s && b[2][0] == s) return true;

        return false;
    }

    // Check draw
    public static boolean isDraw(char[][] b) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (b[i][j] == '-') return false;
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        char currentPlayer = 'X';

        while (true) {

            printBoard(board);

            int slot = getPlayerMove();
            int[] pos = convertSlot(slot);
            int row = pos[0], col = pos[1];

            if (!isValidMove(board, row, col)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            updateBoard(board, row, col, currentPlayer);

            // Check win
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Check draw
            if (isDraw(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            // Switch turn
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}
