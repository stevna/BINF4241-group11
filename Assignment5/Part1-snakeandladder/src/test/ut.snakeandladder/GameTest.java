package ut.snakeandladder;

import main.Game;
import main.Leader;
import main.Square;
import main.Snake;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GameTest {
    private Game game;


    @Before
    public void setUp() {
        String[] names = {"Blossom", "Bubbles"};
        game = new Game(20, names);

    }

    @Test
    public void TestBoardSize(){
        int cnt=0;
        for(Square s: game.getSquares()){
            cnt++;
        }
        Assert.assertEquals("Wrong number of squares.",cnt,20);
    }

    @Test
    public void TestFirstLast(){
        Square s1 = game.getSquares().get(0);
        Assert.assertFalse("First square is a leader.", s1 instanceof Leader);

        //Square s2 = game.getSquares().get(19);
        //Assert.assertFalse("Last square is a snake.", s2 instanceof Snake);
    }


}
