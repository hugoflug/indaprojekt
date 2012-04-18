package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;

abstract public class PowerUp extends Item {

	public PowerUp(Image image, float x, float y, Float hitBox) {
		super(image, x, y, hitBox);
	}

}
