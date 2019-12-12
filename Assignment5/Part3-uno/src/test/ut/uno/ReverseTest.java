package test.ut.uno;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseTest {
    private static Card card;
    enum Color{black,yellow,red,blue,green};
    private static Game game;

    @BeforeClass
    public static void setUp() {
        game = Game(players);
        card = new Reverse("color.green");

    }

    /**
     * The method checks if the reverse card works
     */
    @Test
    public void testReverse() {
        Player player = game.getPlayers().get(0);
        card.performExecute();
        Assert.assertEquals("Failed to reverse player order.",game.getPlayers().get(2),player);
    }

}
