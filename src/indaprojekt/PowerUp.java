package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

abstract public class PowerUp extends Item {
	private Effect effect;
	private boolean hasCheckedCollision;

	public PowerUp(Image image, float x, float y, Float hitBox, Effect effect) {
		super(image, x, y, hitBox);
		this.effect = effect;
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

	@Override
	public void draw() throws SlickException 
	{
		if (hasCheckedCollision) {
			image.draw(x, y);
		}
	}
}
