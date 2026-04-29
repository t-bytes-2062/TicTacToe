import java.util.Random;

public class ComputerMove {

    // Reuse from UC4
    public static int[] convertSlot(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // Reuse from UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // Reuse from UC6
    public static void updateBoard(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Print board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC7: Computer move
    public static void computerMove(char[][] board, char symbol) {
        Random rand = new Random();
        int slot, row, col;

        while (true) {
            slot = rand.nextInt(9) + 1; // 1–9
            int[] pos = convertSlot(slot);
            row = pos[0];
            col = pos[1];

            if (isValidMove(board, row, col)) {
                updateBoard(board, row, col, symbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', '-', '-'},
            {'-', 'O', '-'},
            {'-', '-', '-'}
        };

        System.out.println("Before Move:");
        printBoard(board);

        computerMove(board, 'O');

        System.out.println("\nAfter Computer Move:");
        printBoard(board);
    }
}
