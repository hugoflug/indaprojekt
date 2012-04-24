package indaprojekt;

public class LifeUpEffect extends Effect
{
	private boolean remove;
	
	public LifeUpEffect()
	{
		remove = false;
	}
	
	@Override
	public void doLogic() 
	{
		
	}
	
	public boolean shouldBeRemoved()
	{
		return remove;
	}

	public int changeLives(int lives) 
	{ 
		if (remove == true) {
			return lives;
		} else {
			remove = true;
			return lives + 1;
		}
	}
	
}
