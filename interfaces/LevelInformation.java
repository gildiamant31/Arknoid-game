package interfaces;

import geometry.Velocity;
import sprites.Block;

import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls in the level.
     *
     * @return the number of the balls in the level.
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     *
     * @return the list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the width of the paddle.
     */
    int paddleWidth();

    /**
     * Level name string.
     *
     * @return the string of the level name.
     */
    String levelName();

    /**
     * Gets background.
     *
     * @return the background of this level.
     */
    Sprite getBackground();

    /**
     * Blocks list.
     *
     * @return the list of all blocs in this level.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed.
     *
     * @return the number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}
