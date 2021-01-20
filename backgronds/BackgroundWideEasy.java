package backgronds;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Background wide easy.
 */
public class BackgroundWideEasy implements Sprite {
    private String levelName;

    /**
     * Instantiates a new Background wide easy.
     *
     * @param levelName the level name
     */
    public BackgroundWideEasy(String levelName) {
        this.levelName = levelName;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface which we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 30, 800, 600);
        int j = 0;
        d.setColor(new Color(236, 214, 165));
        for (int i = 0; i < 90; i++) {
            d.drawLine(130, 130, j, 220);
            j += 8;
        }
        d.setColor(new Color(236, 214, 165));
        d.fillCircle(130, 130, 60);
        d.setColor(Color.ORANGE);
        d.fillCircle(130, 130, 48);
        d.setColor(Color.YELLOW);
        d.fillCircle(130, 130, 36);
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
