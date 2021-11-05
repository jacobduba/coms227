package hw3;
import java.util.ArrayList;

import api.Direction;
import api.SnakeLayoutException;
import api.SnakePiece;

/**
 * A Snake is a sequence of (row, column) pairs in which each 
 * (row, column) in the sequence represents a 2d position that is
 * horizontally or vertically adjacent to the previous one.
 * Each (row, column) is represented by an instance of the
 * class SnakePiece.  The first piece in the sequence
 * is called the "head", and the last one is called the
 * "tail".  In addition to the list of SnakePiece objects,
 * a Snake has an id consisting of a single character.
 * <p>
 * A snake may or may not be <em>valid</em>.  More precisely,
 * a snake is defined to be valid if:
 * <ul>
 *   <li>It has at least two pieces
 *   <li>There are no null elements in its pieces list
 *   <li>There are no duplicates in its pieces list
 *   <li>Each piece in the list has a row and column
 *   position that is horizontally or vertically adjacent
 *   to the previous piece in the list
 * </ul>
 * The methods to add pieces to a snake do 
 * NOT do any error-checking.  Instead, clients can use the method 
 * isValid to check whether the snake is valid.
 * @author Jacob Duba
 */
public class Snake
{
  // Instance variable containing the snake's ID
  private char id;
  // Instance variable containing the snake's pieces
  private ArrayList<SnakePiece> pieces;

  /**
   * Constructs a Snake with an empty list of SnakePiece objects
   * and with the given character as its ID.
   * @param givenId
   *   ID to use for this Snake
   */
  public Snake(char givenId)
  {
    id = givenId;
    pieces = new ArrayList<SnakePiece>();
  }
  
  /**
   * Adds a new SnakePiece to the end of  this Snake's list of pieces.  This 
   * method does no error-checking to ensure the given position is actually 
   * adjacent to the current tail.
   * @param row
   *   row for the new SnakePiece
   * @param col
   *   column for the new SnakePiece
   */
  public void addPiece(int row, int col)
  {
    pieces.add(new SnakePiece(row, col));
  }
  
  /**
   * Sets this Snake's list of pieces at the given index to be a new
   * SnakePiece with the given row and column.  If the current list 
   * of pieces is shorter than the given index, it is padded with
   * nulls so the given index can be set. This method does no 
   * error-checking to ensure the given (row, column) is actually 
   * adjacent to its neighbors in the list of pieces.
   * @param index
   *   index in the list of pieces where the new SnakePiece will be set
   * @param row
   *   row for the new SnakePiece
   * @param col
   *   column for the new SnakePiece
   */
  public void addPiece(int index, int row, int col)
  {
    for (int i = pieces.size(); i <= index; i++) {
      pieces.add(i, null);
    }

    pieces.set(index, new SnakePiece(row, col));
  }
  
  /**
   * Returns the ID for this Snake.
   * @return
   *   ID for this Snake
   */
  public char getId()
  {
    return id;
  }
  
  /**
   * Returns true if the ID is one of the characters 'g' or 'G'.
   * @return
   *   true if ID is 'g' or 'G'
   */
  public boolean isGreen()
  {
    return id == 'g' || id == 'G';
  }
  
  /**
   * Returns the first piece in this Snake's list of pieces,
   * or null if this snake has no pieces.
   * @return
   *   first piece
   */
  public SnakePiece getHead()
  {
    if (pieces.size() == 0) {
      return null;
    }

    return pieces.get(0);
  }
  
  /**
   * Returns the last piece in this Snake's list of pieces, or 
   * null if this snake has no pieces.
   * @return
   *   last piece
   */
  public SnakePiece getTail()
  {
    if (pieces.size() == 0) {
      return null;
    }

    return pieces.get(pieces.size() - 1);
  }
  
  /**
   * Returns true if given row and column match the row and column 
   * of this Snake's first piece.
   * Returns false if this snake has no pieces.
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   true if the head of this Snake has the same row and column
   */
  public boolean isHead(int row, int col)
  {
    if (pieces.size() == 0) {
      return false;
    }

    SnakePiece head = pieces.get(0);
    return head.row() == row && head.col() == col;
  }
  
