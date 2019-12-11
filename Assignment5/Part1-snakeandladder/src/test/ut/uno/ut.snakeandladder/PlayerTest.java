package test.ut.uno.ut.snakeandladder;

import main.Player;
import main.Square;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Class for Testing the player, entering and removing from a square.
 */
public class PlayerTest {
    private Square square1;
    private Square square2;
    private Player player;


    /**
     * Method sets up required things for testing. Two squares and a player are instantiated.
     */
    @Before
    public void setUp() {
        this.square1 = new Square();
        this.square2 = new Square();
        this.player = new Player("Bubbles");
    }

    /*@Test
    public void testUnoccupied(){
        Assert.assertFalse("Square is occupied, should be unoccupied",square1.checkoccupied());
    }
    */


    /**
     * Method asserts, that enterSquare method works, the square in the beginning is unoccupied and after the entering occupied.
     */
    @Test
    public void TestEnterSquare(){
        Assert.assertFalse("Square is occupied, should be unoccupied",square2.checkoccupied());
        player.enterSquare(square2);
        Assert.assertTrue("Square is unoccupied, should be occupied",square2.checkoccupied());
    }


    /**
     * Method asserts, that removeFromSquare method works, the square in the beginning is occupied and after the moving unoccupied
     */
    @Test
    public void TestRemoveFromSquare(){
        square2.setoccupied();
        Assert.assertTrue("Square is unoccupied, should be occupied",square2.checkoccupied());
        player.removeFromSquare(square2);
        Assert.assertFalse("Square is occupied, should be unoccupied",square2.checkoccupied());
    }



}
