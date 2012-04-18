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
	public abstract float changeX(float x);
	public abstract float changeY(float y);
	public abstract float changeDX(float dx);
	public abstract float changeDY(float dy);
	public abstract float changeFriction(float friction);
	public abstract int changeLives(int lives);
}
