package hw3;
import java.util.ArrayList;
//import static Status;

import api.BasketCell;
import api.Direction;
import api.SnakeLayoutException;
import api.SnakePiece;
import api.GridUtil;

import javax.swing.plaf.basic.BasicHTML;

/**
 * This class represents the basic game state for a "Snake Escape" 
 * game, including a 2d grid of cells and a list of snakes.
 * @author Jacob Duba
 */
public class SnakeBasket
{
  /**
   * The 2D array of cells.
   */
  private BasketCell[][] grid; 
  
  /**
   * The list of snakes.
   */
  private ArrayList<Snake> snakes;
  /**
   * Current snake was grabbed by head?
   */
  private boolean currentWasGrabbedByHead;

  /**
   * Boolean that is true if the game is over.
   */
  private boolean isOver;

  /**
   * Current Snakes.
   */
  private Snake currentSnake;

  /**
   * Integer representing how many moves it is taking to win the game.
   */
  private int moves;
  
  /**
   * Constructs an instance of this game from the given string
   * array and list of snakes.  <em>Snake information, if any,
   * in the given string array is ignored</em>.
   * @param desc
   *    array of strings representing the initial grid layout
   * @param givenSnakes
   *    array of snakes
   */
  public SnakeBasket(String[] desc, ArrayList<Snake> givenSnakes)
  {
    grid = GridUtil.createGridFromDescriptor(desc);
    snakes = givenSnakes;
    resetAllSnakes();
    
    // TODO:
    //   implement resetAllSnakes
    //   any other initialization you need
  }
  
  /**
   * Constructs an instance of this game from the given string
   * array.
   * @param desc
   *    array of strings representing the initial grid layout,
   *    including ids and placement of snakes
   */
  public SnakeBasket(String[] desc)
  {
    grid = GridUtil.createGridFromDescriptor(desc);
    snakes = SnakeUtil.findSnakes(desc);
    resetAllSnakes();
    isOver = false;
    moves = 0;
    
    // TODO:
    //   implement SnakeUtil.findSnakes
    //   implement resetAllSnakes
    //   any other initialization you need
  }
  
  /**
   * Returns the grid cell at the given row and column.
   * @param row
   *    given row
   * @param col
   *    given column
   * @return
   *    grid cell at the given row and column
   */
  public BasketCell getCell(int row, int col)
  {
    return grid[row][col];
  }
  
  /**
   * Returns the number of rows in this game.
   * @return
   *   number of rows
   */
  public int getRows()
  {
    return grid.length;
  }
  
  /**
   * Returns the number of columns in this game.
   * @return
   *   number of columns
   */
  public int getCols()
  {
    return grid[0].length;
  } 
  
  /**
   * Returns the currently grabbed snake, if any.  Returns
   * null if there is no current snake.
   * @return
   *   current snake, if any
   */
  public Snake currentSnake()
  {
    return currentSnake;
  }
  
  /**
   * Returns true if there is a current snake and it was 
   * grabbed at the head end, false if it was grabbed by
   * the tail.
   * @return
   *   true if current snake was grabbed by the head
   */
  public boolean currentWasGrabbedByHead()
  {
    return currentWasGrabbedByHead;
  }
  
  /**
   * Returns this SnakeBasket's list of all snakes. Normally this
   * method is used to easily render or display the game;
   * clients should not modify the list or the snakes.
   * @return
   *   list of all snakes
   */
  public ArrayList<Snake> getAllSnakes()
  {
    return snakes;
  }
  
  /**
   * Returns true if the green snake is in the 
   * exit cell, false otherwise.
   * @return
   *   true if green snake is in the exit
   */
  public boolean isOver()
  {
    return isOver;
  }
  
  /**
   * Returns the total number of moves that have been made so far
   * in this game.
   * @return
   *   number of moves
   */
  public int getMoves()
  {
    return moves;
  }
  
  
  /**
   * Attempts to grab a snake by the head or tail at the given position.
   * If there is not already a current snake, and if the given position 
   * contains a snake head or tail, that becomes the current snake. 
   * If this game already has a current snake selected, this method
   * does nothing. 
   * @param row
   *   given row at which to grab a snake
   * @param col
   *   given column at which to grab a snake
   */
  public void grabSnake(int row, int col)
  {
    Snake snek = grid[row][col].getSnake();
    if (snek != null && currentSnake == null) {
      if (snek.getHead().row() == row && snek.getHead().col() == col) {
        currentSnake = snek;
        currentWasGrabbedByHead = true;
      } else if (snek.getTail().row() == row && snek.getTail().col() == col) {
        currentSnake = snek;
        currentWasGrabbedByHead = false;
      }
    }
  }
  
