import java.util.List;
import java.util.ArrayList;

public class Square {
    private int SquareId;
    private static int numberOfSquares = 0;
    private boolean isOccupied;
    private Enum xCoord;
    private int yCoord;
    enum Color{black,white}
    ArrayList<Object> coordinates = new ArrayList <>();



    public Square(Enum xCoord, int yCoord){
        SquareId =numberOfSquares;
        setunoccupied();
        numberOfSquares++;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        coordinates.add(xCoord);
        coordinates.add(yCoord);

        // System.out.println("coordinates in square are " + coordinates);
        // numberOfSquares++;

    }

    public ArrayList getCoord(){
        return coordinates;

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

    public int getId(){
        return SquareId;
    }

    public Enum getxCoord(){
        return xCoord;



    }

    public int getyCoord(){
        return yCoord;



    }
}
