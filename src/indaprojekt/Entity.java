package indaprojekt;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * A class representing any physical object in the game
 *
 */
public abstract class Entity 
{
	protected float x, y;
	protected Rectangle2D.Float hitBox;
	protected Rectangle2D.Float offsetHitBox;
	
	/**
	 * @param x			the initial x position of the entity
	 * @param y			the initial y position of the entity
	 * @param hitBox	the area, counted from (x, y), where the entity will collide
	 * 					with other entities
	 */
	public Entity(float x, float y, Rectangle2D.Float hitBox) 
	{
		this.x = x;
		this.y = y;
		this.hitBox = hitBox;
		offsetHitBox = new Rectangle2D.Float(x + hitBox.x, y + hitBox.y, hitBox.width, hitBox.height);
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
	public boolean isCollision(Entity entity)
	{
		return this.offsetHitBox.intersects(entity.offsetHitBox);
	}
	
	/**
	 * Does any internal logic the entity needs to do
	 * @param input		an Input holding the current input state
	 * @param delta		time, in ms, since last update
	 */
	public abstract void doLogic(Input input, int delta) throws SlickException;
	
	/**
	 * @return	whether this entity should be removed from the game
	 */
	public abstract boolean shouldBeRemoved();
	
	public abstract void handleCollision(Entity entity);
	
	/**
	 * @return	an entity if this Entity has spawned another entity, otherwise null
	 */
	public abstract Entity getEntity();
}
