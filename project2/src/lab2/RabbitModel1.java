package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 */
public class RabbitModel1
{
    private int rabbits;

    /**
     * Constructs a new RabbitModel.
     */
    public RabbitModel1()
    {
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
        rabbits++;
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
