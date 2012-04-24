package indaprojekt;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * A class describing things laying on the ground for the player to pick up
 */
public class Item extends Entity 
{
	private boolean remove;
	private Image image;
	
	public Item(Image image, float x, float y, Rectangle2D.Float hitBox) 
	{
		super(x, y, hitBox);
	
		this.image = image;
		remove = false;
	}

	@Override
	public void draw() throws SlickException 
	{
		image.draw(x, y);
	}

	@Override
	public void handleCollision(Entity entity) 
	{
		if (entity instanceof Projectile) {
		} else {
			remove = true;
		}
	}
	
	@Override
	public boolean shouldBeRemoved()
	{
		return remove;
	}

	@Override
	public void doLogic(Input input, int delta) 
	{
		
	}

	@Override
	public Entity spawnEntity() 
	{
		return null;
	}

}
