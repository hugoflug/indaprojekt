package indaprojekt;

/**
 * An effect speeding up a Player a certain amount
 * for a certain time
 *
 */
public class SpeedUpEffect extends Effect
{
	private float speedDiff;
	private int millis;
	private Expirer lifetime;
	private boolean activated;
	
	public SpeedUpEffect(float speedDiff, int millis)
	{
		super();
		
		this.speedDiff = speedDiff;
		this.millis = millis;
		activated = false;
	}

	@Override
	public void doLogic() 
	{
		if (!activated) {
			activated = true;
			lifetime = new Expirer(millis);
		}
		
		if (lifetime.hasExpired()) {
			remove = true;
		}
	}

	@Override
	public float changeX(float x) 
	{
		return 0;
	}

	@Override
	public float changeY(float y) 
	{
		return 0;
	}

	@Override
	public float changeDX(float dx) 
	{
		return 0;
	}

	@Override
	public float changeDY(float dy) 
	{
		return 0;
	}

	@Override
	public float changeFriction(float friction) 
	{
		return 0;
	}

	@Override
	public int changeLives(int lives) 
	{
		return 0;
	}

}
