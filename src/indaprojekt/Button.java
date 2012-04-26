package indaprojekt;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Button 
{
	public interface ActionPerformer
	{
		public void doAction() throws SlickException;
	}
	
	protected Rectangle2D.Float ogArea;
	protected Rectangle2D.Float area;
	private Image activeImage, image, mouseOverImage;
	private boolean pressed;
	private ActionPerformer action;
	protected float scale;
	
	public Button(Image image, Image mouseOverImage, Rectangle2D.Float area)
	{
		this.ogArea = new Rectangle2D.Float(area.x, area.y, area.width, area.height);
		this.area = area;
		this.image = image;
		this.mouseOverImage = mouseOverImage;
		pressed = false;
		activeImage = image;
		scale = 1.0f;
	}
	
	public void doLogic(int delta, Input input) throws SlickException 
	{
		pressed = false;
		if (area.contains(input.getMouseX(), input.getMouseY())) {
			activeImage = mouseOverImage;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				action.doAction();
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
		activeImage.draw((float)area.getX(), (float)area.getY(), scale);
	}
	
	public void setAction(ActionPerformer action)
	{
		this.action = action;
	}
}
