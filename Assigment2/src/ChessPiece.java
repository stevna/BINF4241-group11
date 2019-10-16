import java.util.ArrayList;

public class ChessPiece {
    private int id;
    private static int numberOfChessPieces = 0;
    int xdest;
    int ydest;
    String color;
    ArrayList <Object>initialposition = new ArrayList<>();
    ArrayList <ArrayList>movements = new ArrayList<>();


    enum fields {A,B,C,D,E,F,G,H};
    String pieceName;
    String shortName;


    public ChessPiece(){
        // ArrayList initialposition;
        id = numberOfChessPieces;
        numberOfChessPieces++;


    }

    public ArrayList getInitial(){
        return initialposition;
    }

    public void move(String xDest, int yDest){
        ArrayList<Object> move = new ArrayList<>();
        move.add(xDest);
        move.add(yDest);

        movements.add(move);


    }

    public int getId(){
        return id;
    }

    public ArrayList getMovements(){
        return movements;

    }

    public ArrayList getLastMovement(){
        return movements.get((movements.size()-1));
    }

    public String getShortName() {
        return shortName;
    }
}
