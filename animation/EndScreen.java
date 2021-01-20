package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gamesetting.Counter;
import interfaces.Animation;

import java.awt.Color;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private Counter balls;
    private Counter scores;
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * this is constructor.
     *
     * @param balls - the counter of the balls.
     * @param score - the counter of the score.
     * @param key   - the keyboard.
     */
    public EndScreen(Counter balls, Counter score, KeyboardSensor key) {
        this.balls = balls;
        this.scores = score;
        this.keyboard = key;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.balls.getValue() <= 0) {
            d.setColor(Color.BLACK);
            d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
            d.setColor(Color.WHITE);
            d.drawText((d.getWidth() / 2) - 250, d.getHeight() / 2, "Game Over. Your score is "
                    + this.scores.getValue(), 36);
            d.setColor(Color.RED);
            d.drawText((d.getWidth() / 2) - 200, d.getHeight() / 2 + 50, "Press Space To Continue", 36);
        } else {
            d.setColor(Color.YELLOW);
            d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
            d.setColor(Color.BLUE);
            d.drawText((d.getWidth() / 2) - 250, d.getHeight() / 2, "You Win! Your score is "
                    + this.scores.getValue(), 36);
            d.setColor(Color.BLACK);
            d.drawText((d.getWidth() / 2) - 200, d.getHeight() / 2 + 50, "Press Space To Continue", 36);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
