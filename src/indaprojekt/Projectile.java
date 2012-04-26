package indaprojekt;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public class Projectile extends ConstantMover
{
	protected Animation animation;
	protected float dx, dy;
	protected boolean remove;

	public Projectile(float x, float y, float dx, float dy, 
						Rectangle2D.Float hitBox, Animation animation,
						float friction) 
	{
		super(x, y, hitBox, dx, dy, friction);
		
		this.animation = animation;
		remove = false;
	}

	@Override
	public void draw() throws SlickException 
	{
		animation.draw(x, y);
	}
	
	@Override
	public boolean shouldBeRemoved()
	{
		return remove;
	}

	@Override
	public void handleCollision(Entity entity) 
	{
		remove = true;
	}

	@Override
	public Entity spawnEntity() 
	{
		return null;
	}
}
