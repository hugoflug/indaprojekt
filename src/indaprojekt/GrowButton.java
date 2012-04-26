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
	
	public GrowButton(Image image, Image mouseOverImage, Float area, float endScale, int scaleMillis) 
	{
		super(image, mouseOverImage, area);
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
			area.x = ogArea.x - (ogArea.width*scale)/2 + ogArea.width/2;
			area.y = ogArea.y - (ogArea.height*scale)/2 + ogArea.height/2;
		} else {
			alreadyInArea = false;
			scale = 1.0f;
			area.x = ogArea.x;
			area.y = ogArea.y;
		}
	}

}
