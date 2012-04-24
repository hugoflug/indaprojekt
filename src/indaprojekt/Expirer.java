package indaprojekt;

/**
 * Something that expires after x time
 *
 */
public class Expirer 
{
	private Timer timer;
	private int expireTime;
	
	/**
	 * @param millis after how long should this Expirer expire?
	 */
	public Expirer(int millis)
	{
		timer = new Timer();
		timer.start();
		expireTime = millis;
	}
	
	/**
	 * @return whether the Expirer has expired or not
	 */
	public boolean hasExpired()
	{
		return timer.milliseconds() >= expireTime;
	}
}
