package levels;

import backgronds.BackgroundWideEasy;
import geometry.Point;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Wide easy.
 */
public class WideEasy implements LevelInformation {
    private static final int NUM_OF_BALLS = 10;
    private static final int PADDLE_SPEED = 6;
    private static final int PADDLE_WIDTH = 600;
    private static final String LEVEL_NAME = "Wide Easy";
    private static final int NUM_OF_BLOCKS = 15;
    private BackgroundWideEasy background;

    /**
     * Instantiates a new Wide easy level.
     */
    public WideEasy() {
        this.background = new BackgroundWideEasy(this.levelName());
    }

    /**
     * Number of balls in the level.
     *
     * @return the number of the balls in the level.
     */
    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    /**
     * Initial ball velocities list.
     *
     * @return the list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        int angle = 121;
        List<Velocity> vel = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            vel.add(Velocity.fromAngleAndSpeed(angle, 6));
            if (angle >= 168 && angle <= 170) {
                angle += 24;
            } else {
                angle += 12;
            }
        }
        return vel;
    }

    /**
     * Paddle speed int.
     *
     * @return the paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * Paddle width int.
     *
     * @return the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * Level name string.
     *
     * @return the string of the level name.
     */
    @Override
    public String levelName() {
        return LEVEL_NAME;
    }

    /**
     * Gets background.
     *
     * @return the background of this level.
     */
    @Override
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * Blocks list.
     *
     * @return the list of all blocs in this level.
     */
    @Override
    public List<Block> blocks() {
        double j = 15;
        List<Block> bloList = new ArrayList<Block>();
        for (int i = 0; i < 15; i++) {

            if (i < 2) {
                Block blo = new Block(new Point(j, 220), 52, 20, Color.RED);
                bloList.add(blo);
            }
            if ((i >= 2) && (i < 4)) {
                Block blo = new Block(new Point(j, 220), 52, 20, Color.ORANGE);
                bloList.add(blo);
            }
            if ((i >= 4) && (i < 6)) {
                Block blo = new Block(new Point(j, 220), 52, 20, Color.YELLOW);
                bloList.add(blo);
            }
            if ((i >= 6) && (i < 9)) {
                Block blo = new Block(new Point(j, 220), 52, 20, Color.GREEN);
                bloList.add(blo);
            }
            if ((i >= 9) && (i < 11)) {
                Block blo = new Block(new Point(j, 220), 52, 20, Color.BLUE);
                bloList.add(blo);
            }
            if ((i >= 11) && (i < 13)) {
                Block blo = new Block(new Point(j, 220), 52, 20, Color.PINK);
                bloList.add(blo);
            }
            if (i >= 13) {
                Block blo = new Block(new Point(j, 220), 52, 20, Color.CYAN);
                bloList.add(blo);
            }
            j += 51.35;

        }
        return bloList;
    }

    /**
     * Number of blocks to remove int.
     *
     * @return the int
     */
    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS;
    }
}
