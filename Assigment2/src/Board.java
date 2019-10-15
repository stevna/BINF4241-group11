import java.util.ArrayList;


public class Board {
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

        /*
        int counter0 = 56;
        int counter1 = 64;

        for(int p =0;p<8;p++){
            System.out.println(coordinates.subList(counter0,counter1));
            counter0-=8;
            counter1-=8;
        }
        */
    }

    public Square getArray(int i){
        return squares.get(i);
    }


}
