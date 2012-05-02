package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * An Explosion with the default size, animation and time
 */
public class DefaultExplosion extends Explosion
{
	private static final int EXPLOSION_TIME = 700;
	private static final float START_SCALE = 0.1f;
	private static final float SCALE_PER_DELTA = 0.003f;

	public DefaultExplosion(float x, float y, float centerX, float centerY) throws SlickException 
	{
		super(x, y, getHitBox(getAnimation().getWidth(), getAnimation().getHeight()), 
				    getAnimation(), EXPLOSION_TIME, centerX, centerY,
				    START_SCALE, SCALE_PER_DELTA);
	}
	
	private static Rectangle2D.Float getHitBox(int width, int height)
	{
		return new Rectangle2D.Float(0, 0, width, height);
	}
	
	private static Animation getAnimation() throws SlickException
	{
		Image explImage = new Image("res//images//explosion.png", Color.white);
		return new Animation(new Image[]{explImage}, 1);
	}
	
	/**
	 * @return	the width of the DefaultExplosion animation
	 */
	public static int getWidth() throws SlickException
	{
		return getAnimation().getWidth();
	}
	
	/**
	 * @return	the height of the DefaultExplosion animation
	 */
	public static int getHeight() throws SlickException
	{
		return getAnimation().getHeight();
	}
}
