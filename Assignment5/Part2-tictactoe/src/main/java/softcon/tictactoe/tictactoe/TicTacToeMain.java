package main.java.softcon.tictactoe.tictactoe;

import java.util.Scanner;

import main.java.softcon.tictactoe.ai.GameIntelligenceAgent;
import main.java.softcon.tictactoe.ai.MinimaxAgent;
import main.java.softcon.tictactoe.ai.heuristic.tictactoe.TicTacToeEvaluator;
import main.java.softcon.tictactoe.tictactoe.TicTacToeGameState.Player;

public class TicTacToeMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TicTacToeEvaluator evaluator = new TicTacToeEvaluator(Player.O);
    GameIntelligenceAgent<TicTacToeGameState> agent =
        new MinimaxAgent<main.java.softcon.tictactoe.tictactoe.TicTacToeGameState>(evaluator);
    Scanner scanner = new Scanner(System.in);
    main.java.softcon.tictactoe.tictactoe.TicTacToeGameRunner game = new TicTacToeGameRunner(agent, scanner, System.out);

    game.run();
  }

}
