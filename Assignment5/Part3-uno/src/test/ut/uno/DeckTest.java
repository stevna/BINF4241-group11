package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeckTest {
    private static Deck d;

    enum Color{Blue, Yellow, Green, Red, Black}

    /**
     * The method sets up needed things for testing. A deck is created.
     */
    @BeforeClass
    public static void setUp() {
        d = new Deck();

    }

    /**
     * The method tests, if deck is able to draw a card correctly.
     */
    @Test
    public void testDrawCard() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        d.addCardToDeck(card);
        d.drawCard();
        Assert.assertEquals("Could not draw a card.", d.getDeck().length(), 0);
    }

    /**
     * The method tests, if the actual deck is returned.
     */
    @Test
    public void testGetDeck() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        d.addCardToDeck(card);
        Assert.assertEquals("Failed to return the deck.", d.getDeck().get(0), card);
    }

    /**
     * This method checks, if the deck can be shuffled with its shuffle method.
     */
    @Test
    public void testShuffle() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        Wild wild = new Wild();
        Deck d1 = new Deck();
        Deck d2 = new Deck();
        d1.addCardToDeck(card);
        d1.addCardToDeck(wild);
        d2.addCardToDeck(card);
        d2.addCardToDeck(wild);
        d1.shuffle();
        Assert.assertNotEquals(d1.getDeck().get(0), d2.getDeck.get(0));

    }

    /**
     * The method tests, if the addCardToDeck method works correctly.
     */
    @Test
    public void testAddCardToDeck() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        Deck d1 = new Deck();
        d1.addCardToDeck(card);
        Assert.assertNotEquals(d1.getDeck().get(0), card);
    }

    /**
     * The method tests, if the removeCardOfDeck method works correctly.
     */
    @Test
    public void testRemoveCardOfDeck() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        Deck d1 = new Deck();
        d1.addCardToDeck(card);
        d1.removeCardOfDeck(card);
        Assert.assertNotEquals(d1.getDeck().get(0), null);
    }


}
