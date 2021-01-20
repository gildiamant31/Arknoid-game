package backgronds;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Background direct hit.
 */
public class BackgroundDirectHit implements Sprite {
    private String levelName;

    /**
     * Instantiates a new Background direct hit.
     *
     * @param levelName the level name
     */
    public BackgroundDirectHit(String levelName) {
        this.levelName = levelName;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface which we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 30, 800, 600);
        d.setColor(Color.BLUE);
        d.drawLine(260, 181, 365, 181);
        d.drawLine(435, 181, 541, 181);
        d.drawLine(400, 200, 400, 327);
        d.drawLine(400, 56, 400, 150);
        d.drawCircle(400, 181, 60);
        d.drawCircle(400, 181, 90);
        d.drawCircle(400, 181, 120);
        d.setColor(Color.BLACK);
        d.drawText(600, 14, "Level Name:" + this.levelName, 16);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
