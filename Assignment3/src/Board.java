
public class Board {
    // This class includes some small information about the occupy the chess fields
    // It is required for the validation of the moves of the chess pieces

    // Initialize the matrix
    private boolean[][] matrix = new boolean[8][8];
    private static Board uniqueInstance;

    private Board(){

        // Set initial positions of the pieces to occupied
        for(int y=0;y<2;y++) {
            for(int x=0;x<8;x++){
                enter(x,y);
            }
        }
        for(int y=7;y>5;y--) {
            for(int x=0;x<8;x++){
                enter(x,y);
            }
        }
    }

    public static Board getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Board();
        }
        return uniqueInstance;
    }

    // Prints the board
    public void printMatrix(){
        for(int y=7;y>=0;y--) {
            for(int x=0;x<8;x++){
                System.out.print("["+matrix[y][x]+"]");
            }
            System.out.println();
        }
    }

    // Checks if a specific field is occupied
    public boolean isOccupied(int x, int y){
        return matrix[y][x];
    }

    // Mark a specific field as occupied
    public void enter(int x, int y){
        matrix[y][x] = true;
    }

    // Mark a specific field as unoccupied
    public void leave(int x, int y){
        matrix[y][x] = false;
    }

}


