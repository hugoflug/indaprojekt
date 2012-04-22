package indaprojekt;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Projectile extends Mover
{
	private Animation animation;
	protected float dx, dy;
	protected boolean remove;

	public Projectile(float x, float y, float dx, float dy, 
						Rectangle2D.Float hitBox, Animation animation) 
	{
		super(x, y, hitBox);
		
		this.dx = dx;
		this.dy = dy;
		
		this.animation = animation;
		remove = false;
	}
	
	@Override
	public void doLogic(Input input, int delta) throws SlickException 
	{	
		super.doLogic(input, delta);
		move(dx*delta, dy*delta);
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
