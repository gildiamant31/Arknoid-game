// ID: 314978412
package hitlistener;

import gamesetting.Counter;
import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * This method is called whenever the beingHit object is hit
     * and increase the score counter in 5 points.
     *
     * @param beingHit the Block object which being hit
     * @param hitter   the hitter parameter is the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
        beingHit.removeHitListener(this);
    }
}