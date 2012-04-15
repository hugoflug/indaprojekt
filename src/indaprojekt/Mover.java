package indaprojekt;

/**
 * A class representing any physical object capable of moving
 * in the game
 *
 */
public abstract class Mover extends Entity
{
	public Mover(float x, float y) {
		super(x, y);
	}
	
	/**
	 * Moves this object by the specified x-distance and y-distance
	 * @param dx	the x-distance to move the Mover
	 * @param dy	the y-distance to move the Mover
	 */
	protected void move(float dx, float dy)
	{
		this.x += dx;
		this.y += dy;
	}
}
