import java.lang.Math;



public class Dice {
    public static int calculate(){
        double randomDouble = Math.random();
        randomDouble = randomDouble *6 + 1;
        int randomInt = (int) randomDouble;
        return randomInt;
    }
}

