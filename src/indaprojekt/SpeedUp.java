package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;

public class SpeedUp extends PowerUp 
{
	private float spdDiff;
	
	private Effect effect;

	public SpeedUp(Image image, float x, float y, Float hitBox, float spdDiff, int millis) 
	{
		super(image, x, y, hitBox, new SpeedUpEffect(spdDiff, millis));	
	}
}
