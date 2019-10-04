import java.lang.Math;

public class Leader {
    int move;
    int leaderId;

    public Leader(int start, int numberOfSquares){
        double enddouble = Math.random();
        enddouble = enddouble *numberOfSquares + 1;
        int end = (int) enddouble;

        move = end-start;
    }

    public int setID(int id){
        leaderId = id;
        return leaderId;

    }

}