  /**
   * Returns true if given row and column match the row and column 
   * of this Snake's last piece.  Returns false if this snake has no pieces.
   * 
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   true if the tail of this Snake has the same row and column
   */
  public boolean isTail(int row, int col)
  {
    if (pieces.size() == 0) {
      return false;
    }

    SnakePiece tail = pieces.get(pieces.size() - 1);
    return tail.row() == row || tail.col() == col;
  }
   
  /**
   * Returns this Snake's list of pieces. Normally this
   * method is used to render or display the game; clients
   * should not directly modify the snakes through this method.
   * @return
   *   list of SnakePiece objects for this Snake
   */
  public ArrayList<SnakePiece> getPieces()
  {
    return pieces;
  }
  
  /**
   * Moves the head of this Snake in the given direction without
   * changing its length. Does nothing if the snake has fewer than
   * two pieces.
   * @param dir
   *   which direction
   */
  public void moveHead(Direction dir)
  {
    if (pieces.size() > 1) {
      SnakePiece newHead = move(getHead(), dir);
      pieces.add(0, newHead);
      pieces.remove(pieces.size() - 1);
    }
  }
  
  /**
   * Moves the tail of this Snake in the given direction without
   * changing its length. Does nothing if the snake has fewer than
   * two pieces.
   * @param dir
   *   which direction
   */
  public void moveTail(Direction dir)
  {
    if (pieces.size() > 1) {
      SnakePiece newTail = move(getTail(), dir);
      pieces.add(newTail);
      pieces.remove(0);
    }
  }

  /**
   * Moves the head of this Snake in the given direction, increasing
   * its length by 1. Does nothing if the snake has fewer than
   * two pieces.
   * @param dir
   *   which direction
   */
  public void moveHeadAndGrow(Direction dir)
  {
    if (pieces.size() > 1) {
      SnakePiece newHead = move(getHead(), dir);
      pieces.add(0, newHead);
    }
  }
  
  /**
   * Moves the head of this Snake in the given direction, decreasing
   * its length by 1.  Does nothing if this Snake fewer than three pieces.
   * @param dir
   *   which direction
   */
  public void moveHeadAndShrink(Direction dir)
  {
    if (pieces.size() > 2) {
      SnakePiece newHead = move(getHead(), dir);
      pieces.add(0, newHead);
      pieces.remove(pieces.size() - 1);
      pieces.remove(pieces.size() - 1);
    }
  }

  private SnakePiece move(SnakePiece piece, Direction dir) {
    if (dir == Direction.DOWN) {
      return new SnakePiece(piece.row() + 1, piece.col());
    } else if (dir == Direction.UP) {
      return new SnakePiece(piece.row() - 1, piece.col());
    } else if (dir == Direction.LEFT) {
      return new SnakePiece(piece.row(), piece.col() - 1);
    } else { // Direction.RIGHT
      return new SnakePiece(piece.row(), piece.col() + 1);
    }
  }
  
  /**
   * Determines whether this snake is valid.  A snake is
   * <em>valid</em> if 
   * <ul>
   *   <li>It has at least two pieces
   *   <li>There are no null elements in its pieces list
   *   <li>There are no duplicates in its pieces list
   *   <li>Each piece in the list has a row and column
   *   position that is horizontally or vertically adjacent
   *   to the previous piece in the list
   * </ul>
   * @return
   *   true if this snake is valid, false otherwise
   */
  public boolean isValid()
  {
    // It has at least two pieces, and no null elements in listj
    if (pieces.size() < 2 || pieces.contains(null)) {
      return false;
    }

    // No duplicates
    for (int x = 0; x < pieces.size() - 1; x++) {
      for (int y = x + 1; y < pieces.size(); y++) {
        if (pieces.get(x).equals(pieces.get(y))) {
          return false;
        }
      }
    }

    // Each piece in the list has a row and column position that is horizontally or vertically adjacent to the previous
    // piece in this list.
    for (int x = 1; x < pieces.size(); x++) {
      SnakePiece behind = pieces.get(x);
      SnakePiece ahead = pieces.get(x - 1);
      if (!(Math.abs(behind.row() - ahead.row()) == 1 && behind.col() == ahead.col()) && !(behind.row() == ahead.row() && Math.abs(behind.col() - ahead.col()) == 1)) {
        return true;
      }
    }

    return true;
  }
}
