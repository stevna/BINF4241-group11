import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] names = new String[2];
        Scanner player = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter the players name: (type one name, press enter and so on)  ");

        //System.out.println(players);

        for(int i = 0;i<2;i++){
            names[i] = player.nextLine();
            //System.out.println(names[i]);

        }
        Game game = new Game(names);

    }






    }

