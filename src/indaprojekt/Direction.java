package indaprojekt;

public enum Direction 
{	
	UP(0, -1),
	UPRIGHT((float)Math.sqrt(2)/2, (float)-Math.sqrt(2)/2),
	RIGHT(1, 0),
	DOWNRIGHT((float)Math.sqrt(2)/2, (float)Math.sqrt(2)/2),
	DOWN(0, 1),
	DOWNLEFT((float)-Math.sqrt(2)/2, (float)Math.sqrt(2)/2),
	LEFT(-1, 0),
	UPLEFT((float)-Math.sqrt(2)/2, (float)-Math.sqrt(2)/2);
	private float dx, dy;
	
	private Direction(float dx, float dy)
	{
		this.dx = dx;
		this.dy = dy;
	}
	
	public float getNormalizedDX()
	{
		return dx;
	}
	
	public float getNormalizedDY()
	{
		return dy;
	}
}
