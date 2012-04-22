package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Explosion extends Entity
{
	private Animation animation;
	private Expirer lifetime;
	private boolean remove;
	
	public Explosion(float x, float y, Float hitBox, Animation animation, int duration) 
	{
		super(x, y, hitBox);
		lifetime = new Expirer(duration);
		this.animation = animation;
	}

	@Override
	public void draw() throws SlickException 
	{
		animation.draw(x, y);
	}

	@Override
	public void doLogic(Input input, int delta) throws SlickException 
	{
		if (lifetime.hasExpired()) {
			remove = true;
		}
	}

	@Override
	public boolean shouldBeRemoved() 
	{
		return remove;
	}

	@Override
	public void handleCollision(Entity entity) 
	{

	}

	@Override
	public Entity spawnEntity() {
	
		return null;
	}
	
}
