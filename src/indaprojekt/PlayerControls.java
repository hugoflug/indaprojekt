package indaprojekt;

/**
 * Describes the keys assigned to various tasks controlling a player
 */
public class PlayerControls 
{	
	public final int keyDown;
	public final int keyLeft;
	public final int keyRight;
	public final int keyUp;
	public final int keyThrow;
	
	public PlayerControls(int keyUp,
						  int keyLeft,
						  int keyDown,
						  int keyRight,
						  int keyThrow)
	{
		this.keyDown = keyDown;
		this.keyLeft = keyLeft;
		this.keyRight = keyRight;
		this.keyUp = keyUp;
		this.keyThrow = keyThrow;
	}

}
