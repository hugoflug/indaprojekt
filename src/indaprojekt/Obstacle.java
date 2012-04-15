package indaprojekt;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

/**
 * A fixed, immovable object which blocks movement
 */
public class Obstacle extends Entity
{
	private Animation animation;
	
	public Obstacle(float x, float y, Animation animation) 
	{
		super(x, y);
		
		this.animation = animation;
	}

	@Override
	public void draw() throws SlickException 
	{
		animation.draw(x, y);
	}
}
