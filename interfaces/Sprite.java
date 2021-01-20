// ID: 314978412
package interfaces;

import biuoop.DrawSurface;

/**
 * The interfaces Sprite.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the surface which we draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
