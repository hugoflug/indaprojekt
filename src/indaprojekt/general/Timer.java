package indaprojekt.general;

/**
 * A class for measuring time
 * (rippad fr�n snilssons Stopwatch, vi kanske borde skriva om den senare..)
 */
public class Timer 
{
    /**
     * Time when start() was called. Contains a valid time
     * only if the clock is running.
     */
    private long startTime;

    /**
     * Holds the total accumulated time since last reset.
     * Does not include time since start() if clock is running.
     */
    private long totalTime = 0;

    private boolean isRunning = false;

    /**
     * Constructs a new Stopwatch. The new clock is not
     * running and the total time is set to 0.
     */
    public Timer() {}

    /**
     * Turns this clock on.
     * Has no effect if the clock is already running.
     *
     * @return a reference to this Stopwatch.
     */
    public Timer start() 
    {
        if (!isRunning) {
            isRunning = true;
            startTime = System.nanoTime();
        }
        return this;
    }

    /**
     * Turns this clock off.
     * Has no effect if the clock is not running.
     *
     * @return a reference to this Stopwatch.
     */
    public Timer stop() 
    {
        if (isRunning) {
            totalTime += System.nanoTime() - startTime;
            isRunning = false;
        }
        return this;
    }

    /**
     * Resets this clock.
     * The clock is stopped and the total time is set to 0.
     *
     * @return a reference to this Stopwatch.
     */
    public Timer reset() 
    {
        isRunning = false;
        totalTime = 0;
        return this;
    }

    /**
     * Returns the total time that this clock has been running since
     * last reset.
     * Does not affect the running status of the clock; if the clock
     * is running when this method is called, it continues to run.
     *
     * @return the time in milliseconds.
     */
    public long milliseconds() 
    {
        return nanoseconds() / 1000000;
    }

    /**
     * Returns the total time that this clock has been running since
     * last reset.
     * Does not affect the running status of the clock; if the clock
     * is running when this method is called, it continues to run.
     *
     * @return the time in nanoseconds.
     */
    public long nanoseconds() 
    {
        return totalTime +
            (isRunning ? System.nanoTime() - startTime : 0);
    }

    /**
     * Tests if this clock is running.
     *
     * @return <code>true</code> if this clock is running;
     *         <code>false</code> otherwise.
     */
    public boolean isRunning() 
    {
        return isRunning;
    }
}
