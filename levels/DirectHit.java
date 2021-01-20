package levels;

import backgronds.BackgroundDirectHit;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type of Direct hit level.
 */
public class DirectHit implements LevelInformation {
    private static final int NUM_OF_BALLS = 1;
    private static final int PADDLE_SPEED = 3;
    private static final int PADDLE_WIDTH = 80;
    private static final String LEVEL_NAME = "Direct Hit";
    private static final int NUM_OF_BLOCKS = 1;
    private BackgroundDirectHit background;

    /**
     * Instantiates a new Direct hit.
     */
    public DirectHit() {
        this.background = new BackgroundDirectHit(this.levelName());
    }

    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(181, 8));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return LEVEL_NAME;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();

        Block newBlo = new Block(new Rectangle(new Point(385, 160), 33, 33), Color.RED);
        blocks.add(newBlo);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS;
    }
}
