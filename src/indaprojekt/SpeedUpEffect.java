package indaprojekt;

/**
 * An effect speeding up a Player a certain amount
 * for a certain time
 *
 *	(Not yet functional - this turned out to be a hard way to do things...)
 */
public class SpeedUpEffect extends Effect
{
	private float speedDiff;
	private int millis;
	private Expirer lifetime;
	private boolean activated;
	
	private boolean apply, deapply;
	
	public SpeedUpEffect(float speedDiff, int millis)
	{
		super();
		
		this.speedDiff = speedDiff;
		this.millis = millis;
		activated = false;
		apply = false;
		deapply = false;
	}

	@Override
	public void doLogic() 
	{
		if (!activated) {
			activated = true;
			lifetime = new Expirer(millis);
			apply = true;
		}
		
		if (lifetime.hasExpired()) {
			deapply = true;
		}
	}

	@Override
	public float changeSpeed(float speed) 
	{
		if (apply) {
			apply = false;
			return speed + speedDiff;
		} else if (deapply) {
			deapply = false;
			remove = true;
			return speed - speedDiff;
		} else {
			return speed;
		}
	}
}
