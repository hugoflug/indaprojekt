package indaprojekt.ui;

import indaprojekt.general.Expirer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * A button that performs an action when you click on 
 * it with the mouse.
 *
 */
public class Button implements Comparable<Button>
{
	public interface ActionPerformer
	{
		public void doAction() throws SlickException;
	}
	
	protected Rectangle2D.Float ogArea;
	protected Rectangle2D.Float area;
	protected Image activeImage, image, mouseOverImage;
	private boolean pressed;
	private ActionPerformer action;
	protected float scale;
	private int orderingValue;
	private int ogOrderingValue;
	private Sound hoverSound, clickSound;
	private boolean alreadyInArea;
	
	public Button(Image image, Image mouseOverImage, Rectangle2D.Float area, Sound hoverSound, Sound clickSound)
	{
		this.ogArea = new Rectangle2D.Float(area.x, area.y, area.width, area.height);
		this.area = area;
		this.image = image;
		this.mouseOverImage = mouseOverImage;
		pressed = false;
		activeImage = image;
		scale = 1.0f;
		setOrderingValue(0);
		this.hoverSound = hoverSound;
		this.clickSound = clickSound;
	}
	
	public void doLogic(int delta, Input input) throws SlickException 
	{
		pressed = false;
		if (area.contains(input.getMouseX(), input.getMouseY())) {
			orderingValue = -1;
			activeImage = mouseOverImage;
			if (!alreadyInArea) {
				if (hoverSound != null) {
					hoverSound.play();
				}
				alreadyInArea = true;
			}
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				if (clickSound != null) {
					clickSound.play();
				}
				buttonPressed();
				if (action != null) {
					action.doAction();
				}
			}
		} else {
			alreadyInArea = false;
			orderingValue = ogOrderingValue;
			activeImage = image;
		}
	}
	
	protected void buttonPressed()
	{
		
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
	
	public void setOrderingValue(int value)
	{
		orderingValue = ogOrderingValue = value;
	}

	@Override
	public int compareTo(Button b) 
	{
		return b.orderingValue - orderingValue;
	}
}
