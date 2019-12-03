package softcon.tictactoe.tictactoe;

import java.util.Scanner;

import softcon.tictactoe.ai.GameIntelligenceAgent;
import softcon.tictactoe.ai.MinimaxAgent;
import softcon.tictactoe.ai.heuristic.tictactoe.TicTacToeEvaluator;
import softcon.tictactoe.tictactoe.TicTacToeGameState.Player;

public class TicTacToeMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TicTacToeEvaluator evaluator = new TicTacToeEvaluator(Player.O);
    GameIntelligenceAgent<TicTacToeGameState> agent =
        new MinimaxAgent<TicTacToeGameState>(evaluator);
    Scanner scanner = new Scanner(System.in);
    TicTacToeGameRunner game = new TicTacToeGameRunner(agent, scanner, System.out);

    game.run();
  }

}
