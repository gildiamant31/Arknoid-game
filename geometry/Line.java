// ID: 314978412
package geometry;

import java.util.List;

/**
 * This is class of a straight line.
 */
public class Line {
    //makes the results more precise.
    static final double EPSILON = Math.pow(10, -14);
    private Point start, end;
    // the slope of the line.
    private Double slope;
    // this 'n' is for Straight equation.
    private double n;
    //this variable indicate if the line is vertical or not.
    private boolean isVertical;

    /**
     * constructor of line from two points.
     *
     * @param start the start point of the line.
     * @param end   the second point that defines the end line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        //if the line is vertical or it's a point(it hasn't a slope)
        if (start.getX() - end.getX() == 0) {
            this.isVertical = true;
            this.slope = null;
            this.n = 0;
        } else {
            this.slope = (start.getY() - end.getY()) / (start.getX() - end.getX());
            this.n = (slope * (-start.getX())) + start.getY();
            this.isVertical = false;
        }
        // now we have the Straight equation-  y=mx+n  (m is the slope).
    }

    /**
     * constructor of line from four coordinates which define the end and the start points of this line.
     *
     * @param x1 the x coordinate of the start point of the line.
     * @param y1 the y coordinate of the start point of the line.
     * @param x2 the x coordinate of the end point of the line.
     * @param y2 the y coordinate of the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        //if the line is vertical or it's a point(it hasn't a slope).
        if (x1 - x2 == 0) {
            this.isVertical = true;
            this.slope = null;
            this.n = 0;
        } else {
            this.slope = (y1 - y2) / (x1 - x2);
            this.n = (slope * (-x1)) + y1;
            this.isVertical = false;
        }
        // now we have the Straight equation-  y=mx+n  (m is the slope).
    }

    /**
     * Get n double.
     *
     * @return the double
     */
    public double getN() {
        return this.n;
    }

    /**
     * this method measures the length of this line.
     *
     * @return the length of this line.
     */
    public double length() {
        double lineLength = this.start.distance(this.end);
        return lineLength;
    }

    /**
     * this method find the middle point of this line.
     *
     * @return the middle point of this line.
     */
    public Point middle() {
        double middleX = ((start.getX() + end.getX()) / 2);
        double middleY = ((start.getY() + end.getY()) / 2);
        Point middlePoint = new Point(middleX, middleY);
        return middlePoint;
    }

    /**
     * this method measures the length of half line.
     *
     * @return the length of  half line.
     */
    public double halfLine() {
        return this.middle().distance(this.end);
    }

    /**
     * this method returns the starting point of this line.
     *
     * @return the starting point of this line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * this method returns the ending point of this line.
     *
     * @return the ending point of this line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * this method checks if two lines are intersecting.
     *
     * @param other the other line which it checks intersection with.
     * @return true if the two lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (this.isVertical && other.isVertical) {
            return false;
        }
        if (this.slope == (other.slope)) {
            return false;
            // now we have to check if the intersection point is in the range of our line.
        } else if (this.intersectionWith(other).distance(this.middle()) <= this.halfLine()) {
            // now we have to check if the intersection point is in the range of th other line.
            if (intersectionWith(other).distance(other.middle()) <= other.halfLine()) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * this method find intersection point of two lines.
     *
     * @param other the other line to check intersection with.
     * @return the intersection point if the lines intersect
     * (even though it isn't in the range of one  of these lines), null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (this.slope == (other.slope) || this.equals(other)) {
            return null;
        }
        // if both of the lines are vertical-they don't intersect.
        if (this.isVertical && other.isVertical) {
            return null;
        } else {
            Point intersectionPoint;
            if (this.isVertical) {
                //the x coordinate of this line is always the same.
                double intersectionX = this.start.getX();
                double intersectionY = (other.slope * intersectionX) + other.getN();
                intersectionPoint = new Point(intersectionX, intersectionY);
                return intersectionPoint;
            }
            if (other.isVertical) {
                //the x coordinate of other line is always the same.
                double intersectionX = other.start.getX();
                double intersectionY = (this.slope * intersectionX) + n;
                intersectionPoint = new Point(intersectionX, intersectionY);
            } else {
                //Comparing the straight equations.
                double intersectionX = (this.n - other.n) / (other.slope - this.slope);
                double intersectionY = (this.slope * intersectionX) + n;
                intersectionPoint = new Point(intersectionX, intersectionY);
            }
            return intersectionPoint;
        }
    }

    /**
     * this method checks if two lines are the same.
     *
     * @param other another line.
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        return false;
    }

    /**
     * Closest intersection to start's point of the line with rectangle.
     *
     * @param rect the rectangle that we check intersection with.
     * @return the close intersection point to the start of this line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (!intersectionPoints.isEmpty()) {
            if (intersectionPoints.size() == 2) {
                double d1 = this.start.distance(intersectionPoints.get(0));
                double d2 = this.start.distance(intersectionPoints.get(1));
                // if the intersectionPoint is in one of the corners of the rectangle.
                if (Math.abs(d1 - d2) <= EPSILON) {
                    if (rect.getRectangleLines().get(1).isOnTheLine(intersectionPoints.get(0))
                            || rect.getRectangleLines().get(3).isOnTheLine(intersectionPoints.get(0))) {
                        return intersectionPoints.get(0);
                    } else {
                        return intersectionPoints.get(1);
                    }
                }
                if (d1 > d2) {
                    return intersectionPoints.get(1);
                } else {
                    return intersectionPoints.get(0);
                }
            } else {
                return intersectionPoints.get(0);
            }
        }
        return null;
    }

    /**
     * Check if the point is on this line.
     *
     * @param point the point which we check.
     * @return true if it is on the line and false otherwise.
     */
    public boolean isOnTheLine(Point point) {
        double x = point.getX();
        double y = point.getY();
        if (!this.isVertical) {
            if (Math.abs(y - ((slope * x) + n)) <= EPSILON) {
                return true;
            }
            return false;
        } else {
            if (Math.abs(this.start.getX() - x) <= EPSILON) {
                return true;
            }
            return false;
        }
    }
}
