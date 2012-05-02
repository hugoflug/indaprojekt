package indaprojekt.entities;

import indaprojekt.effects.Effect;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

abstract public class PowerUp extends Item {
	private Effect effect;
	private boolean hasCheckedCollision;
	private Sound sound;

	public PowerUp(Image image, float x, float y, Float hitBox, Effect effect, Sound sound) 
	{
		super(image, x, y, hitBox);
		this.effect = effect;
		this.sound = sound;
		
		hasCheckedCollision = false;
	}

	public Effect getEffect() {
		return effect;
	}
	
	@Override
	public void doLogic(Input input, int delta) 
	{
		super.doLogic(input, delta);
		hasCheckedCollision = true;
	}
		
	public void getPickedUp()
	{
		if (sound != null) {
			sound.play();
		}
	}

	@Override
	public void draw() throws SlickException 
	{
		if (hasCheckedCollision) {
			image.draw(x, y);
		}
	}
	
	
}
