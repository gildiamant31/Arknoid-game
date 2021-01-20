// ID: 314978412
package sprites;

import biuoop.DrawSurface;
import gamesetting.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * This is a class of block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new sprites.Block.
     *
     * @param upperLeft the upper left point of the block
     * @param width     the width of the block.
     * @param height    the height of the block.
     * @param c         the color of the block.
     */
    public Block(Point upperLeft, int width, int height, Color c) {
        this.rect = new Rectangle(upperLeft, (double) width, (double) height);
        this.color = c;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Instantiates a new sprites.Block.
     *
     * @param rectangle the rectangle of the block.
     * @param color     the color of the block.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rect = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }


    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * Hit of the ball and the black.
     *
     * @param collisionPoint  the collision point of the ball ant the block.
     * @param currentVelocity the current velocity of the ball.
     * @param hitter          the ball that hits the block.
     * @return the  new velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        Velocity newVelocity = new Velocity(dx, dy);
        //horizontal lines of the rectangle.
        if (this.rect.getRectangleLines().get(0).isOnTheLine(collisionPoint)
                || this.rect.getRectangleLines().get(2).isOnTheLine(collisionPoint)) {
            newVelocity = new Velocity(dx, -dy);
        }
        //vertical lines of the rectangle.
        if (this.rect.getRectangleLines().get(1).isOnTheLine(collisionPoint)
                || this.rect.getRectangleLines().get(3).isOnTheLine(collisionPoint)) {
            newVelocity = new Velocity(-dx, dy);
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * Draw on this block.
     *
     * @param surface the surface which we draw on.
     */
    public void drawOn(DrawSurface surface) {
        int x = (int) this.rect.getUpperLeft().getX();
        int y = (int) this.rect.getUpperLeft().getY();
        int width = (int) this.rect.getWidth();
        int height = (int) this.rect.getHeight();
        surface.setColor(this.color);
        surface.fillRectangle(x, y, width, height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x, y, width, height);
    }

    /**
     * Update the block that time passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * this method gets a ball that is hitting the block and notify
     * all the hit listeners about the hit.
     *
     * @param hitter the hitting ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Add this block to the game.
     *
     * @param gameLevel the game.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }

    /**
     * Remove this block from the game.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * Gets this block's color.
     *
     * @return the color.
     */
    public Color getColor() {
        return color;
    }
}
