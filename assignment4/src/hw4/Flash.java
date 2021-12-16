
package hw4;

/**
 * Implementation of GameElement that does not move. Instead, it is intended to
 * appear on the screen for a fixed number of frames.
 * 
 * @author Jacob Duba
 */
public class Flash extends BasicElement
{
  /**
   * number of remaining frames
   */
  private int remainingLife;

  /**
   * Constructs a new Flash.
   * 
   * @param x
   *          x-coordinate of upper left corner
   * @param y
   *          y-coordinate of upper left corner
   * @param width
   *          element's width
   * @param height
   *          element's height
   * @param initialLife
   *          the number of frames until this element marks itself for deletion
   */
  public Flash(double x, double y, int width, int height, int initialLife)
  {
    super(x, y, width, height);
    remainingLife = initialLife;
  }

  /**
   * Returns the number of frames remaining until this element marks itself for deletion
   * @return number of remaining frames
   */
  public int getRemainingLife() {
    return remainingLife;
  }

  /**
   * Decrements the remaining life of this Flash. If it reaches zero, this element marks itself for deletion.
   */
  @Override
  public void update() {
    super.update();
    remainingLife--;
  }
}
