// ID: 314978412
package gamesetting;

/**
 * The type Counter.
 */
public class Counter {
    private int counter;

    /**
     * Instantiates a new Counter.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * Add number to current count.
     *
     * @param number the number
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * Subtract number from current count.
     *
     * @param number the number
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * Gets current count value.
     *
     * @return the value of the countS
     */
    public int getValue() {
        return this.counter;
    }
}