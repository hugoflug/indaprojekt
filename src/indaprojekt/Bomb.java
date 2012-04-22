package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Bomb extends Projectile 
{
	private Expirer lifetime;
	private float friction;
	private Sound sound;
	private Explosion explosion;
	
	public Bomb(float x, float y, float dx, float dy, Float hitBox,
			Animation animation, int millis) throws SlickException 
	{
		super(x, y, dx, dy, hitBox, animation);
		lifetime = new Expirer(millis);
		sound = new Sound("res//sounds//bomb.ogg");
		friction = 0.15f;
		remove = false;
	}
	
	public void doLogic(Input input, int delta) throws SlickException 
	{	
		super.doLogic(input, delta);
		
		dx = General.towardsZero(dx, friction);
		dy = General.towardsZero(dy, friction);
		
		if (lifetime.hasExpired()) {
			sound.play();
			Image explImage = new Image("res//images//explosion.png", Color.white);
			Animation explAnim = new Animation(new Image[]{explImage}, 1);
			int explW = explImage.getWidth();
			int explH = explImage.getHeight();
			int bombW = animation.getWidth();
			int bombH = animation.getHeight();
			explosion = new Explosion(x - explW/2 + bombW/2, y - explH/2 + bombH/2, 
							new Rectangle2D.Float(0, 0, explImage.getWidth(), 
									explImage.getHeight()), explAnim, 500, x + bombW/2, y + bombH/2); 
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
		moveBack();
		dx = 0;
		dy = 0;
	}

}
