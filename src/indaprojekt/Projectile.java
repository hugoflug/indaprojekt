package indaprojekt;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public class Projectile extends Mover
{
	private Animation animation;
	private float dx, dy;

	public Projectile(float x, float y, float dx, float dy, 
						Rectangle2D.Float hitBox, Animation animation) 
	{
		super(x, y, hitBox);
		
		this.dx = dx;
		this.dy = dy;
		
		this.animation = animation;
	}
	
	/**
	 * Does internal logic things, to be called each update
	 */
	public void doLogic(int delta)
	{
		this.x += dx*delta;
		this.y += dy*delta;
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
