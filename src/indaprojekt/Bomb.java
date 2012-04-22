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
			Animation animation) throws SlickException 
	{
		super(x, y, dx, dy, hitBox, animation);
		lifetime = new Expirer(1000);
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
			explosion = new Explosion(x, y, new Rectangle2D.Float(0, 0, 40, 40), explAnim, 500); 
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
