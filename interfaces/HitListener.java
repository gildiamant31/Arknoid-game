// ID: 314978412
package interfaces;

import sprites.Ball;
import sprites.Block;

/**
 * The interface Hit listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the object which being hit
     * @param hitter   the hitter parameter is the Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}