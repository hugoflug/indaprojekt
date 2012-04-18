package indaprojekt;

/**
 * An effect affecting a Player, e. g. higher Speed, more life, etc.
 *
 */
public abstract class Effect 
{
	protected boolean remove;
	
	public Effect()
	{
		remove = false;
	}
	
	/*
	 * Whether the Effect should be removed from the player
	 */
	public boolean shouldBeRemoved()
	{
		return remove;
	}
	
	/*
	 * Do internal logic
	 */
	public abstract void doLogic();
	
	/*
	 * Change the following player properties from input according to the effect
	 */
	public float changeSpeed(float speed) { return speed; }
	public float changeX(float x) { return x; };
	public float changeY(float y) { return y; };
	public float changeDX(float dx) { return dx; };
	public float changeDY(float dy) { return dy; };
	public float changeFriction(float friction) { return friction; };
	public int changeLives(int lives) { return lives; };
}
