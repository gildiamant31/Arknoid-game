// ID: 314978412
package hitlistener;

import gamesetting.Counter;
import gamesetting.GameLevel;
import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * The type Block remover.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel            the game
     * @param remainingBlocks the remaining blocks counter.
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * This method is called whenever the beingHit object is hit
     * and remove the block from the game.
     *
     * @param beingHit the Block object which being hit
     * @param hitter   the hitter parameter is the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}