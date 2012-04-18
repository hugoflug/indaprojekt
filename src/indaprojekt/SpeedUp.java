package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;

public class SpeedUp extends Item {
	private float spdDiff;

	public SpeedUp(Image image, float x, float y, Float hitBox, float spdDiff) {
		super(image, x, y, hitBox);
		this.spdDiff = spdDiff;
	}
	
	/**
	 * @return How much the speed will increase.
	 */
	public float getSpdDiff() {
		return spdDiff;
	}

}
