
package hw4;

import api.GameElement;

/**
 * Moving element associated with a Platform or Elevator.  Optionally,
 * a Lurker can be given a nonzero horizontal velocity and it will oscillate
 * between the left and right edges of the Platform or Elevator.
 * 
 * @author Jacob Duba
 */
public class Lurker extends Platform
{
  /**
   * when a parent is set, this amount is added to the parent's x-coordinate to calculate this element's initial
   * x-coordinate
   */
  private int offset;
  /**
   * the parent for this element
   */
  private GameElement parent;

  /**
   * Constructs a new Lurker.  Before being added to a parent element
   * such as a Platform or Elevator, the x and y coordinates are zero.  
   * When a parent element is set, the initial x-coordinate becomes
   * the parent's x-coordinate, plus the given offset, and the y-coordinate
   * becomes the parent's y-coordinate, minus this element's height.
   * @param width
   *   element's width
   * @param height
   *   element's height
   * @param initialOffset
   *   when a parent is set, this amount is added to the parent's x-coordinate
   *   to calculate this element's initial x-coordinate
   */
  public Lurker(int width, int height, int initialOffset) {
    super(0, 0, width, height);
    offset = initialOffset;
  }

  public void setParent(GameElement p) {
    parent = p;
    setPosition(parent.getXReal() + offset, parent.getYReal() - getHeight());
    setBounds(parent.getXReal(), parent.getXReal() + parent.getWidth());
  }

  /**
   *  Updates this element's position to move horizontally according to its velocity (possibly zero) relative to the
   *  parent object, and remain "resting" on the parent object (provided that a parent has been set).
   */
  @Override
  public void update() {
    setBounds(parent.getXReal(), parent.getXReal() + parent.getWidth());
    super.update();
  }
}
