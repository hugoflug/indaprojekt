package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.util.Deque;
import java.util.LinkedList;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * A class representing any physical object capable of moving
 * in the game
 *
 */
public abstract class Mover extends Entity
{
	
	private LinkedList<Float> oldPositions;
	
	public Mover(float x, float y, Rectangle2D.Float hitBox) 
	{
		super(x, y, hitBox);
		oldPositions = new LinkedList<Float>();

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
	protected void moveTo(float x, float y)
	{
		oldPositions.push(this.x);
		oldPositions.push(this.y);
		
		if(oldPositions.size() > 100) {
			oldPositions.removeLast();
			oldPositions.removeLast();
		}
		
		this.x = x;
		this.y = y;
		offsetHitBox.setRect(x + hitBox.x, y + hitBox.y, hitBox.width, hitBox.height);
	}
	
	/**
	 * Does internal logic things, to be called each update
	 * @param input		a reference to an Input object, describing input
	 * @throws SlickException
	 */
	public void doLogic(Input input, int delta) throws SlickException 
	{	
	}
	
	/**
	 * Moves back this object to the position before the last time it moved
	 */
	protected void moveBack()
	{
		if(!(oldPositions.size() == 0)) {
			y = oldPositions.pop();
			x = oldPositions.pop();
			System.out.println(x + " " + y + " " + oldPositions.size());
			offsetHitBox.setRect(x + hitBox.x, y + hitBox.y, hitBox.width, hitBox.height);
		}

	}
}
