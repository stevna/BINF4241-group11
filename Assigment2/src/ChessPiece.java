
public abstract class ChessPiece {
    private int id;
    private static int numberOfChessPieces = 0;
    int xcord;
    int ycord;
    String color;
    String shortName; // name that ist printed out in the console


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

    public abstract boolean moveValidation(Board board, int xDest, int yDest); // abstract method

    public String getColor() {
        return color;
    }
}
