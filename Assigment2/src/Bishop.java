import java.util.ArrayList;

public class Bishop extends ChessPiece {
    ArrayList<Object> initialposition = new ArrayList<>();
    public Bishop(Enum col){
    super();
    color = col.toString();

        if (color == "white"){
            for(int i = 0;i<7;i++) {
                initialposition.add(fields.values());
                initialposition.add(0);
                System.out.println("white" + initialposition);
            }

    }
        else if(color == "black"){
        initialposition.add(fields.D);
        initialposition.add(7);
        System.out.println("black"+initialposition);

    }



}
}
