package gamesetting;

import animation.AnimationRunner;
import animation.EndScreen;
import animation.KeyPressStoppableAnimation;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private Counter balls;
    private EndScreen screen;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the animation runner
     * @param ks the keyboard
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.balls = new Counter();
        this.score = new Counter();
        this.screen = new EndScreen(this.balls, this.score, this.keyboardSensor);
    }

    /**
     * Run the levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean gameOver = false;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, score, balls);

            level.initialize();

            while (level.getRemainingBlocks().getValue() > 0) {
                level.run();
                if (balls.getValue() <= 0) {
                    gameOver = true;
                    break;
                }
            }

            if (gameOver) {
                break;
            }

        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                keyboardSensor.SPACE_KEY, screen));
        animationRunner.getGui().close();
    }
}