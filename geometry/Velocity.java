// ID: 314978412
package geometry;

/**
 * This is class of geometry.Velocity,
 * which specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    //the change in the position of the coordinates.
    private double dx, dy;

    /**
     * constructor of geometry.Velocity from dx and dy.
     *
     * @param dx the change in position on the x axis.
     * @param dy the change in position on the y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;

    }

    /**
     * this method- construct geometry.Velocity object from angle and speed.
     *
     * @param angle the angle of the vector.
     * @param speed the length of the vector.
     * @return geometry.Velocity object.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //for using Math we have to replace the angle from degree to radians.
        double angeleRadian = Math.toRadians(angle);
        double dx = Math.sin(angeleRadian) * speed;
        double dy = -Math.cos(angeleRadian) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * this method returns the velocity's change in position of the y coordinate.
     *
     * @return the velocity's change in position of the y coordinate.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * this method returns the velocity's change in position of the x coordinate.
     *
     * @return the velocity's change in position of the x coordinate.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param p a point with position (x,y).
     * @return new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(this.dx + p.getX(), this.dy + p.getY());
        return newPoint;
    }
}