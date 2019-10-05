import java.util.List;

public class Main{




    public static void main(String[] args) {

        String[] names = new String[2];
        names[0] = "XXX";
        names[1] = "YYY";
        Game mygame = new Game(16, names);

        /*Player PlayerOne = new Player("Steven");

        System.out.println(PlayerOne.getName());
        System.out.println(PlayerOne.getId());

        Player PlayerTwo = new Player("Jeff");
        System.out.println(PlayerTwo.getName());
        System.out.println(PlayerTwo.getId());


        int numberOfSquarse = 200;
        Square[] squares;
        squares = new Square[numberOfSquarse];*/

        /*Leader[] leaders;
        leaders = new Leader[numberOfSquarse];
        int leadercount = 0;*/


        // wie chömer zuefällig eh leader oder eh square erstelle
        /*for(int i = 0; i<numberOfSquarse;i++){

            double doublekindof = Math.random();
            doublekindof = doublekindof *6 + 1;
            int kindof = (int) doublekindof;

            if(kindof == 1){
                Leader leader= new Leader(i,numberOfSquarse);
                squares[i] = leader;
                System.out.println("for loop leader "+" " +leader.getId());
                System.out.println("for loop leader start"+" " +i);
                System.out.println("for loop leader end"+" " +leader.end);
                System.out.println("for loop leader move"+" " +leader.move);
            }
            else{
                Square square = new Square();
                squares[i] = square;
                System.out.println("for loop squares "+" " +square.getId());

            }
        }


        squares[numberOfSquarse-1].setLastSquare();
        squares[numberOfSquarse-1].isleader = false;
        squares[numberOfSquarse-1].issnake = false;*/


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

        /*System.out.println("this is the game now");

        while(true){

            Dice dice = new Dice();
            int diceTurn = dice.calculate();
            System.out.println(PlayerOne.getName() + " initial position is " + PlayerOne.getPosition());
            System.out.println(PlayerOne.getName()+" dice shows " + " " + diceTurn);

            if (PlayerOne.getPosition() + diceTurn < numberOfSquarse && !squares[PlayerOne.getPosition() + diceTurn].checkoccupied()) {
                //System.out.println("This is old field " + PlayerOne.getPosition() + " occupied before moving "+squares[PlayerOne.getPosition()].checkoccupied());
                squares[PlayerOne.getPosition()].setunoccupied();
                //System.out.println("This is old field " + PlayerOne.getPosition() + " occupied after moving "+squares[PlayerOne.getPosition()].checkoccupied());
                PlayerOne.move(diceTurn);
                //System.out.println("This is new field " + PlayerOne.getPosition() + " occupied before moving "+squares[PlayerOne.getPosition()].checkoccupied());
                squares[PlayerOne.getPosition()].setoccupied();
                //System.out.println("This is new field " + PlayerOne.getPosition() + " occupied after moving "+squares[PlayerOne.getPosition()].checkoccupied());

                if(squares[PlayerOne.getPosition()] instanceof Leader) {
                    int value = ((Leader)squares[PlayerOne.getPosition()]).move;
                    System.out.println(PlayerOne.getName() + "stepped on a leader/snake with value " + value );
                    PlayerOne.move(value);
                }


                System.out.println(PlayerOne.getName() + " new position is " + PlayerOne.getPosition() + "\n");


                if(squares[numberOfSquarse-1].isOccupied){
                    System.out.println(PlayerOne.getName() + " has won the game");
                    break;
                }
            }/*


            /*Dice dice2 = new Dice();
            int diceTurn2 = dice2.calculate();
            System.out.println("this is diceturn2" + " " + diceTurn2);
            System.out.println("this is position2" + " " + PlayerTwo.getPosition());
            if (PlayerTwo.getPosition() + diceTurn2 <= numberOfSquarse) {
                PlayerTwo.move(diceTurn2);

                System.out.println(PlayerTwo.getName() + " " + PlayerTwo.getPosition());


            }

            Dice.calculate();
        }*/

    }
}