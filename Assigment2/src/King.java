import java.util.ArrayList;

public class King extends ChessPiece {
    ArrayList<Object> initialposition = new ArrayList<>();

    public King(Enum col) {
        super();
        color = col.toString();

        if (color == "white"){
            initialposition.add(fields.D);
            initialposition.add(0);
            System.out.println("white"+initialposition);

    }
        else if(color == "black"){
            initialposition.add(fields.D);
            initialposition.add(7);
            System.out.println("black"+initialposition);

        }



}



    public String getColor() {
        return color;
    }
    public ArrayList getInitial(){
        return initialposition;
    }
}
