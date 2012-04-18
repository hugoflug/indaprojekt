package indaprojekt;

import java.util.HashMap;
import java.util.Map;

/**
 * Describes the keys assigned to various tasks controlling a player
 */
public class PlayerControls 
{	
	public final Map<Direction, Integer> directionMap;
	public final int keyThrow;
	public final int keyBomb;
	
	public PlayerControls(int keyUp,
						  int keyLeft,
						  int keyDown,
						  int keyRight,
						  int keyThrow,
						  int keyBomb)
	{
		directionMap = new HashMap<Direction, Integer>();
		directionMap.put(Direction.UP, keyUp);
		directionMap.put(Direction.LEFT, keyLeft);
		directionMap.put(Direction.RIGHT, keyRight);
		directionMap.put(Direction.DOWN, keyDown);
		this.keyThrow = keyThrow;
		this.keyBomb = keyBomb;
	}

}
