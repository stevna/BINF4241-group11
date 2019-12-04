
public abstract class ChessPiece {
    private int id;
    private static int numberOfChessPieces = 0;
    int xcord;
    int ycord;
    String color;
    String shortName; // name that ist printed out in the console
    private boolean firstMove = true;
    private Board board;


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
        board = Board.getInstance();
    }

    public abstract boolean moveValidation(Board board, int xDest, int yDest); // abstract method

    public boolean captureValidation(Board board, int xDest, int yDest){
        return true;
    }

    public String getColor() {
        return color;
    }

    void setFirstMoveToFalse() {
        firstMove = false;
    }

    boolean isFirst_move() {
        return firstMove;
    }



}
