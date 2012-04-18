package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;

abstract public class PowerUp extends Item 
{
	private Effect effect;
	
	public PowerUp(Image image, float x, float y, Float hitBox, Effect effect) 
	{
		super(image, x, y, hitBox);
		this.effect = effect;
	}
	
	public Effect getEffect()
	{
		return effect;
	}

}
