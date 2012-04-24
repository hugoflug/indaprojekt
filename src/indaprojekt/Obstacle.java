package indaprojekt;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * A fixed, immovable object which blocks movement
 */
public class Obstacle extends Entity
{
	private Animation animation;
	
	public Obstacle(float x, float y, Rectangle2D.Float hitBox, Animation animation) 
	{
		super(x, y, hitBox);
		
		this.animation = animation;
	}

	@Override
	public void draw() throws SlickException 
	{
		animation.draw(x, y);
	}

	@Override
	public boolean shouldBeRemoved()
	{
		return false;
	}
	
	@Override
	public void handleCollision(Entity entity) 
	{
		
	}

	@Override
	public void doLogic(Input input, int delta) throws SlickException 
	{
		
	}

	@Override
	public Entity spawnEntity() 
	{
		return null;
	}
}
