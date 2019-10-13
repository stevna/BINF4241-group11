import java.util.ArrayList;

public class Game {


    //different enums for initialization to know where to initialise which piece
    enum Color {black,white};
    enum FieldsPawns {A,B,C,D,E,F,G,H};
    enum FieldsRook{A,H};
    enum FieldsKnight{B,G};
    enum FieldsBishop{C,F};
    ArrayList<ChessPiece> pieces = new ArrayList<>();
    Board board;


    public Game() {
        placeInitial();
        //bispiel ihgob
        String inputX = "B"; //userinput example
        int inputY = 7;       // userinput example



        for (int u = 0; u < 32; u++) {
            //do nimmi input x, wandles um und input y und denn suechi das feld woner wett und mach denn mitem andere for loop en move
            if (pieces.get(u).getLastMovement().get(0).toString() == inputX && pieces.get(u).getLastMovement().get(1).equals(inputY)) {
                pieces.get(u).move(FieldsPawns.A,5);
                System.out.println(pieces.get(u).color + " " + pieces.get(u).pieceName +  " with id " + pieces.get(u).getId() + " has been moved"  );
            }
        }

        for (int a = 0; a < 32; a++) {
            if (pieces.get(a).getId() == 12) {
                System.out.println("initial position was " + pieces.get(a).getInitial());
                System.out.println("new position is " + pieces.get(a).movements.get((pieces.get(a).movements.size()-1)));
                //check if the moving worked

                //System.out.println(pieces.get(u).getId());
            }
        }
    }


    private void placeInitial(){

        board = new Board();

        //for both color, black and white, do the following
        for(Color color: Color.values()){
            King king = new King(color);
            pieces.add(king);
            Queen queen = new Queen(color);
            pieces.add(queen);

            //for every enum in FieldPawns create the corresponding Pawns
            for(FieldsPawns field:FieldsPawns.values()){
                Pawn pawn= new Pawn(color,field);
                pieces.add(pawn);
            }

            for(FieldsRook field:FieldsRook.values()){
                Rook rook = new Rook(color,field);
                pieces.add(rook);
            }

            for(FieldsKnight field: FieldsKnight.values()){
                Knight knight = new Knight(color,field);
                pieces.add(knight);
            }

            for(FieldsBishop field: FieldsBishop.values()){
                Bishop bishop = new Bishop(color,field);
                pieces.add(bishop);
            }
        }


        for(int q = 0;q<pieces.size();q++){
            //loop through the pieces array and check their initial position
            for(int i = 0;i<64;i++){
                //check for every square if a piece is on it. if so, set to occupied        to string is needed, otherwise I cant compares enum? so i have to take the first of the array initialposition which is the x-axis, convert and the compare it
                if(pieces.get(q).getInitial().get(0).toString() == board.getArray(i).getCoord().get(0).toString() && pieces.get(q).getInitial().get(1).equals(board.getArray(i).getCoord().get(1))){
                    board.getArray(i).setoccupied();
                    System.out.println(pieces.get(q).color +" "+ pieces.get(q).pieceName+ " with id " + pieces.get(q).getId() + " " + "initial position square id is " + board.getArray(i).getId() + " and coordinates are " + pieces.get(q).getInitial());
                    //System.out.println(board.getArray(i).getId());

                }
            }
        }
    }

    /*for(int u = 0;u<64;u++){
        if(board.getArray(u).checkoccupied()){
            System.out.println(board.getArray(u).getCoord() + " is occupied");
        }


    }*/

}
