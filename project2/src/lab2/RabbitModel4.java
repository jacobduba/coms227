package lab2;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 */
public class RabbitModel4
{
    private int rabbits;
    Random rand;

    /**
     * Constructs a new RabbitModel.
     */
    public RabbitModel4()
    {
        rand = new Random();
        rabbits = 2;
    }

    /**
     * Returns the current number of rabbits.
     * @return
     *   current rabbit population
     */
    public int getPopulation()
    {
        return rabbits;
    }

    /**
     * Updates the population to simulate the
     * passing of one year.
     */
    public void simulateYear()
    {
        rabbits += rand.nextInt(10);
    }

    /**
     * Sets or resets the state of the model to the
     * initial conditions.
     */
    public void reset()
    {
        rabbits = 2;
    }
}
