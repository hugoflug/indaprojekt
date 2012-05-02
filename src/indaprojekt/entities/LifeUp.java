package indaprojekt.entities;

import indaprojekt.effects.LifeUpEffect;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * A power-up that gives a LifeUpEffect.
 *
 */
public class LifeUp extends PowerUp
{
	public LifeUp(float x, float y) throws SlickException 
	{
		super(new Image("res//images//BlueHeart.png"), 
			  x, y, 
			  new Rectangle2D.Float(0, 0, 32, 32), 
			  new LifeUpEffect(),
			  new Sound("res//sounds//lifeup.ogg")); //TEMP
	}
}
