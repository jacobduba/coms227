package test;
import hw4.Elevator;

public class ElevatorTest
{
  public static void main(String[] args)
  {
      // left side at x = 50, width 10, right side at 60
      Elevator p = new Elevator(200, 50, 10, 10);
      p.setBounds(40, 70);
      p.setVelocity(0, 6);
      p.update();
      System.out.println(p.getYReal() + ", " + (p.getYReal() + 10));  // [56, 66]
      System.out.println("Velocity " + p.getDeltaY()); // 6.0
      p.update();
      System.out.println(p.getYReal() + ", " + (p.getYReal() + 10));  // [60, 70]
      System.out.println("Velocity " + p.getDeltaY()); // -6.0
      p.update();
      System.out.println(p.getYReal() + ", " + (p.getYReal() + 10));  // [54, 64]
      System.out.println("Velocity " + p.getDeltaY()); // -6.0
      p.update();
      System.out.println(p.getYReal() + ", " + (p.getYReal() + 10));  // [48, 58]
      System.out.println("Velocity " + p.getDeltaY()); // -6.0
      p.update();
      System.out.println(p.getYReal() + ", " + (p.getYReal() + 10));  // [42, 52]
      System.out.println("Velocity " + p.getDeltaY()); // -6.0
      p.update();
      System.out.println(p.getYReal() + ", " + (p.getYReal() + 10));  // [40, 50]
      System.out.println("Velocity " + p.getDeltaY()); // 6.0
     
  }
}
