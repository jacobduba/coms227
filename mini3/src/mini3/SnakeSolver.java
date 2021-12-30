package mini3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import snakes.api.BasketCell;
import snakes.api.Direction;
import snakes.api.SnakePiece;
import snakes.hw3.Snake;
import snakes.hw3.SnakeBasket;

/**
 * Class that manages the state information during a recursive
 * search for solutions to the SnakeEscape game.
 */
public class SnakeSolver
{
  /**
   * Maximum number of moves allowed in the search.
   */
  private int maxMoves;
  
  /**
   * Associates a signature with the move count to reach 
   * that grid layout.
   */
  private Map<String, Integer> seen = new HashMap<String, Integer>();
  
  /**
   * All solutions found in this search.
   */
  private ArrayList<String> solutions = new ArrayList<>();
  
  /**
   * Constructs a solver with the given maximum number of moves.
   * @param givenMaxMoves
   *   maximum number of moves
   */
  public SnakeSolver(int givenMaxMoves)
  {
    maxMoves = givenMaxMoves;
  }
  
  /**
   * Returns all solutions found in the search.  Each solution 
   * is a single string in the form returned by SnakeBasket#getMoveList.
   * @return
   *   list of all solutions
   */
  public ArrayList<String> getSolutions()
  {
    return solutions;
  }
  
  /**
   * Recursively search for solutions to the given game instance
   * according to the algorithm described in the miniassignment 3
   * pdf.
   * @param game
   *   any instance of SnakeBasket
   */
  public void solve(SnakeBasket game)
  {
    if (game.getMoves() - 1 > maxMoves) {
      return;
    } else if (game.isOver()) {
      if (!solutions.contains(game.getMoveList())) {
        solutions.add(game.getMoveList());
      }
      return;
    } else if (seen.containsKey(game.getSignature())) {
      if (game.getMoves() >= seen.get(game.getSignature())) {
        return;
      } else {
        seen.put(game.getSignature(), game.getMoves());
      }
    } else {
      seen.put(game.getSignature(), game.getMoves());
    }

    for (Snake snake : game.getAllSnakes()) {
      String temp = game.getSignature();
      for (Direction dir : Direction.values()) {
        game.grabSnake(snake.getHead().row(), snake.getHead().col());
        game.move(dir);
        if (!temp.equals(game.getSignature())) {
         solve(game);
         game.undoMove();
        }
      }
      for (Direction dir: Direction.values()) {
        game.grabSnake(snake.getTail().row(), snake.getTail().col());
        game.move(dir);
        if (!temp.equals(game.getSignature())) {
          System.out.println(game.getSignature());
          solve(game);
          game.undoMove();
        }
      }
    }
  }
}
