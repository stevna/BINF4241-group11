import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {

        int number;
        int players;

        try {
            Scanner inte = new Scanner(System.in);
            System.out.println("Please enter how many field you want: ");
            number = checkfield(inte.nextInt());

            System.out.println("Please enter how many players you want: (type one name, press enter and so on) ");
            players = checkplayers(inte.nextInt());


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
        catch (InputMismatchException e){
            System.out.println("Please fill in a number and start the programm again.");

        }

        catch (IndexOutOfBoundsException p){
            System.out.println("There went something wrong, please start the programm again");
        }


    }


     static int checkfield(int number){
        while(number< 6){
            System.out.println("You have to have at least 6 fields, please try again");
            Scanner inte = new Scanner(System.in);
            number = inte.nextInt();
        }
        return number;
    }


    static int checkplayers(int players){
        while(players < 2){
            System.out.println("You have to have at least 2 player, please try again");
            Scanner inter = new Scanner(System.in);
            players = inter.nextInt();
        }
        return players;
    }

}