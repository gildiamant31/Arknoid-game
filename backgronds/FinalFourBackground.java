package backgronds;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The type Final four background.
 */
public class FinalFourBackground implements Sprite {
    private String levelName;

    /**
     * Instantiates a new Final four background.
     *
     * @param levelName the level name
     */
    public FinalFourBackground(String levelName) {
        this.levelName = levelName;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface which we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0, 157, 215));
        d.fillRectangle(0, 30, 800, 600);
        d.setColor(Color.YELLOW);
        d.fillCircle(350, 300, 37);
        d.fillCircle(420, 300, 37);
        int x1 = 455;
        int y1 = 313;
    //    d.drawLine(435, 400, x1, y1);
      //  d.drawLine(435, 400, 365, y1);
        for (int i = 0; x1 >= 315; ++i) {
            d.drawLine(385, 400, x1, y1);
            x1 -= 1;
        }
        d.setColor(Color.BLACK);
        d.drawText(500, 350, "OOP", 48);
        d.drawText(250, 350, "I", 48);
        d.drawText(600, 14, "Level Name:" + this.levelName, 16);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
