package indaprojekt;

import org.newdawn.slick.SlickException;

/**
 * A class representing any physical object in the game
 *
 */
public abstract class Entity 
{
	protected float x, y;

	public Entity(float x, float y) 
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draw this entity at its' current position
	 * @throws SlickException	if entity couldn't be drawn
	 */
	public abstract void draw() throws SlickException;
	
	/**
	 * Check if this entity and <code>entity</code> has collided
	 * @param entity	the entity to check collision with
	 */
	public void isCollision(Entity entity)
	{
		
	}
}
