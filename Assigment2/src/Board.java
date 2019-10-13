import java.util.ArrayList;


public class Board {
    enum fields {A,B,C,D,E,F,G,H};
    private ArrayList<Square> coordinates = new ArrayList <>();


    public Board(){
        for (int z=0;z<8;z++){
            for(fields xCoord: fields.values()){
            Square square = new Square(xCoord,z);
            //System.out.println(square.getId());
            //System.out.println(xCoord + " " + square.getyCoord());
            coordinates.add(square);
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
        return coordinates.get(i);
    }

}
