import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ask for the player's names
        String[] names = new String[2];
        Scanner player = new Scanner(System.in);
        System.out.println("Please enter the players name: (type one name, press enter and type the second name)  ");
        for(int i = 0;i<2;i++){
            names[i] = player.nextLine();
        }

        // Initialize the game
        Game game = new Game(names);

        // Start the game
        game.play();

    }
}
