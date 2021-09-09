package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 */
public class RabbitModel
{
    private int rabbits;
    private int pastYear;
    private int pastPastYear;

    /**
     * Constructs a new RabbitModel.
     */
    public RabbitModel()
    {
        rabbits = 1;
        pastYear = 1;
        pastPastYear = 0;
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
        System.out.println(rabbits + " = " + pastYear + " + " + pastPastYear);
        pastPastYear = pastYear;
        pastYear = rabbits;
        rabbits = pastYear + pastPastYear;
    }

    /**
     * Sets or resets the state of the model to the
     * initial conditions.
     */
    public void reset()
    {
        rabbits = 1;
        pastYear = 1;
        pastPastYear = 0;
    }
}
