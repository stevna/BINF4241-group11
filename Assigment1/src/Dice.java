import java.lang.Math;



public class Dice {
    public static int calculate(){

        //output is a random number, which siumulates the dice
        double randomDouble = Math.random();
        randomDouble = randomDouble *6 + 1;
        int randomInt = (int) randomDouble;
        return randomInt;
    }
}

