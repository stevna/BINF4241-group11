package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DrawTwoTest {

    enum Color{black,yellow,red,blue}
    int cardValue = 4;
    private Card cardIni;
    private DrawTwo drawTwo;
    private static Player player1;
    private static Player player2;
    String[] player = {"Bubbles", "Thomas", "Spongebob", "Thanos" };
    private Game game;
    char flag = 'n';


    @BeforeClass
    public void setUp() {
        game = new Game();
        player1 = game.getPlayers().get(0);
    }



    @Test
    public void WildDrawTwoTest(){

        for(Card card:player1.getHandCards()){
            if(card instanceof DrawTwo == true){
                drawTwo = (DrawTwo) card;
                flag = 'y';
            }

        }
        if(flag.isEqual("y") ){
            player1.playCard(drawTwo);
            Assert.assertEquals("draw two does not work correctly", 2, game.getCardsToDraw() );

        }

        //funktioniert nonid
        else {

            while(!(cardIni instanceof DrawTwo)){
                Game.getCardToPlayer(player1, deck.drawVard());
            }
            player1.playCard(WildDrawFourTest.Color.black,cardValue);
            Assert.assertEquals("wild draw four does not work", 4, game.getCardsToDraw() );
        }

    }
}
