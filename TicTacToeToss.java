import java.util.Random;

public class TicTacToeToss {
    public static void main(String[] args) {

        Random rand = new Random();

        int toss = rand.nextInt(2); // 0 or 1

        char player1Symbol, player2Symbol;
        int currentPlayer;

        if (toss == 0) {
            currentPlayer = 1;
            player1Symbol = 'X';
            player2Symbol = 'O';

            System.out.println("Player 1 wins the toss and will start first.");
        } else {
            currentPlayer = 2;
            player1Symbol = 'O';
            player2Symbol = 'X';

            System.out.println("Player 2 wins the toss and will start first.");
        }

        System.out.println("Player 1 is assigned: " + player1Symbol);
        System.out.println("Player 2 is assigned: " + player2Symbol);
        System.out.println("Current Player: Player " + currentPlayer);
    }
}
