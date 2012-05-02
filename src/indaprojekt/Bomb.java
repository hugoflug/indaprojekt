package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * A bomb is an object that a Player can throw and when it
 * lands it will eventually create an Explosion and disappear.
 *
 */
public class Bomb extends Projectile 
{
	private static final float BOMB_FRICTION = 0.9f;
	private static final int EXPLOSION_TIME = 700;
	
	private Expirer lifetime;
	private Sound sound;
	private Explosion explosion;
	private Sound fuseSound;
	
	public Bomb(float x, float y, float dx, float dy,
			Float hitBox, Animation animation, int millis) throws SlickException 
	{
		super(x, y, dx, dy, hitBox, animation, BOMB_FRICTION);
		lifetime = new Expirer(millis);
		sound = new Sound("res//sounds//bomb.ogg");
		fuseSound = new Sound("res//sounds//fuse.ogg");
		remove = false;
		
		fuseSound.play();
	}
	
	public void doLogic(Input input, int delta) throws SlickException 
	{	
		super.doLogic(input, delta);
		
		if (lifetime.hasExpired()) {
			sound.play();
			int explW = DefaultExplosion.getWidth();
			int explH = DefaultExplosion.getHeight();
			int bombW = animation.getWidth();
			int bombH = animation.getHeight();
			explosion = new DefaultExplosion(x - explW/2 + bombW/2, y - explH/2 + bombH/2, 
											 x + bombW/2, y + bombH/2); 
		}
	}
	
	@Override
	public Entity spawnEntity()
	{
		if (explosion != null) {
			remove = true;
		}
		return explosion;
	}
	
	@Override
	public void handleCollision(Entity entity) 
	{	
		if (!(entity instanceof Explosion)) {
			moveBack();
		}
		
		dx = -dx;
		dy = -dy;
	}

}
