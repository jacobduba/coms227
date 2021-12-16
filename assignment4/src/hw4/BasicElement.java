package hw4;

import api.GameElement;

import java.awt.*;

/**
 * Minimal concrete extension of GameElement. The <code>update</code>
 * method in this implementation just increments the frame count.
 * 
 * @author Jacob Duba
 */
public class BasicElement extends GameElement
{
  /**
   * Double representing the element's upper left x-coordinate.
   */
  private double xPos;
  /**
   * Double representing the element's upper left y-coordinate.
   */
  private double yPos;
  /**
   * Integer representing the element's width.
   */
  private int width;
  /**
   * Integer representing the element's height.
   */
  private int height;
  /**
   * Integer representing how many times update has been invoked for this object.
   */
  private int frameCount;
  /**
   * Boolean representing if this element has been marked for deletion.
   */
  private boolean isMarked;

  /**
   * Constructs a new BasicElement.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param w
   *   element's width
   * @param h
   *   element's height
   */
  public BasicElement(double x, double y, int w, int h)
  {
    super();
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    frameCount = 0;
    isMarked = false;
  }

  @Override
  public void setPosition(double newX, double newY) {
    xPos = newX;
    yPos = newY;
  }

  @Override
  public int getXInt() {
    return (int) Math.round(xPos);
  }

  @Override
  public double getXReal() {
    return xPos;
  }

  @Override
  public int getYInt() {
    return (int) Math.round(yPos);
  }

  @Override
  public double getYReal() {
    return yPos;
  }

  @Override
  public int getWidth()  {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Rectangle getRect() {
    return new Rectangle(getXInt(), getYInt(), getWidth(), getHeight());
  }

  @Override
  public void update() {
    frameCount++;
  }

  @Override
  public int getFrameCount() {
    return frameCount;
  }

  @Override
  public boolean isMarked() {
    return isMarked;
  }

  @Override
  public void markForDeletion() {
    isMarked = true;
  }

  @Override
  public boolean collides(GameElement other) {
    return getRect().intersects(other.getRect());
  }
}
