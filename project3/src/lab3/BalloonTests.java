package lab3;

import balloon.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BalloonTests {

    private static final double EPSILON = 10e-07;

    private balloon.Balloon b;

    @Before
    public void setup() {
        b = new balloon.Balloon(10);
    }

    @Test
    public void testInitial() {
        String msg = "A newly constructed Balloon should have radius zero.";
        assertEquals(msg, 0, b.getRadius());
    }

    @Test
    public void testPopped() {
        String msg = "A newly constructed Balloon should not be popped.";
        assertEquals(msg, false, b.isPopped());
    }

    @Test
    public void testBlow1() {
        String msg = "After calling blow(5) on a Balloon with maximum radius 10, the radius should be 5.";
        b.blow(5);
        assertEquals(msg, 5, b.getRadius());
    }

    @Test
    public void testBlow2() {
        String msg = "After calling blow(5) on a popped Balloon with a maximum radius 10, the radius should be 0.";
        b.pop();
        b.blow(5);
        assertEquals(msg, 0, b.getRadius());
    }

    @Test
    public void testBlow3() {
        String msg = "After calling blow(10) on a Balloon with a maximum radius 10, the radius should be 10.";
        b.blow(10);
        assertEquals(msg, 10, b.getRadius());
    }

    @Test
    public void testBlow4() {
        String msg = "After calling blow(11) on a Balloon with a maximum radius 10, the radius should be 0.";
        b.blow(11);
        assertEquals(msg, 0, b.getRadius());
    }

    @Test
    public void testBlow5() {
        String msg = "After calling blow(11) on a Balloon with a maximum radius 10, isPopped() should return true.";
        b.blow(11);
        assertEquals(msg, true, b.isPopped());
    }

    @Test
    public void testBlow6() {
        String msg = "After calling blow(5) on a Balloon with a maximum radius 10, isPopped() should return false.";
        b.blow(5);
        assertEquals(msg, false, b.isPopped());
    }

    @Test
    public void testBlow7() {
        String msg = "After calling blow(5) and blow(6) isPopped() should return true.";
        b.blow(5);
        b.blow(6);
        assertEquals(msg, true, b.isPopped());
    }

    @Test
    public void testPop1() {
        String msg = "After calling pop() on a Balloon, isPopped() should return true.";
        b.pop();
        assertEquals(msg, true, b.isPopped());
    }

    @Test
    public void testPop2() {
        String msg = "After calling pop() on a Balloon and blow(5), getRadius() should return a radius of 0.";
        b.pop();
        b.blow(5);
        assertEquals(msg, 0, b.getRadius());
    }

    @Test
    public void testPop3() {
        String msg = "After calling pop() on a Balloon and blow(5), is popped() should return true.";
        b.pop();
        b.blow(5);
        assertEquals(msg, true, b.isPopped());
    }

    @Test
    public void testDeflate1() {
        String msg = "Calling deflate() on a Balloon with blow(5) should return a radius of 0.";
        b.blow(5);
        b.deflate();
        assertEquals(msg, 0, b.getRadius());
    }

    @Test
    public void testDeflate2() {
        String msg = "Calling deflate() on a Balloon with blow(5) and calling blow(6) should return a radius of 0.";
        b.blow(5);
        b.deflate();
        b.blow(6);
        assertEquals(msg, 6, b.getRadius());
    }
}
