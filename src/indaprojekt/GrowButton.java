package indaprojekt;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * A button that grows a little bit when you hover over 
 * it with the mouse.
 *
 */
public class GrowButton extends Button 
{
	private float scalePerMilli;
	private Expirer scaleTime;
	private boolean alreadyInArea;
	private int scaleMillis;
	private int centerX, centerY;
	
	public GrowButton(Image image, Image mouseOverImage, Float area, float endScale, int scaleMillis) 
	{
		this(image, mouseOverImage, area, endScale, scaleMillis, (int)(area.width/2), (int)(area.height/2));
	}
	
	public GrowButton(Image image, Image mouseOverImage, Float area, float endScale, int scaleMillis, int centerX, int centerY) 
	{
		super(image, mouseOverImage, area);
		this.centerX = centerX;
		this.centerY = centerY;
		this.scaleMillis = scaleMillis;
		scalePerMilli = (endScale - 1)/scaleMillis;
		alreadyInArea = false;
	}
	
	@Override
	public void doLogic(int delta, Input input) throws SlickException 
	{
		super.doLogic(delta, input);
		if (ogArea.contains(input.getMouseX(), input.getMouseY())) {
			if (!alreadyInArea) {
				scaleTime = new Expirer(scaleMillis);
				alreadyInArea = true;
			}
			if (!scaleTime.hasExpired()) {
				scale += scalePerMilli*delta;
			}
			area.x = ogArea.x - centerX*scale + centerX;
			area.y = ogArea.y - centerY*scale + centerY;
		} else {
			alreadyInArea = false;
			scale = 1.0f;
			area.x = ogArea.x;
			area.y = ogArea.y;
		}
	}

}
