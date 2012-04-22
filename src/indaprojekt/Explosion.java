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
	private float scale;
	private final float centerX, centerY;
	
	public Explosion(float x, float y, Float hitBox, Animation animation, int duration, 
					float centerX, float centerY) 
	{
		super(x, y, hitBox);
		lifetime = new Expirer(duration);
		this.animation = animation;
		
		scale = 0.5f;
		
		this.centerX = centerX;
		this.centerY = centerY;
	}

	@Override
	public void draw() throws SlickException 
	{
		animation.getCurrentFrame().draw(x, y, scale);
	}

	@Override
	public void doLogic(Input input, int delta) throws SlickException 
	{
		if (lifetime.hasExpired()) {
			remove = true;
		}
		scale += 0.005f*delta;
		
		center();
	}
	
	private void center()
	{
		x = centerX - (animation.getWidth()/2)*scale;
		y = centerY - (animation.getHeight()/2)*scale;
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
