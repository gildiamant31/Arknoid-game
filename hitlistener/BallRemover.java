// ID: 314978412
package hitlistener;

import gamesetting.Counter;
import gamesetting.GameLevel;
import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param gameLevel           the game
     * @param remainingBalls the remaining balls counter
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }
    /**
     * This method is called whenever the beingHit object is hit
     * and remove the ball from the game.
     *
     * @param beingHit the death block object which being hit
     * @param hitter   the hitter parameter is the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
