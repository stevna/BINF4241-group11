import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {

        int number;
        int players;

        Scanner inte = new Scanner(System.in);
        System.out.println("Please enter how many field you want: ");
        number = inte.nextInt();  // Read user input

        checkfield(number);


        System.out.println("Please enter how many players you want: ");
        players = inte.nextInt();

        checkplayers(players);


        String[] names = new String[players];
        //System.out.println(names.length);


        Scanner player = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter the players name: ");

        //System.out.println(players);

        for(int i = 0;i<players;i++){
            names[i] = player.nextLine();
            //System.out.println(names[i]);

        }


        Game mygame = new Game(number, names);



    }


     static void checkfield(int number){
        while(number< 6){
            System.out.println("You have to have at least 6 fields, please try again");
            Scanner inte = new Scanner(System.in);
            number = inte.nextInt();


        }
    }


    static void checkplayers(int players){
        while(players< 1){
            System.out.println("You have to have at least 1 player, please try again");
            Scanner inter = new Scanner(System.in);
            players = inter.nextInt();
            System.out.println("while loop " + players);


        }
    }

}