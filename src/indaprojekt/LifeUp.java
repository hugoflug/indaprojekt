package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LifeUp extends PowerUp
{
	public LifeUp(float x, float y) throws SlickException 
	{
		super(new Image("res//images//BlueHeart.png"), x, y, new Rectangle2D.Float(0, 0, 32, 32), new LifeUpEffect());
	}
}
