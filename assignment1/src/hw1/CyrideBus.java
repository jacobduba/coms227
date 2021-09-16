package hw1;

/**
 * A class that models ridership of a city bus.
 * @author Jacob Duba
 */
public class CyrideBus {
    /**
     * Stop number for bus garage.
     */
    public static final int BUS_GARAGE = -1;

    private int currentStop;
    private int numStops;
    private boolean inService;
    private int maxCapacity;
    private int currentCapactiy;
    private int numPassengers;
    private int totalRiders;

    /**
     * Constructs a new bus with the given maximum capacity that will travel among the given number of stops. Initially
     * the bus is in service, the current stop is BUS_GARAGE, and there are no passengers on the bus.
     * @param givenMaxCapacity int of max bus capacity.
     * @param givenNumStops int of bus stops.
     */
    public CyrideBus(int givenMaxCapacity, int givenNumStops) {
        currentStop = BUS_GARAGE;
        numStops = givenNumStops;
        inService = true;
        maxCapacity = givenMaxCapacity;
        currentCapactiy = maxCapacity;
        numPassengers = 0;
    }

    /**
     * @return An int representing the current capacity of the bus. This is zero while the bus is out of service, and is
     * equal to the maximum capacity when in service.
     */
    public int getCurrentCapacity() {
        return currentCapactiy;
    }

    /**
     * @return An int representing the current stop number.
     */
    public int getCurrentStop() {
        return currentStop;
    }

    /**
     * @return An int representing the current capacity of the bus. This is zero while the bus is out of service, and is
     * equal to the maximum capacity when in service.
     */
    public int getNumPassengers() {
        return numPassengers;
    }

    /**
     * @return An int representing the total number of passengers who have gotten on this bus since it was constructed.
     */
    public int getTotalRiders() {
        return totalRiders;
    }

    /**
     * @return A boolean representing if this bus is in service, that is, its current capacity is nonzero.
     */
    public boolean isInService() {
        return inService;
    }

    /**
     * Simulates the bus travelling to its next stop. The stop number is incremented (possibly wrapping around to
     * zero); The actual number of passengers getting on is added to the ridership total.
     * @param peopleOff the given number of people getting off, if possible (never going below zero).
     * @param peopleOn the given number of people getting on, if possible (never going over the current capacity).
     */
    public void nextStop(int peopleOff, int peopleOn) {
        currentStop = (currentStop + 1) % numStops;
        numPassengers = Math.max(numPassengers - peopleOff, 0);
        int onboarding = Math.min(peopleOn, currentCapactiy - numPassengers);
        numPassengers += onboarding;
        totalRiders += onboarding;
    }

    /**
     * Places this bus in service; that is, sets the current capacity to the maximum value.
     */
    public void placeInService() {
        inService = true;
        currentCapactiy = maxCapacity;
    }

    /**
     * Takes this bus out of service. The current capacity becomes zero, all passengers get off, and the bus is
     * teleported to BUS_GARAGE.
     */
    public void removeFromService() {
        inService = false;
        currentStop = BUS_GARAGE;
        numPassengers = 0;
        currentCapactiy = 0;
    }
}
