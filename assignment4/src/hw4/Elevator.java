package hw4;

import api.GameElement;

import java.util.ArrayList;

/**
 * An Elevator is a GameElement with two distinctive behaviors.  First,
 * it can be set up to move vertically within a fixed set of boundaries.
 * On reaching a boundary, the y-component of its velocity is reversed.
 * Second, it maintains a list of <em>child</em> elements whose basic
 * motion all occurs relative to the Elevator.
 * 
 * @author Jacob Duba
 */
public class Elevator extends MovingElement
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
   * Constructs a new Elevator.  Initially the upper and lower
   * boundaries are <code>Double.NEGATIVE_INFINITY</code> and
   * <code>Double.POSITIVE_INFINITY</code>, respectively.
   * @param x
   *   x-coordinate of initial position of upper left corner
   * @param y
   *   y-coordinate of initial position of upper left corner
   * @param width
   *   element's width
   * @param height
   *   element's height
   */
  public Elevator(double x, double y, int width, int height)
  {
    super(x, y, width, height);
    min = Double.NEGATIVE_INFINITY;
    max = Double.POSITIVE_INFINITY;
    children = new ArrayList<GameElement>();
  }

  public void addChild(Charm charm) {
    children.add(charm);
    charm.setParent(this);
  }

  public void addChild(Lurker lurker) {
    children.add(lurker);
    lurker.setParent(this);
  }

  public ArrayList<GameElement> getChildren() {
    return children;
  }

  public double getMax() {
    return max;
  }

  public double getMin() {
    return min;
  }

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
    if (getYReal() <= min ) {
      setVelocity(getDeltaX(), -1 * getDeltaY());
      setPosition(getXReal(), min);
      // But wait! If it went above the bound, reverse the velocity and set it's xPos to be the bound minus its width.
    } else if (getYReal() + getHeight() >= max) {
      setVelocity(getDeltaX(), -1 * getDeltaY());
      setPosition(getXReal(), max - getHeight());
    }

    for (GameElement e : children) {
      // Move children along with platform
      e.setPosition(e.getXReal(), getYReal() - e.getHeight());
      e.update();
    }
  }
}
