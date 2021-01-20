// ID: 314978412
package gamesetting;

import animation.AnimationRunner;
import animation.CountdownAnimation;
import animation.KeyPressStoppableAnimation;
import animation.PauseScreen;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import geometry.Point;
import hitlistener.BallRemover;
import hitlistener.BlockRemover;
import hitlistener.ScoreTrackingListener;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Ball;
import sprites.Block;
import sprites.Paddle;
import sprites.ScoreIndicator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type game_setting.Game.
 */
public class GameLevel implements Animation {
    // the height of the window.
    private static final int HEIGHT = 600;
    // the width of the window.
    private static final int WIDTH = 800;
    private SpriteCollection sprites;

    private GameEnvironment environment;
    private Sleeper sleeper;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;

    //  List of the Bounds of the game which consists of block objects.
    private List<Block> bounds;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private LevelInformation levelInfo;

    /**
     * Instantiates a new Game level.
     *
     * @param l     the level
     * @param ks    the keyboard
     * @param ar    the animation runner
     * @param sco   the score counter
     * @param balls the balls in the game.
     */
    public GameLevel(LevelInformation l, KeyboardSensor ks, AnimationRunner ar, Counter sco, Counter balls) {
        this.levelInfo = l;
        this.keyboard = ks;
        this.runner = ar;
        this.score = sco;
        remainingBalls = balls;
        balls.decrease(balls.getValue());
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter();
        this.running = true;
        this.sleeper = new Sleeper();
        this.bounds = new ArrayList<>();
    }

    /**
     * Instantiates a new game_setting.Game.
     */
    public GameLevel() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = new AnimationRunner();
        this.sleeper = new Sleeper();
        this.bounds = new ArrayList<>();
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.score = new Counter();
        this.running = true;
        this.keyboard = runner.getKeyboard();
    }

    /**
     * * Add collidable to the environment of this game.
     *
     * @param c the current collidable object.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite to the environment of this game.
     * from the game.
     *
     * @param s the current sprite object.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove collidable from the game.
     *
     * @param c the collidable object.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Remove sprite from the game.
     *
     * @param s the sprite object
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * This method creates all the game's objects.
     */
    public void initialize() {
        BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);
        BallRemover ballRemover = new BallRemover(this, remainingBalls);
        ScoreTrackingListener scoreTrack = new ScoreTrackingListener(this.score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        this.addBounds();
        scoreIndicator.addToGame(this);
        sprites.addSprite(levelInfo.getBackground());
        //add HitListener to bottom bound.
        this.bounds.get(3).addHitListener(ballRemover);
        for (Block b : bounds) {
            b.addToGame(this);
        }
        for (Block newBlock : levelInfo.blocks()) {
            newBlock.addToGame(this);
            newBlock.addHitListener(blockRemover);
            newBlock.addHitListener(scoreTrack);
        }
        this.remainingBlocks.increase(levelInfo.numberOfBlocksToRemove());
    }

    /**
     * this method makes the game run.
     */
    public void run() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(5, 3, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }


    /**
     * Add block bounds to the game.
     */
    public void addBounds() {
        /* creates the bounding blocks and draws them */
        Block leftBound = new Block(new Point(0, 16), 15, HEIGHT, Color.GRAY);
        Block rightBound = new Block(new Point(WIDTH - 15, 16), 15, HEIGHT, Color.GRAY);
        Block topBound = new Block(new Point(0, 16), WIDTH, 15, Color.GRAY);
        Block underBound = new Block(new Point(0, HEIGHT), WIDTH, 15, Color.BLUE);
        this.bounds.add(leftBound);
        this.bounds.add(rightBound);
        this.bounds.add(topBound);
        this.bounds.add(underBound);
    }

    /**
     * Add balls to this game.
     */
    public void createBallsOnTopOfPaddle() {
        for (int i = 0; i < levelInfo.numberOfBalls(); i++) {
            Ball ball1 = new Ball(new Point(WIDTH / 2, HEIGHT - 32), 7, Color.WHITE, environment);
            ball1.setVelocity(levelInfo.initialBallVelocities().get(i));
            ball1.addToGame(this);
            this.remainingBalls.increase(1);
        }
        Paddle paddle = new Paddle(levelInfo.paddleWidth(), HEIGHT, this.keyboard, levelInfo.paddleSpeed());
        paddle.addToGame(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLUE);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.remainingBlocks.getValue() < 1) {
            this.score.increase(100);
            this.running = false;
        }
        if (this.remainingBalls.getValue() < 1) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")||this.keyboard.isPressed("P")||
                this.keyboard.isPressed("פ")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, keyboard.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Gets remaining blocks.
     *
     * @return the remaining blocks counter.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
}