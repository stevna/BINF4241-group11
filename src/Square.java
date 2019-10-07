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

        /*
        double leaderdouble = Math.random();
        leaderdouble = leaderdouble *6 + 1;
        int leaderint = (int) leaderdouble;

        double snakedouble = Math.random();
        snakedouble = snakedouble *6 + 1;
        int snakeint = (int) snakedouble;


        if(leaderint == 1 && squareId != 0){
            isleader = true;
        }

        if(snakeint == 1 && squareId != 0){
            issnake = true;
        }
        */

        numberOfSquares++;
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

    /*
    public boolean checkFirstSquare(){
        if (isFirstSquare){
            System.out.println("This is the first square");
            return true;
        }
        return false;
    }

    public boolean checkLastSquare(){
        if (isLastSquare){
            System.out.println("this is the last square");
            return true;
        }
        return false;
    }
    */

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

    /*
    public void checkleader(){
        if(isleader){
            System.out.println("this is the start of a leader");
        }
    }

    public void checksnake(){
        if(issnake){
            System.out.println("this is the start of a snake");
        }
    }
    */



}
