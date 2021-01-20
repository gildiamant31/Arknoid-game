package animation;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import gamesetting.SpriteCollection;
import interfaces.Animation;

import java.awt.Color;

/**
 * this class print 3 2 1  Go before the game.
 */
public class CountdownAnimation implements Animation {
    private double numSec;
    private int count;
    private SpriteCollection sprites;
    private boolean stop;
    private int slowSleeper;

    /**
     * this is constructor.
     *
     * @param numOfSeconds - number of seconds that the animation run.
     * @param countFrom    - from how number to start.
     * @param gameScreen   - the list of the sprites.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numSec = numOfSeconds;
        this.count = countFrom;
        this.sprites = gameScreen;
        this.stop = false;
        this.slowSleeper = countFrom + 1;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleep = new Sleeper();
        if (this.count == -1) {
            this.stop = true;
        }
        if (this.slowSleeper != (this.count + 1)) {
            sleep.sleepFor((int) this.numSec * 110);
        }
        d.setColor(Color.BLUE);
        d.fillRectangle(0, 0, 800, 600);
        sprites.drawAllOn(d);
        d.setColor(Color.RED);
        if (this.count >= 1) {
            d.drawText(400, 400, String.valueOf(count), 95);
        }
        if (this.count == 0) {
            d.drawText(350, 400, "GO!", 100);
        }

        count--;
        //  sleep.sleepFor((long) (stop));
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}