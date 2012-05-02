package indaprojekt.entities;

import indaprojekt.effects.SpeedUpEffect;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SpeedUp extends PowerUp 
{	
	public SpeedUp(float x, float y, float spdDiff, int millis) throws SlickException 
	{
		super(new Image("res//images//Speed.png"), 
			  x, y, 
			  new Rectangle2D.Float(0, 0, 25, 25), 
			  new SpeedUpEffect(spdDiff, millis),
			  new Sound("res//sounds//speedup.ogg"));	
	}
}
