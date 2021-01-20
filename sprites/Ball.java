// ID: 314978412
package sprites;

import biuoop.DrawSurface;
import gamesetting.CollisionInfo;
import gamesetting.GameEnvironment;
import gamesetting.GameLevel;
import geometry.Line;
import geometry.Point;
import geometry.Velocity;
import interfaces.Sprite;

import java.awt.Color;

/**
 * this is a class of ball.
 */
public class Ball implements Sprite {
    //the center point of the ball.
    private Point center;
    //the radius of the ball, it indicates his size.
    private int radius;
    //the ball's color.
    private Color color;
    //the ball's velocity.
    private Velocity v;
    // the ball's gameEnvironment.
    private GameEnvironment gameE;

    /**
     * constructor of ball from two coordinates, radius and color.
     *
     * @param x     the x coordinate of the ball's center.
     * @param y     the y coordinate of the ball's center.
     * @param r     the ball's radius.
     * @param color the ball's color.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point((double) x, (double) y);
        this.radius = r;
        this.color = color;
        this.v = new Velocity(0, 0);
    }

    /**
     * constructor of  ball from point, radius and color.
     *
     * @param center the location of the ball's center.
     * @param r      the ball's radius.
     * @param color  the ball's color.
     * @param g      the game environment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment g) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.gameE = g;
    }

    /**
     * this method returns the x coordinate of the ball's center.
     *
     * @return the x coordinate of the ball's center.
     */
    public int getX() {
        // we use round to get the closest value of x(double to int).
        return (int) Math.round(this.center.getX());
    }

    /**
     * this method returns the y coordinate of the ball's center.
     *
     * @return the y coordinate of the ball's center.
     */
    public int getY() {
        // we use round to get the closest value of x(double to int).
        return (int) Math.round(this.center.getY());
    }

    /**
     * this method returns the ball's radius(his size).
     *
     * @return the ball's radius.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Sets center point of the ball.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }

    /**
     * this method returns the ball's color.
     *
     * @return the ball's color.
     */

    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * this method draws the ball on given DrawSurface.
     *
     * @param surface the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * Update the ball that time passed.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * this method sets the ball's velocity.
     *
     * @param dx the change in position of x.
     * @param dy the change in position of y.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * this method returns the ball's velocity.
     *
     * @return the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * this method sets the ball's velocity.
     *
     * @param velocity geometry.Velocity object to apply on the ball.
     */
    public void setVelocity(Velocity velocity) {
        this.v = velocity;
    }

    /**
     * Gets game environment.
     *
     * @return the game environment.
     */
    public GameEnvironment getGameE() {
        return gameE;
    }

    /**
     * Sets game environment.
     *
     * @param g the game environment.
     */
    public void setGameE(GameEnvironment g) {
        this.gameE = g;
    }

    /**
     * this method checks if the ball is in the window
     * by calculating the location of the x coordinate with dx
     * and the radius of the ball.
     *
     * @param width  the width of the window.
     * @param height the height of the window.
     * @param x      thw x coordinate of the ball's center point.
     * @return true if it in the window,otherwise return false.
     */
    public boolean isXNotInRange(int width, int height, int x) {
        if ((this.center.getX() + this.radius
                + this.v.getDx() > width + x)
                || (this.center.getX() - this.radius
                + this.v.getDx() < 0 + x)) {
            return true;
        }
        return false;
    }

    /**
     * this method checks if the ball is in the window
     * by calculating the location of the y coordinate with dy
     * and the radius of the ball.
     *
     * @param width  the width of the window.
     * @param height the height of the window.
     * @param y      thw y coordinate of the ball's center point.
     * @return true if it in the window,otherwise return false.
     */
    public boolean isYNotInRange(int width, int height, int y) {
        if ((this.center.getY() + this.radius
                + this.v.getDy() > height + y)
                || (this.center.getY() - this.radius
                + this.v.getDy() < 0 + y)) {
            return true;
        }
        return false;
    }


    /**
     * this method moves the ball's center according to it's velocity.
     */
    public void moveOneStep() {
        CollisionInfo collision = gameE.getClosestCollision(this.trajectory());
        if (collision == null) {
            this.center = this.v.applyToPoint(this.center);
        } else {
            this.v = collision.collisionObject().hit(this, collision.collisionPoint(), this.v);
            this.center = this.v.applyToPoint(this.center);
        }
    }

    /**
     * this method return the trajectory line of this ball.
     *
     * @return the trajectory line of this ball.
     */
    public Line trajectory() {
        double x = this.center.getX();
        double y = this.center.getY();
        double dx = this.getVelocity().getDx();
        double dy = this.getVelocity().getDy();
        if (dx < 0) {
            x = this.center.getX() + dx - this.radius;
        }
        if (dx >= 0) {
            x = this.center.getX() + dx + this.radius;
        }
        if (dy < 0) {
            y = this.center.getY() + dy - this.radius;
        }
        if (dy > 0) {
            y = this.center.getY() + dy + this.radius;
        }
        Point end = new Point(x, y);
        Line trajectory = new Line(this.center, end);
        return trajectory;
    }

    /**
     * Add this ball to the game.
     *
     * @param gameLevel the game.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * Remove this ball from the game.
     *
     * @param gameLevel the game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}

