package test.ut.uno;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WildDrawFourTest {
    enum Color{black,yellow,red,blue}
    int cardValue = 4;
    private Card card;
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
    public void WildDrawFourTest(){

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

