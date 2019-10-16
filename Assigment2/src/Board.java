
public class Board {
    private boolean[][] matrix = new boolean[8][8];
    public Board(){
        for(int y=0;y<2;y++) {
            for(int x=0;x<8;x++){
                matrix[y][x] = true;
            }
        }
        for(int y=7;y>5;y--) {
            for(int x=0;x<8;x++){
                matrix[y][x] = true;
            }
        }
    }

    public void printMatrix(){
        for(int y=7;y>=0;y--) {
            for(int x=0;x<8;x++){
                System.out.print("["+matrix[y][x]+"]");
            }
            System.out.println();
        }
    }

    public boolean isOccupied(int x, int y){
        return matrix[y][x];
    }

    public void enter(int x, int y){
        matrix[y][x] = true;
    }
    public void leave(int x, int y){
        matrix[y][x] = false;
    }
    /*
    enum fields {A,B,C,D,E,F,G,H};
    private ArrayList<Square> squares = new ArrayList <>();


    public Board(){
        for (int y=1;y<=8;y++){
            for(fields xCoord: fields.values()){
                Square square = new Square(xCoord,y);
                //System.out.println(square.getId());
                //System.out.println(xCoord + " " + square.getyCoord());
                squares.add(square);
            }
        }


        int counter0 = 56;
        int counter1 = 64;

        for(int p =0;p<8;p++){
            System.out.println(coordinates.subList(counter0,counter1));
            counter0-=8;
            counter1-=8;
        }

    }

    public Square getArray(int i){
        return squares.get(i);
    }
*/

}
