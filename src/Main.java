import java.util.List;

public class Main{




    public static void main(String[] args) {
        Player PlayerOne = new Player("Steven");

        System.out.println(PlayerOne.getName());
        System.out.println(PlayerOne.getId());

        Player PlayerTwo = new Player("Jeff");
        System.out.println(PlayerTwo.getName());
        System.out.println(PlayerTwo.getId());


        int numberOfSquarse = 16;
        Square[] squares;
        squares = new Square[numberOfSquarse];

        Leader[] leaders;
        leaders = new Leader[numberOfSquarse];
        int leadercount = 0;

        for(int i = 0; i<numberOfSquarse;i++){
            Square square = new Square();
            System.out.println("for loop squares "+" " +square.getId());
            square.checkleader();
            square.checksnake();
            squares[i] = square;

            if(squares[i].isleader){
                Leader leader = new Leader(i,numberOfSquarse);
                leader.setID(i);
                System.out.println("leader" + leader.move);
                leaders[i] = leader;
                leadercount++;

;            }
        }
        System.out.println(squares);
        //print on same line?

        squares[numberOfSquarse-1].setLastSquare();
        squares[numberOfSquarse-1].isleader = false;
        squares[numberOfSquarse-1].issnake = false;


        /*Square square1 = new Square();
        System.out.println(square1.getId());
        square1.checkFirstSquare();

        Square square2 = new Square();
        System.out.println(square2.getId());
        square2.checkFirstSquare();


        Square square3 = new Square();
        System.out.println(square3.getId());

        Square square4 = new Square();
        System.out.println(square4.getId());

        Square square5 = new Square();
        System.out.println(square5.getId());

        Square square6 = new Square();
        System.out.println(square6.getId());

        Square square7 = new Square();
        System.out.println(square7.getId());

        Square square8 = new Square();
        System.out.println(square8.getId());

        Square square9 = new Square();
        System.out.println(square9.getId());
        square9.checkLastSquare();*/

        System.out.println("this is the game now");

        while(true){

            Dice dice = new Dice();
            int diceTurn = dice.calculate();
            System.out.println("this is diceturn" + " " + diceTurn);
            System.out.println("this is position" +" " + PlayerOne.getPosition());
            if (PlayerOne.getPosition() + diceTurn < numberOfSquarse && !squares[PlayerOne.getPosition() + diceTurn].checkoccupied()) {
                System.out.println("This is old field " + PlayerOne.getPosition() + " occupied before moving "+squares[PlayerOne.getPosition()].checkoccupied());
                squares[PlayerOne.getPosition()].setunoccupied();
                System.out.println("This is old field " + PlayerOne.getPosition() + " occupied after moving "+squares[PlayerOne.getPosition()].checkoccupied());
                PlayerOne.move(diceTurn);
                System.out.println("This is new field " + PlayerOne.getPosition() + " occupied before moving "+squares[PlayerOne.getPosition()].checkoccupied());
                squares[PlayerOne.getPosition()].setoccupied();
                System.out.println("This is new field " + PlayerOne.getPosition() + " occupied after moving "+squares[PlayerOne.getPosition()].checkoccupied());

                if(squares[PlayerOne.getPosition()].isleader){
                    for(int i = 0; i<leadercount;i++){
                        if(leaders[i].leaderId == PlayerOne.getPosition()){
                            PlayerOne.move(leaders[i].move);
                            System.out.println("PLayer was moved by a leader" + PlayerOne.getPosition());
                        }
                    }

                }

                System.out.println(PlayerOne.getName() + " " + PlayerOne.getPosition());

                if(squares[numberOfSquarse-1].isOccupied){
                    System.out.println(PlayerOne.getName() + " has won the game");
                    break;
                }
            }


            Dice dice2 = new Dice();
            int diceTurn2 = dice2.calculate();
            System.out.println("this is diceturn2" + " " + diceTurn2);
            System.out.println("this is position2" + " " + PlayerTwo.getPosition());
            if (PlayerTwo.getPosition() + diceTurn2 <= numberOfSquarse) {
                PlayerTwo.move(diceTurn2);

                System.out.println(PlayerTwo.getName() + " " + PlayerTwo.getPosition());


            }

        }
        Dice.calculate();
    }
}