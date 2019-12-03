package softcon.tictactoe.tictactoe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import softcon.tictactoe.Position;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;


public class GameBoardTest {

  private GameBoard board;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setup() {
    board = new GameBoard();
  }

  // -- constructor

  @Test
  public void copyConstructor() {
    board.mark(0, 0, TicTacToeGameState.Player.X);
    GameBoard newBoard = new GameBoard(board);
    Assert.assertEquals(newBoard.getMark(0, 0), TicTacToeGameState.Player.X);

    newBoard.mark(1, 1, TicTacToeGameState.Player.O);
    Assert.assertThat(board.getMark(1, 1), not(equalTo(TicTacToeGameState.Player.X)));
  }

  // -- getMark
  @Test
  public void getMarkUnmarked() {
    Assert.assertNull(board.getMark(0, 0));
  }

  @Test
  public void getMarkOffBoard() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("(3,0) is off the board");
    board.getMark(3, 0);
  }

  @Test
  public void getMarkOffBoardNegative() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("(-1,0) is off the board");
    board.getMark(-1, 0);
  }

  // -- mark

  @Test
  public void markOnBoard() {
    boolean success = board.mark(0, 0, TicTacToeGameState.Player.O);

    Assert.assertTrue(success);
    Assert.assertEquals(board.getMark(0, 0), TicTacToeGameState.Player.O);
  }

  @Test
  public void markTwice() {
    board.mark(0, 0, TicTacToeGameState.Player.O);
    boolean success = board.mark(0, 0, TicTacToeGameState.Player.X);

    Assert.assertFalse(success);
    Assert.assertEquals(board.getMark(0, 0), TicTacToeGameState.Player.O);
  }

  @Test
  public void markNull() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("cannot mark null player");
    board.mark(0, 0, null);
  }

  @Test
  public void markOffBoard() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("(3,0) is off the board");
    board.mark(3, 0, null);
  }

  // -- getOpenPositions

  @Test
  public void getOpenPositionsAll() {

    List<Position> positionsToTest = new ArrayList<>() {{
      add(new Position(0, 0));
      add(new Position(0, 1));
      add(new Position(0, 2));
      add(new Position(1, 0));
      add(new Position(1, 1));
      add(new Position(1, 2));
      add(new Position(2, 0));
      add(new Position(2, 1));
      add(new Position(2, 2));
    }};

    for(Position p : positionsToTest) {
      Assert.assertTrue(board.getOpenPositions().contains(p));
    }
  }

  @Test
  public void getOpenPositions() {
    board.mark(0, 0, TicTacToeGameState.Player.X);

    List<Position> positionsToTest = new ArrayList<>() {{
      add(new Position(0, 1));
      add(new Position(0, 2));
      add(new Position(1, 0));
      add(new Position(1, 1));
      add(new Position(1, 2));
      add(new Position(2, 0));
      add(new Position(2, 1));
      add(new Position(2, 2));
    }};

    for(Position p : positionsToTest) {
      Assert.assertTrue(board.getOpenPositions().contains(p));
    }
  }
}
