// ID: 314978412
package sprites;

import biuoop.DrawSurface;
import gamesetting.Counter;
import gamesetting.GameLevel;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreIndicator;
    //private Rectangle rect;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.scoreIndicator = score;
        //  this.rect = new Rectangle(new Point(0, 0), 800, 15);
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface which we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        int x = 0;
        int y = 0;
        int width = 800;
        int height = 17;
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(x, y, width, height);
        d.setColor(Color.BLACK);
        d.drawText((width / 2) - 20, height - 3, "Score: " + this.scoreIndicator.getValue(), 16);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add this scoreIndicator to the game.
     *
     * @param gameLevel the game
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
