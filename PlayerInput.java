import java.util.Scanner;

public class PlayerInput {

    // Method to get valid slot input
    public static int getPlayerMove() {
        Scanner sc = new Scanner(System.in);
        int slot;

        while (true) {
            System.out.print("Enter slot number (1-9): ");

            // Check if input is integer
            if (sc.hasNextInt()) {
                slot = sc.nextInt();

                // Check valid range
                if (slot >= 1 && slot <= 9) {
                    return slot;  // valid input → return
                } else {
                    System.out.println("Invalid input! Enter number between 1 and 9.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // clear wrong input
            }
        }
    }

    public static void main(String[] args) {
        int move = getPlayerMove();
        System.out.println("You selected slot: " + move);
    }
}
