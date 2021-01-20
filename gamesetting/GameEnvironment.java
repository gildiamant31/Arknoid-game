// ID: 314978412
package gamesetting;

import geometry.Line;
import geometry.Point;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The type game_setting.GameEnvironment.
 */
public class GameEnvironment {
    //The Collidable list.
    private List<Collidable> collidableList;

    /**
     * Constructor of a new game_setting.Game environment.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<>();
    }

    /**
     * Add collidable to collidable list.
     *
     * @param c the collidable object.
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * Remove collidable from the game environment .
     *
     * @param c the collidable object
     */
    public void removeCollidable(Collidable c) {
        this.collidableList.remove(c);
    }

    /**
     * Gets closest collision of trajectory and block.
     *
     * @param trajectory the trajectory line.
     * @return the closest collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        for (Collidable c : collidableList) {
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (collisionPoint != null) {
                CollisionInfo newCI = new CollisionInfo(collisionPoint, c);
                return newCI;
            }
        }
        return null;
    }

}