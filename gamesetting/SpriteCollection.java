// ID: 314978412
package gamesetting;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * A class of game_setting.SpriteCollection.
 */
public class SpriteCollection {
    private List<Sprite> spritesCollection;

    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.spritesCollection = new ArrayList<>();
    }

    /**
     * Add sprite to the collection.
     *
     * @param s the new sprite.
     */
    public void addSprite(Sprite s) {
        this.spritesCollection.add(s);
    }

    /**
     * Remove sprite from the collection.
     *
     * @param s the sprite object
     */
    public void removeSprite(Sprite s) {
        this.spritesCollection.remove(s);
    }

    /**
     * Notify all sprites collection that time passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> copy = new ArrayList<>(this.spritesCollection);
        for (Sprite s : copy) {
            s.timePassed();
        }
    }

    /**
     * Gets sprites collection.
     *
     * @return the sprites collection
     */
    public List<Sprite> getSpritesCollection() {
        return spritesCollection;
    }

    /**
     * Draw all the sprites collection.
     *
     * @param d the draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : spritesCollection) {
            sprite.drawOn(d);
        }
    }
}