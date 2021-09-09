package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 */
public class RabbitModel2
{
    private int rabbits;

    /**
     * Constructs a new RabbitModel.
     */
    public RabbitModel2()
    {
        rabbits = 0;
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
        rabbits = (rabbits + 1) % 5;
    }

    /**
     * Sets or resets the state of the model to the
     * initial conditions.
     */
    public void reset()
    {
        rabbits = 0;
    }
}
