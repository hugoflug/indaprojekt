package indaprojekt;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Animation;
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
	public void handleCollision(Entity entity) 
	{
		
	}
}
