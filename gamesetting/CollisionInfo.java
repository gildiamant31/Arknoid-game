// ID: 314978412
package gamesetting;

import geometry.Point;
import interfaces.Collidable;

/**
 * Class which give all the info of the collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable cObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisionPoint the collision point.
     * @param cObject        the Collidable object.
     */
    public CollisionInfo(Point collisionPoint, Collidable cObject) {
        this.collisionPoint = collisionPoint;
        this.cObject = cObject;
    }

    /**
     * Collision- the point at which the collision occurs..
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * The collidable object involved in the collision..
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.cObject;
    }
}