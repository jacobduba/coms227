package hw4;

/**
 * Moving element in which the vertical velocity is adjusted
 * each frame by a gravitational constant to simulate gravity.
 * It may also be put into a "ballistic" state in which 
 * no other modifications to velocity take place other than gravity.
 * 
 * @author Jacob Duba
 */
public class Missile extends MovingElement
{
  /**
   * true if ballistic, false otherwise
   */
  private boolean ballistic;
  /**
   * gravitational constant to use
   */
  private double gravity;

  /**
   * Constructs a new Missile.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param width
   *   element's width
   * @param height
   *   element's height
   */
  public Missile(double x, double y, int width, int height)
  {
    super(x, y, width, height);
    ballistic = false;
    gravity = 0;
  }

  /**
   * Sets or unsets the ballistic state of this Missile.
   * @param ballistic true if ballistic, false otherwise
   */
  public void setBallistic(boolean ballistic) {
    this.ballistic = ballistic;
  }

  /**
   * Determines whether this Missile is in a ballistic state.
   * @return true if ballistic, false otherwise
   */
  public boolean isBallistic() {
    return ballistic;
  }

  /**
   * Sets the gravitational constant, assumed to be in units of "pixels per frame per frame". Remember that the positive direction is down.
   * @param gravity gravitational constant to use
   */
  public void setGravity(double gravity) {
    this.gravity = gravity;
  }

  /**
   * Updates position and adds the gravitational constant to the y-component of the velocity.
   */
  @Override
  public void update() {
    super.update();
    if (ballistic) {
      super.setVelocity(0, gravity);
    } else {
      super.setVelocity(super.getDeltaX(), super.getDeltaY() + gravity);
    }
  }
}
