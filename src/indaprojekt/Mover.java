package indaprojekt;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * A class representing any physical object capable of moving
 * in the game
 *
 */
public abstract class Mover extends Entity
{
	private float oldX, oldY;
	
	public Mover(float x, float y, Rectangle2D.Float hitBox) 
	{
		super(x, y, hitBox);
		oldX = x;
		oldY = y;
	}
	
	/**
	 * Moves this object by the specified x-distance and y-distance
	 * @param dx	the x-distance to move the Mover
	 * @param dy	the y-distance to move the Mover
	 */
	protected void move(float dx, float dy)
	{
		moveTo(x + dx, y + dy);
	}
	
	/**
	 * Moves this object to the specified position (x, y)
	 * @param x
	 * @param y
	 */
	private void moveTo(float x, float y)
	{
		oldX = this.x;
		oldY = this.y;
		this.x = x;
		this.y = y;
		offsetHitBox.setRect(x + hitBox.x, y + hitBox.y, hitBox.width, hitBox.height);
	}
	
	/**
	 * Moves back this object to the position before the last time it moved
	 */
	protected void moveBack()
	{
		//not sure why this doesn't work
//		moveTo(oldX, oldY);
		x = oldX;
		y = oldY;
		offsetHitBox.setRect(x + hitBox.x, y + hitBox.y, hitBox.width, hitBox.height);
	}
}
