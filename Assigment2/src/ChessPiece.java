import java.util.ArrayList;

public class ChessPiece {
    private int id;
    private static int numberOfChessPieces = 0;
    int xcord;
    int ycord;
    String color;
    String shortName;


    public ChessPiece(){
        id = numberOfChessPieces;
        numberOfChessPieces++;

    }

    public String getShortName() {
        return shortName;
    }

    public int getId() {
        return id;
    }

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }

    public void setCord(int x, int y) {
        this.xcord = x;
        this.ycord = y;
    }
    public boolean moveValidation(int xDest, int yDest) {
        return true;
    }

    public String getColor() {
        return color;
    }
}
