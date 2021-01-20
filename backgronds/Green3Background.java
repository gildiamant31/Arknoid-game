package backgronds;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Green 3 background.
 */
public class Green3Background implements Sprite {
    private String levelName;

    /**
     * Instantiates a new Green 3 background.
     *
     * @param levelName the level name
     */
    public Green3Background(String levelName) {
        this.levelName = levelName;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface which we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0, 127, 12));
        d.fillRectangle(0, 30, 800, 600);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(60, 440, 80, 240);
        d.fillRectangle(90, 400, 23, 40);
        d.fillRectangle(97, 229, 10, 170);
        d.setColor(Color.ORANGE);
        d.fillCircle(103, 229, 15);
        d.setColor(Color.RED);
        d.fillCircle(103, 229, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(103, 229, 5);
        int x = 67;
        int y = 450;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(x, y, 10, 15);
                x += 14;
            }
            y += 20;
            x = 67;
        }
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
