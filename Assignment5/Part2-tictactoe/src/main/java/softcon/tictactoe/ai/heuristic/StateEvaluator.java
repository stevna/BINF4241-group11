package softcon.tictactoe.ai.heuristic;

import softcon.tictactoe.DiscreteGameState;

/**
 * An evaluator that examines a {@link DiscreteGameState} and calculates a simple heuristic score.
 * 
 * @param <T> the type of game state that this evaluator examines
 */
public interface StateEvaluator<T extends DiscreteGameState> {

  /**
   * Computes the heuristic score for a given game state.
   * 
   * @param state the {@link DiscreteGameState} to evaluate
   * @return an integer score
   */
  int evaluate(T state);
}
