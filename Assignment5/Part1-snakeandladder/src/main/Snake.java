package main;
import java.lang.Math;
import java.util.ArrayList;


public class Snake extends Square{
    //public int move;
    private int end;
    public ArrayList<Integer> endOfLeader2;

    public Snake(){
        super();
        getEndSquare();


        //move = end-start;
    }

    public int getEnd() {
        return end;
    }

    public int setEnd(int end2){
        end = end2;
        return end;
    }


    private void getEndSquare(){
        double enddouble = Math.random();
        enddouble = enddouble *(getId()-1) + 0;
        end = (int) enddouble;


    }

    public int getLength(){
        return getId()-getEnd();
    }

}
