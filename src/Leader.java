import java.lang.Math;

public class Leader extends Square{
    //public int move;
    public int end;

    public Leader(int numberOfSquares){
        super();
        double enddouble = Math.random();
        enddouble = enddouble *numberOfSquares + getId()+1;
        end = (int) enddouble;

        //move = end-start;
    }

    public int getEnd() {
        return end;
    }

}
