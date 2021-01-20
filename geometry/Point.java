// ID: 314978412
package geometry;

/**
 * This class represents a point.
 * The class support point operations- distance, equals and return the value o x and y of this point.
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x the x coordinate of this point.
     * @param y the y coordinate of this point.
     */
    public Point(int x, int y) {
        this.x = (double) x;
        this.y = (double) y;
    }

    /**
     * constructor.
     *
     * @param x the x coordinate of this point.
     * @param y the y coordinate of this point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * this method measures the distance from this point to another point.
     *
     * @param p another point.
     * @return the distance of this point from the other point.
     */
    public double distance(Point p) {
        double pointsDistance;
        pointsDistance = Math.hypot(Math.abs(this.x - p.x), Math.abs(this.y - p.y));
        return pointsDistance;
    }

    /**
     * this method checks if two points are the same.
     *
     * @param p another point.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point p) {
        if (this.x == p.x && this.y == p.y) {
            return true;
        }
        return false;
    }

    /**
     * this method returns the x value of this point.
     *
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * this method returns the y value of this point.
     *
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }
}