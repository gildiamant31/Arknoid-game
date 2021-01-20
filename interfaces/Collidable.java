// ID: 314978412
package interfaces;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Ball;

/**
 * The interfaces Collidable.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the rectangle that we have a collision with.
     */
    Rectangle getCollisionRectangle();

    /**
     * Hit of the ball and the rectangle object.
     *
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity of the ball.
     * @param hitter          the ball that hits the block.
     * @return the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
