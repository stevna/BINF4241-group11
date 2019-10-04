import java.lang.Math;

public class Leader extends Square{
    public int move;
    int end;

    public Leader(int start, int numberOfSquares){
        double enddouble = Math.random();
        enddouble = enddouble *numberOfSquares + 1;
        end = (int) enddouble;

        move = end-start;
    }

}
