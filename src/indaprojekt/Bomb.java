package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Bomb extends Projectile 
{
	private Expirer lifetime;
	private float friction;
	private Sound sound;
	
	public Bomb(float x, float y, float dx, float dy, Float hitBox,
			Animation animation) throws SlickException 
	{
		super(x, y, dx, dy, hitBox, animation);
		lifetime = new Expirer(1000);
		sound = new Sound("res//sounds//bomb.ogg");
		friction = 0.15f;
	}
	public void doLogic(Input input, int delta) throws SlickException 
	
	{	
		super.doLogic(input, delta);
		
		dx = General.towardsZero(dx, friction);
		dy = General.towardsZero(dy, friction);
		
		if (lifetime.hasExpired()) {
			//TODO: explode bomb
			sound.play();
			remove = true;
		}
	}
	
	@Override
	public void handleCollision(Entity entity) 
	{
		moveBack();
		dx = 0;
		dy = 0;
	}

}
