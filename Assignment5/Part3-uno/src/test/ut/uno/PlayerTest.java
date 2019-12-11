package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class PlayerTest {
    private static Player player1;
    private static Player player2;

    enum Color{Blue, Yellow, Green, Red, Black}

    @BeforeClass
    public static void setUp() {
        player1 = new Player("Ted");
        player2 = new Player("Fred");
    }

    @Test
    public void testNames() {
        Assert.assertEquals("Wrong Name of player1", player1.getName(), "Ted");
        Assert.assertEquals("Wrong Name of player2", player2.getName(), "Fred");
    }

    @Test
    public void testIds() {
        Assert.assertEquals(player1.getID, 0);
        Assert.assertEquals(player2.getID, 1);
    }

    @Test
    public void testEmptyHandCards() {
        Assert.assertNotEquals(player1.handCards, null);
        Assert.assertNotEquals(player2.handCards, null);
    }

    @Test
    public void testPlayCard() {
        Deck d = new Deck();
        StandardCard standardCard = new StandardCard(Color.Red, 7);
        d.addCardToDeck(standardCard);
        d.getCardToPlayer();
        player1.playCard("R7");
        Assert.assertEquals("Player 1 failed to play a card.", player1.getHandCards().length(), 0);
    }

    @Test
    public void testGetHandCards() {
        StandardCard standardCard = new StandardCard(Color.Red, 7);
        Wild wild = new Wild();
        player1.handCards.add(standardCard);
        player1.handCards.add(wild);
        Assert.assertEquals(player1.getHandCards.get(0), standardCard);

    }
}
