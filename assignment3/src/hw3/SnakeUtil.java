package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import api.GridUtil;
import api.SnakeLayoutException;

/**
 * Utility methods for working with Snakes.
 * @author Jacob Duba
 */
public class SnakeUtil
{
  /**
   * Private constructor disables instantiation.
   */
  private SnakeUtil() {}
  
  /**
   * Given a descriptor array, return a list of all the snakes
   * it contains. Snake pieces are represented in the descriptor
   * array by id strings consisting of a single character followed
   * by a number. All other text elements in the descriptor are single 
   * characters only and are ignored by this method.  
   * The first character of the id string
   * becomes the "id" for the Snake. The number following
   * the id becomes the actual list index for the corresponding piece
   * of the snake.  For example, if row 3 and column 5 of the 
   * descriptor is the string "g7", then the snake with id 'g' should
   * have, at index 7 of its pieces list, a SnakePiece with row 3, column 5 .
   * <p>
   * This method first calls GridUtil.validateDescriptor, which may
   * throw a SnakeLayoutException.  In addition, after constructing
   * the list of snakes, this method checks isValid() on each
   * snake and throws SnakeLayoutException if any snake is found
   * to be invalid.
   * <p>
   * The order of snakes within the returned list is unspecified.
   * @param desc
   *   descriptor array
   * @return
   *   list of snakes in the descriptor
   * @throws SnakeLayoutException
   *   if the descriptor fails to pass GridUtil.validateDescriptor
   *   or if any of the resulting snakes is invalid
   */
  public static ArrayList<Snake> findSnakes(String[] desc)
  {
    ArrayList<Snake> sneks = new ArrayList<Snake>();
    ArrayList<Character> ids = new ArrayList<Character>();

    Scanner scan;
    // Loop through every section of the desc array.
    for (int row = 0; row < desc.length; row++) {
      scan = new Scanner(desc[row]);
      int col = 0;
      // Scan through each line/
      while (scan.hasNext()) {
        String cell = scan.next();
        // If the cell is longer than 1 character it is a snake. Take the first character: that's the ID.
        // The rest is the snake's index.
        if (cell.length() > 1) {
          char id = cell.charAt(0);
          int index = Integer.valueOf(cell.substring(1, cell.length()));
          if (ids.contains(id)) { // If we already have this snake on file...
            // Append the to the snake (using the ID) add the current row and col to the index we got from the scanner.
            sneks.get(ids.indexOf(id)).addPiece(index, row, col);
          } else { // Else file this snake and create a new snake with the piece we discovered.
            ids.add(id);
            Snake snek = new Snake(id);
            snek.addPiece(index, row,col);
            sneks.add(snek);
          }
        }
        col++;
      }
    }
    return sneks;
  }

  
  /**
   * Reads a the given file and creates a string array from
   * each block of text separated by whitespace. The string
   * arrays are returned in an ArrayList.  Despite the name
   * of this method, it does NO checking for whether
   * a given block of text actually represents a descriptor
   * for the game.  The file is assumed to end with a blank line.
   * @param filename
   *   name of the file to read
   * @return
   *   ArrayList of string arrays, one for each block of text
   * @throws FileNotFoundException
   *   if the named file cannot be opened
   */
  public static ArrayList<String[]> createDescriptorsFromFile(String filename) throws FileNotFoundException
  {
    ArrayList<String[]> levels = new ArrayList<String[]>();

    File file = new File(filename);
    Scanner scanner = new Scanner(file);
    ArrayList<String> level = new ArrayList<String>();
    // Scan through each line
    while (scanner.hasNextLine()) {
      String nextLine = scanner.nextLine();
      if (nextLine.equals("")) {
        // If line is blank and temporary level arraylist isn't empty, turn tempory level arraylist into array and
        // append to levels.
        if (level.size() != 0) {
          String[] temp = new String[level.size()];
          for (int i = 0; i < temp.length; i++) {
            temp[i] = level.get(i);
          }
          levels.add(temp);
          level = new ArrayList<String>();
        }
      } else { // If line is not blank append to temporary level array.
        level.add(nextLine);
      }
    }
    return levels;
  }
}
