public class Square {
    private int squareId;
    private static int numberOfSquares = 0;
    private boolean isOccupied;
    // boolean isFirstSquare;
    // boolean isLastSquare;
    // boolean isleader;
    // boolean issnake;


    public Square(){
        squareId = numberOfSquares;
        setunoccupied();
        numberOfSquares++; // increase ids for every square created
    }


    public boolean isFirstSquare() {
        if (getId() == 0) {
            return true;
        }
        return false;
    }

    public int getId(){
        return squareId;
    }


    public boolean checkoccupied(){
        if(isOccupied){
            return true;
        }
        return false;
    }

    public void setoccupied(){
        isOccupied = true;
    }

    public void setunoccupied(){
        isOccupied = false;
    }

    public void  setId(int id){
        squareId = id;
    }

}
