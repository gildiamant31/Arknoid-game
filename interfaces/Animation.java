package interfaces;

import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * Doing one frame of the animation.
     *
     * @param d the surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Should stop the animation.
     *
     * @return the boolean stop
     */
    boolean shouldStop();
}