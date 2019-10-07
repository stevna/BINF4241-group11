import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {

        Scanner inte = new Scanner(System.in);
        System.out.println("Please enter how many field you want: ");
        int number = inte.nextInt();  // Read user input

        if(number< 6){
            System.out.println("You have to have at least 6 fields, please start again\n");
            String[] met = null;
            main(met);
        }



        System.out.println("Please enter how many players you want: ");
        int players = inte.nextInt();
        if(players< 1){
            System.out.println("You have to be at least 2 players to play, please start again\n");
            String[] met = null;
            main(met);
        }


        String[] names = new String[players];
        System.out.println(names.length);


        Scanner player = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter the players name: ");

        for(int i = 0;i<players;i++){
            names[i] = player.nextLine();
            System.out.println(names[i]);

        }


        Game mygame = new Game(number, names);



    }
}