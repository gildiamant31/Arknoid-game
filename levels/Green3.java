package levels;

import backgronds.Green3Background;
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
 * The type Green 3.
 */
public class Green3 implements LevelInformation {
    private static final int NUM_OF_BALLS = 2;
    private static final int PADDLE_SPEED = 7;
    private static final int PADDLE_WIDTH = 80;
    private static final String LEVEL_NAME = "Green 3";
    private static final int NUM_OF_BLOCKS = 40;
    private Green3Background background;

    /**
     * Instantiates a new Green 3.
     */
    public Green3() {
        this.background = new Green3Background(this.levelName());
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
        int x = 220;
        List<Velocity> vel = new ArrayList<Velocity>();
        for (int i = 0; i < 2; i++) {
            vel.add(Velocity.fromAngleAndSpeed(x, 6));
            x -= 80;
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
        List<Block> blocks = new ArrayList<>();
        //rectangle width and height.
        double rWidth = 50;
        double rHeight = 20;
        int widthOfBlocks = 50;
        //the y coordinate of the upperLeft point of the rectangle.
        int y = 120;
        for (int i = 10; i > 5; --i) {
            for (int j = 0; j < i; ++j) {
                Rectangle rect = new Rectangle(new Point(785 - widthOfBlocks, y), rWidth, rHeight);
                Block newBlock = new Block(rect, makeNewColor(i));
                blocks.add(newBlock);
                widthOfBlocks += 50;
            }
            widthOfBlocks = 50;
            y += 20;
        }
        return blocks;
    }

    /**
     * this method creates new color.
     *
     * @param num the num
     * @return the color
     */
    public Color makeNewColor(int num) {
        switch (num) {
            case 10:
                return Color.GRAY;
            case 9:
                return Color.RED;
            case 8:
                return Color.YELLOW;
            case 7:
                return Color.BLUE;
            case 6:
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
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
