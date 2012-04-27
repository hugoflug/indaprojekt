package indaprojekt;

import java.awt.geom.Rectangle2D;
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
					0.10f); //0.15f
	}
	
	private static Player.Controls getPlayerControls()
	{
		return new Player.Controls(
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
		animMap.put(Direction.UP, new Animation(new Image[]{new Image("res//images//man2-up-leftFoot.png",transp),new Image("res//images//man2-up-rightFoot.png",transp) }, 200));
		animMap.put(Direction.RIGHT, new Animation(new Image[]{new Image("res//images//man2-right-leftFoot.png",transp),new Image("res//images//man2-right-rightFoot.png",transp)}, 200));
		animMap.put(Direction.DOWN, new Animation(new Image[]{new Image("res//images//man2-down-leftFoot.png",transp), new Image("res//images//man2-down-rightFoot.png",transp)}, 200));
		animMap.put(Direction.LEFT, new Animation(new Image[]{new Image("res//images//man2-left-leftFoot.png",transp), new Image("res//images//man2-left-rightFoot.png",transp)}, 200));
		
		return animMap;
	}
}