  /**
   * Sets the current snake to null, if any.
   */
  public void releaseSnake()
  {
    currentSnake = null;
  }
  
  /**
   * Attempt to move the current snake (head or tail) to an adjacent
   * cell in the given direction.  If a move is possible, this method
   * updates the current snake, the move count, and the grid cells
   * (via resetAllSnakes).
   * <p>
   * It is only possible to move in the following cases:
   * <ul>
   *   <li>The adjacent cell is empty; then the snake (head or tail) moves 
   *       into the cell
   *   <li>The adjacent cell is the exit and the current snake is the green one;
   *       then the snake (head or tail) moves into the exit and the game ends
   *   <li>The current snake was grabbed by the head, and the adjacent cell
   *       is row/column of the current snake's tail; then the snake (head) moves
   *       into the cell
   *   <li>The current snake was grabbed by the tail, and the adjacent cell
   *       is row/column of the current snake's head; then the snake (tail)
   *       moves into the cell
   *   <li>The current snake was grabbed by the head and the adjacent cell
   *   is an apple; then the apple is removed and the snake (head) moves 
   *   into the cell, increasing its size by one piece
   *   <li>The current snake was grabbed by the head, has at least three pieces,
   *    and the adjacent cell is a mushroom; then the mushroom is removed and
   *    the snake (head) moves into the cell, reducing its size by one piece
   * </ul>
   * If none of the above conditions is met, this method does nothing.
   * If any of the conditions is met and a move occurs, the move count
   * is increased by 1.
   * If there is no currently grabbed snake, this method does nothing.
   * @param dir
   *   Direction in which to attempt to move
   */
  public void move(Direction dir)
  {
    if (currentSnake != null) {
      SnakePiece piece;
      // Should the piece we use be the head or tail?
      if (currentWasGrabbedByHead) {
        piece = currentSnake.getHead();
      } else {
        piece = currentSnake.getTail();
      }

      // Save the incoming cell's location, and get it.
      BasketCell cell;
      int row;
      int col;
      if (dir == Direction.DOWN) {
        row = piece.row() + 1;
        col = piece.col();
      } else if (dir == Direction.UP) {
        row = piece.row() - 1;
        col = piece.col();
      } else if (dir == Direction.LEFT) {
        row = piece.row();
        col = piece.col() - 1;
      } else { // Direction.RIGHT
        row = piece.row();
        col = piece.col() + 1;
      }
      cell = grid[row][col];

      // Based on the cell that the player wants to move into, handle logic. Add moves++ if it's successful.:w
      if (currentWasGrabbedByHead) {
        if (cell.isEmpty()) {
          currentSnake.moveHead(dir);
          moves++;
        } else if (cell.isExit()) {
          isOver = true;
          moves++;
        } else if (cell.hasSnake() && currentSnake.getTail().row() == row && currentSnake.getTail().col() == col) {
          currentSnake.moveHead(dir);
          moves++;
        } else if (cell.isApple()) {
          cell.clearFood();
          currentSnake.moveHeadAndGrow(dir);
          moves++;
        } else if (cell.isMushroom()) {
          cell.clearFood();
          currentSnake.moveHeadAndShrink(dir);
          moves++;
        }
      } else { // currentWasGrabbedByTail
        if (cell.isEmpty()) {
          currentSnake.moveTail(dir);
          moves++;
        } else if (cell.isExit()) {
          currentSnake.moveTail(dir);
          moves++;
        } else if (cell.hasSnake() && currentSnake.getHead().row() == row && currentSnake.getHead().col() == col) {
          currentSnake.moveTail(dir);
          moves++;
        }
      }

      resetAllSnakes();
    }
  }
  
  /**
   * Clears all snake information from the grid, if any, and then
   * sets it from the current list of snakes.  After executing 
   * this method, the information in the grid cells and the
   * information in the snake list should be fully consistent.
   */
  public void resetAllSnakes()
  {
    // Clears all snake information from grid.
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        grid[row][col].clearSnake();
      }
    }

    // Puts all new snake information on grid
    for (Snake snek : snakes) {
      for (SnakePiece piece : snek.getPieces()) {
        grid[piece.row()][piece.col()].setSnake(snek);
      }
    }
  }

}
