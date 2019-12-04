package test.ut.snakeandladder;

import main.Player;
import main.Square;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest {
    private Square square1;
    private Square square2;
    private Player player;

    @Before
    public void setUp() {
        this.square1 = new Square();
        this.square2 = new Square();
        this.player = new Player("Lary");
    }

    /*@Test
    public void testUnoccupied(){
        Assert.assertFalse("Square is occupied, should be unocuppied",square1.checkoccupied());
    }
    */

    @Test
    public void TestEnterSquare(){
        Assert.assertFalse("Square is occupied, should be unocuppied",square2.checkoccupied());
        player.enterSquare(square2);
        Assert.assertTrue("Square is unoccupied, should be ocuppied",square2.checkoccupied());
    }

    @Test
    public void TestRemoveFromSquare(){
        square2.setoccupied();
        Assert.assertTrue("Square is unoccupied, should be ocuppied",square2.checkoccupied());
        player.removeFromSquare(square2);
        Assert.assertFalse("Square is occupied, should be unocuppied",square2.checkoccupied());
    }



}
