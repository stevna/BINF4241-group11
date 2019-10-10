import java.util.Collection;
import java.util.Collections;

public class Main {


    enum Color {black,white};


    public static void main(String[] args){
        Board board = new Board();
        for(Color color: Color.values()){
            King king = new King(color);

            for(int i = 0;i<64;i++){
                System.out.println(board.getArray(i).getCoord().get(0));
                System.out.println("king initial positoin"+king.getInitial().get(0));
                //Collections.sort(king.getInitial());
                //Collections.sort(board.getArray(i).getCoord());
                if(king.getInitial().get(0).toString() == board.getArray(i).getCoord().get(0).toString() && king.getInitial().get(1).equals(board.getArray(i).getCoord().get(1))){
                    board.getArray(i).setoccupied();
                    System.out.println("fuck" + i);

                    //System.out.println(board.getArray(i).getId());


                }
            }
            System.out.println(board.getArray(3).checkoccupied());
            System.out.println(board.getArray(59).checkoccupied());
            System.out.println(board.getArray(5).checkoccupied());

            for(int u = 0;u<64;u++){
                if(board.getArray(u).checkoccupied()){
                    System.out.println(board.getArray(u).getCoord());
                }

            }




            //System.out.println(king.getColor());
        }
        //if board.getArray()


    }

}
