package indaprojekt.entities;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DefaultBomb extends Bomb 
{
	private static final int BOMB_TIME = 500;
	
	public DefaultBomb(float x, float y, float dx, float dy) throws SlickException 
	{
		super(x, y, dx, dy, getHitBox(), getAnimation(), BOMB_TIME);	}
	
	public static Rectangle2D.Float getHitBox()
	{
		return new Rectangle2D.Float(0, 0, 32, 32);
	}
	
	private static Animation getAnimation() throws SlickException
	{
		Image image = new Image("res//images//bomb.png", Color.white);
		return new Animation(new Image[]{image}, 1);
	}

}
