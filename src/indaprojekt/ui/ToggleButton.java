package indaprojekt.ui;

import java.awt.geom.Rectangle2D.Float;

import org.newdawn.slick.Image;
import org.newdawn.slick.Sound;

public class ToggleButton extends Button 
{
	private boolean toggled;
	private Image toggledImage, toggledMouseOverImage;
	private Image internalImage, internalMouseOverImage;
	
	public ToggleButton(Image image, Image mouseOverImage,
						Image toggledImage, Image toggledMouseOverImage, Float area,
						Sound hoverSound, Sound clickSound) 
	{
		super(image, mouseOverImage, area, hoverSound, clickSound);
		this.toggledImage = toggledImage;
		this.toggledMouseOverImage = toggledMouseOverImage;
		this.internalImage = image;
		this.internalMouseOverImage = mouseOverImage;
	}
	
	@Override
	protected void buttonPressed()
	{	
		toggled = !toggled;
		if (toggled) {
			image = toggledImage;
			mouseOverImage = toggledMouseOverImage;
		} else {
			image = internalImage;
			mouseOverImage = internalMouseOverImage;
		}
	}
}
