package indaprojekt;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;


public class Button 
{
	public interface ActionPerformer
	{
		public void doAction();
	}
	
	private Rectangle2D.Float area;
	private Image activeImage, image, mouseOverImage;
	private boolean pressed;
	private ActionPerformer action;
	
	public Button(Image image, Image mouseOverImage, Rectangle2D.Float area)
	{
		this.area = area;
		this.image = image;
		this.mouseOverImage = mouseOverImage;
		pressed = false;
		activeImage = image;
	}
	
	public void doLogic(int delta, Input input) 
	{
		pressed = false;
		if (area.contains(input.getMouseX(), input.getMouseY())) {
			activeImage = mouseOverImage;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				action.doAction();
		//		pressed = true;
			}
		} else {
			activeImage = image;
		}
	}
	
	public boolean isPressed()
	{
		return pressed;
	}
	
	public void draw()
	{
		activeImage.draw((float)area.getX(), (float)area.getY());
	}
	
	public void setAction(ActionPerformer action)
	{
		this.action = action;
	}
}
