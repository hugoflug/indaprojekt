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

public class PlayerTwo extends Player 
{

	public PlayerTwo(float x, float y) throws SlickException 
	{
		super(x, y, getPlayerControls(), 
					new Rectangle2D.Float(0, 0, 48, 48),
					getAnimations(),
					5,
					0.75f);
	}
	
	private static PlayerControls getPlayerControls()
	{
		return new PlayerControls(
				Input.KEY_UP,
				Input.KEY_LEFT,
				Input.KEY_DOWN,
				Input.KEY_RIGHT,
				Input.KEY_L,
				Input.KEY_K);
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