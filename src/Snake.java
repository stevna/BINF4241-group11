import java.lang.Math;

public class Snake extends Square{
    //public int move;
    public int end;

    public Snake(){
        super();
        double enddouble = Math.random();
        enddouble = enddouble *(getId()-1) + 1;
        end = (int) enddouble;

        //move = end-start;
    }

    public int getEnd() {
        return end;
    }

}
