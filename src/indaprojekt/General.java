package indaprojekt;

public class General 
{
	/**
	 * Moves a towards zero with b units
	 */
	public static float towardsZero(float a, float b)
	{
		if (a < 0) {
			return a + b;
		} else if (a > 0) {
			return a - b;
		} else {
			return a;
		}
	}
}
