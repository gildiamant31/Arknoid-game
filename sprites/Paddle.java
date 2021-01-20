// ID: 314978412
package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gamesetting.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;

import java.awt.Color;

/**
 * Class of sprites.Paddle, which is the player's moving block.
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int widthOfScreen;
    private int paddleSpeed;

    /**
     * Instantiates a new sprites.Paddle.
     *
     * @param paddleWidth the width of the Paddle.
     * @param height      the height of the game window.
     * @param keyboard    the keyboard.
     * @param paddleSpeed the paddle speed.
     */
    public Paddle(int paddleWidth, int height, KeyboardSensor keyboard, int paddleSpeed) {
        this.paddleSpeed = paddleSpeed;
        this.keyboard = keyboard;
        this.rectangle = new Rectangle(new Point((double) 400 - (paddleWidth / 2), (double) height - 18),
                paddleWidth, height / 45);
        this.widthOfScreen = 800;
    }

    /**
     * This method moves left the paddle by changing its location.
     */
    public void moveLeft() {
        double x = this.rectangle.getUpperLeft().getX() - this.paddleSpeed;
        double y = this.rectangle.getUpperLeft().getY();
        if (x < 15) {
            x = 17;
        }
        Point ul = new Point(x, y);
        this.rectangle = new Rectangle(ul, this.rectangle.getWidth(), this.rectangle.getHeight());
    }

    /**
     * This method moves right the paddle by changing its location.
     */
    public void moveRight() {
        double x = this.rectangle.getUpperLeft().getX() + this.paddleSpeed;
        double y = this.rectangle.getUpperLeft().getY();
        if (x + this.rectangle.getWidth() > this.widthOfScreen - 15) {
            x = this.widthOfScreen - this.rectangle.getWidth() - 17;
        }
        Point ul = new Point(x, y);
        this.rectangle = new Rectangle(ul, this.rectangle.getWidth(), this.rectangle.getHeight());
    }


    /**
     * Update the paddle that time passed.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * Draw on this paddle.
     *
     * @param d the surface which we draw on.
     */
    public void drawOn(DrawSurface d) {
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        int width = (int) this.rectangle.getWidth();
        int height = (int) this.rectangle.getHeight();
        d.setColor(Color.YELLOW);
        d.fillRectangle(x, y, width, height);
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, width, height);
    }

    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Hit of the ball and the paddle.
     *
     * @param collisionPoint  the collision point of the ball ant the paddle.
     * @param currentVelocity the current velocity of the ball.
     * @param hitter          the ball that hits the block.
     * @return the  new velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double x = this.rectangle.getUpperLeft().getX();
        double collisionX = collisionPoint.getX();
        double newSpeed = Math.hypot(dx, dy);
        double partOfPaddle = collisionX - x;
        double partOfWidth = this.rectangle.getWidth() / 5;
        //horizontal lines of the rectangle.
        if (this.rectangle.getRectangleLines().get(0).isOnTheLine(collisionPoint)
                || this.rectangle.getRectangleLines().get(2).isOnTheLine(collisionPoint)) {
            if (partOfPaddle <= partOfWidth) {
                return Velocity.fromAngleAndSpeed(300, newSpeed);
            }
            if (partOfPaddle > partOfWidth && partOfPaddle <= 2 * partOfWidth) {
                return Velocity.fromAngleAndSpeed(330, newSpeed);
            }
            if (partOfPaddle > 2 * partOfWidth && partOfPaddle <= 3 * partOfWidth) {
                return new Velocity(dx, -dy);
            }
            if (partOfPaddle > 3 * partOfWidth && partOfPaddle <= 4 * partOfWidth) {
                return Velocity.fromAngleAndSpeed(30, newSpeed);
            }
            if (partOfPaddle > 4 * partOfWidth && partOfPaddle <= 5 * partOfWidth) {
                return Velocity.fromAngleAndSpeed(60, newSpeed);
            }
        }
        return new Velocity(-dx, dy);
    }


    /**
     * Add this paddle to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

}