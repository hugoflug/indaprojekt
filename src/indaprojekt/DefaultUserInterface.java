package indaprojekt;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DefaultUserInterface extends UserInterface
{

	public DefaultUserInterface(int screenWidth, int screenHeight) throws SlickException 
	{
		super(55, 
		      55,
		      screenWidth - 235,
		      screenHeight - 87, 
		      new Image("res//images//BlueHeart.png"),
		      new Image("res//images//brokenHeart.png"),
		      new Image("res//images//OrangeHeart.png"),
		      new Image("res//images//brokenHeart.png"),
			  5,
			  5);
	}

}
