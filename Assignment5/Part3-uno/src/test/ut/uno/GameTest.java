package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {
    private static Game game;

    @BeforeClass
    public static void setUp() {
        game = Game;
    }

    /**
     * The method checks, if the game over can be set
     */
    @Test
    public void testcheckGameOver() {
        game.setToGameOver();
        Assert.assertTrue("Failed to check GameOver", game.checkGameOver());
    }

    /**
     * The method checks, if a card can be given to the player by the game
     */
    @Test
    public void testGetCardToPlayer() {
        player1 = game.getPlayers().get(0);
        int len = player1.getHandCards().length();
        game.getCardToPlayer(player1);
        Assert.assertTrue("Failed to get a card to player 1", player1.getHandCards().length() > len);
    }

    /**
     * The method checks, if the correct number of players is returned
     * We assume that two players are playing at the moment
     */
    @Test
    public void testGetPlayers() {
        Assert.assertEquals(game.getPlayers().length(), 2);
    }
}
