package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class PlayerOne extends Player 
{

	public PlayerOne(float x, float y) throws SlickException 
	{
		super(x, y, getPlayerControls(), 
					new Rectangle2D.Float(0, 0, 48, 48),
					getAnimations());
	}
	
	private static PlayerControls getPlayerControls()
	{
		return new PlayerControls(
				Input.KEY_W,
				Input.KEY_A,
				Input.KEY_S,
				Input.KEY_D,
				Input.KEY_LCONTROL,
				Input.KEY_LSHIFT);
	}
	
	private static Map<Direction, Animation> getAnimations() throws SlickException
	{
		Map<Direction, Animation> animMap = new HashMap<Direction, Animation>();
		Color transp = Color.white;
		animMap.put(Direction.UP, new Animation(new Image[]{new Image("res//images//up1.png",transp),new Image("res//images//up2.png",transp) }, 200));
		animMap.put(Direction.RIGHT, new Animation(new Image[]{new Image("res//images//right1.png",transp),new Image("res//images//right2.png",transp)}, 200));
		animMap.put(Direction.DOWN, new Animation(new Image[]{new Image("res//images//down1.png",transp), new Image("res//images//down2.png",transp)}, 200));
		animMap.put(Direction.LEFT, new Animation(new Image[]{new Image("res//images//left1.png",transp), new Image("res//images//left2.png",transp)}, 200));
		
		return animMap;
	}
}
