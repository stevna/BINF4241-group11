package test.ut.uno;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WildDrawFourTest {
    enum Color{black,yellow,red,blue, green}
    int cardValue = 4;
    private Card card;
    private static Player player1;
    private static Player player2;
    String[] players = {"Bubbles", "Thomas", "Spongebob", "Thanos" };
    private Game game;
    char flag = 'n';


    @BeforeClass
    public void setUp() {
        game = new Game(players);
        player1 = game.getPlayers().get(0);
    }

    /**
     * Checks, if the behavior of the WildDrawTwo card works as expected
     * Since we initialise the Players with the handcard when creating the game, we first test if player one got a wilddrawfour or not. if not, he draws cards unless
     * he gets one. After that he plays the card, and +4 should be addedcto the Cards to draw from the game. This variable is needed, since anohter +4 could be played.
     */
    @Test
    public void testWildDrawFour(){

        for(Card card:player1.getHandCards()){
            if(card.getColor().isEqual(Color.black.toString()) && card.getValue()){
                flag = 'y';
            }

        }
        if(flag.isEqual("y") ){
            player1.playCard(Color.black,cardValue);
            Assert.assertEquals("wild draw four does not work", 4, game.getCardsToDraw() );

        }
        else {

            while(!(card.getColor.toString().equals(Color.black.toString()) && card.getValue == 4)) {
                Game.getCardToPlayer(player1, deck.drawCard());
            }
            player1.playCard(Color.black,cardValue);
            Assert.assertEquals("wild draw four does not work", 4, game.getCardsToDraw() );
        }

    }

}

