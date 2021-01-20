// ID: 314978412
package geometry;

import java.util.ArrayList;
import java.util.List;


/**
 * The type geometry.Rectangle.
 */
public class Rectangle {

    private Point upperLeft;
    private Point lowerRight;
    private double width, height;
    // List of all rectangle's lines.
    private List<Line> rectangleLines;

    /**
     * Instantiates a new geometry.Rectangle.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.lowerRight = new Point(upperLeft.getX() + width,
                upperLeft.getY() + height);
        this.width = width;
        this.height = height;
        this.rectangleLines = new ArrayList<Line>();
        // a and c are horizontal, b and d are vertical.
        Line a = new Line(this.getUpperLeft(), this.getUpperRight());
        Line b = new Line(this.getUpperRight(), this.getLowerRight());
        Line c = new Line(this.getLowerLeft(), this.getLowerRight());
        Line d = new Line(this.getUpperLeft(), this.getLowerLeft());
        rectangleLines.add(a);
        rectangleLines.add(b);
        rectangleLines.add(c);
        rectangleLines.add(d);
    }

    /**
     * This method return a list of all the intersection points
     * that the line has with this rectangle.
     *
     * @param line the trajectory of the ball.
     * @return list of intersection points, if there are no points return null.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<Point>();
        for (int i = 0; i < 4; ++i) {
            Line newLine = this.rectangleLines.get(i);
            if (newLine.isIntersecting(line)) {
                intersectionPoints.add(newLine.intersectionWith(line));
            }
        }
        return intersectionPoints;
    }


    /**
     * Gets width of this rectangle.
     *
     * @return the width of this rectangle.
     */
// Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height of this rectangle.
     *
     * @return the height of this rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets lower left point of this rectangle.
     *
     * @return the lower left point of this rectangle.
     */
    public Point getLowerLeft() {
        return new Point(this.getUpperLeft().getX(),
                this.getLowerRight().getY());
    }

    /**
     * Gets upper left point of this rectangle.
     *
     * @return the upper left point of this rectangle.
     */
// Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Gets upper right point of this rectangle.
     *
     * @return the upper right point of this rectangle.
     */
    public Point getUpperRight() {
        return new Point(this.getLowerRight().getX(),
                this.getUpperLeft().getY());
    }

    /**
     * Gets lower right point of this rectangle.
     *
     * @return the lower right point of this rectangle.
     */
    public Point getLowerRight() {
        return this.lowerRight;
    }

    /**
     * Gets rectangle lines.
     *
     * @return the rectangle lines
     */
    public List<Line> getRectangleLines() {
        return rectangleLines;
    }
}