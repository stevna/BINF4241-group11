package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
    private static Player player1;
    private static Player player2;

    enum Color{blue, yellow, green, red, black}

    @BeforeClass
    public static void setUp() {
        player1 = new Player("Ted");
        player2 = new Player("Fred");
    }

    /**
     * The method checks, if the getter of the attribute name works as desired.
     */
    @Test
    public void testNames() {
        Assert.assertEquals("Wrong Name of player1", player1.getName(), "Ted");
        Assert.assertEquals("Wrong Name of player2", player2.getName(), "Fred");
    }

    /**
     * The method checks, if the getter of the attribute Id works as desired.
     */
    @Test
    public void testIds() {
        Assert.assertEquals(player1.getID, 0);
        Assert.assertEquals(player2.getID, 1);
    }

    /**
     * The method tests the initial handCards for each player. They should not be null.
     */
    @Test
    public void testEmptyHandCards() {
        Assert.assertNotEquals(player1.getHandCards(), null);
        Assert.assertNotEquals(player2.getHandCards(), null);
    }

    /**
     * Checks, if player1 can play a card.
     */
    @Test
    public void testPlayCard() {
        Deck d = new Deck();
        StandardCard standardCard = new StandardCard(Color.red, 7);
        d.addCardToDeck(standardCard);
        d.getCardToPlayer();
        player1.playCard("R7");
        Assert.assertEquals("Player 1 failed to play a card.", player1.getHandCards().length(), 0);
    }

    /**
     * Checks, if the getter method for the handCards works correctly.
     */
    @Test
    public void testGetHandCards() {
        StandardCard standardCard = new StandardCard(Color.red, 7);
        Wild wild = new Wild();
        player1.handCards.add(standardCard);
        player1.handCards.add(wild);
        Assert.assertEquals(player1.getHandCards.get(0), standardCard);

    }
}
