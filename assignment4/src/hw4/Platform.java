package hw4;

import api.GameElement;

import java.util.ArrayList;

/**
 * A Platform is a GameElement with two distinctive behaviors.  First,
 * it can be set up to move horizontally within a fixed set of boundaries.
 * On reaching a boundary, the x-component of its velocity is reversed.
 * Second, it maintains a list of <em>child</em> elements whose basic
 * motion all occurs relative to the Platform.
 * 
 * @author Jacob Duba
 */
public class Platform extends MovingElement
{
  /**
   * left boundary
   */
  private double min;
  /**
   * right boundary
   */
  private double max;
  /**
   * list of children
   */
  private ArrayList<GameElement> children;

  /**
   * Constructs a new Platform. Initially the left and right
   * boundaries are <code>Double.NEGATIVE_INFINITY</code> and
   * <code>Double.POSITIVE_INFINITY</code>, respectively.
   * @param x
   *   x-coordinate of initial position of upper left corner
   * @param y
   *   y-coordinate of initial position of upper left corner
   * @param width
   *   object's width
   * @param height
   *   object's height
   */
  public Platform(double x, double y, int width, int height)
  {
    super(x, y, width, height);
    min = Double.NEGATIVE_INFINITY;
    max = Double.POSITIVE_INFINITY;
    children = new ArrayList<GameElement>();
  }

  /**
   * Adds a child object to this Platform, and sets this object to be the child's parent.
   * @param charm a Charm object to become a child of this platform
   */
  public void addChild(Charm charm) {
    children.add(charm);
    charm.setParent(this);
  }

  /**
   * Adds a child object to this Platform, and sets this object to be the child's parent.
   * @param lurker a Lurker object to become a child of this platform
   */
  public void addChild(Lurker lurker) {
    children.add(lurker);
    lurker.setParent(this);
  }

  /**
   * Returns a list of all this Platform's children.
   * @return list of children
   */
  public ArrayList<GameElement> getChildren() {
    return children;
  }

  /**
   * Returns the right boundary for this Platform's movement.
   * @return right boundary
   */
  public double getMax() {
    return max;
  }

  /**
   * Returns the left boundary for this Platform's movement.
   * @return left boundary
   */
  public double getMin() {
    return min;
  }

  /**
   * Sets the left and right boundaries for this Platform's movement
   * @param min left boundary
   * @param max right boundary
   */
  public void setBounds(double min, double max) {
    this.min = min;
    this.max = max;
  }

  public void deleteMarkedChildren() {
    ArrayList<GameElement> temp = new ArrayList<GameElement>();
    for (int i = 0; i < children.size(); i++) {
      if (!children.get(i).isMarked()) {
        temp.add(children.get(i));
      }
    }
    children = temp;
  }

  @Override
  public void update() {
    // Update frame count and moves this movable object
    super.update();
    // But wait! If it went below the bound, reverse the velocity and set it's xPos to be the bound.
    if (getXReal() <= min ) {
      setVelocity(-1 * getDeltaX(), getDeltaY());
      setPosition(min, getYReal());
      // But wait! If it went above the bound, reverse the velocity and set it's xPos to be the bound minus its width.
    } else if (getXReal() + getWidth() >= max) {
      setVelocity(-1 * getDeltaX(), getDeltaY());
      setPosition(max - getWidth(), getYReal());
    }

    for (GameElement e : children) {
      // Move children along with platform
      e.setPosition(e.getXReal() + getDeltaX(), e.getYReal());
      e.update();
    }
  }
}
