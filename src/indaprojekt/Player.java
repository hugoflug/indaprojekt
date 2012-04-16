package indaprojekt;

import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Describes a player, i. e. a character that can be controlled using
 * the keyboard
 */
public class Player extends Mover
{
	private Animation activeAnimation;
	private Map<Direction, Animation> animations;
	private PlayerControls controls;
	private Projectile projectile;
	private Direction direction;
	
	//TEMP, should later take a bunch of animations as parameters
	//instead of just one image
	public Player(float x, float y, PlayerControls controls, Map<Direction, Animation> animations) throws SlickException
	{
		super(x, y);
		
		this.animations = animations;
		
		activeAnimation = animations.get(Direction.DOWN);
		
		setDirection(Direction.DOWN);
		
		this.controls = controls;
	}

	@Override
	public void draw() throws SlickException 
	{
		//TEMP, remove getCurrentFrame() later
		//only there to be able to use scale
		activeAnimation.getCurrentFrame().draw(x, y, 0.1f);
	}
	
	/**
	 * Does internal logic things, to be called each update
	 * @param input		a reference to an Input object, describing input
	 * @throws SlickException
	 */
	public void doLogic(Input input, int delta) throws SlickException 
	{	
		for (Direction dir : Direction.values()) {
			Integer key = controls.directionMap.get(dir);
			if (key != null) {
				if (input.isKeyDown(key)) {
					setDirection(dir);
					move(dir.getNormalizedDX()*(delta/2), dir.getNormalizedDY()*(delta/2));
				}
			}
    	} if (input.isKeyPressed(controls.keyThrow)) {
    		Image image = new Image("res//bomb.png");
    		
    		//TEMP
    		Animation anim = new Animation(new Image[]{image}, 1);
    		
    		float dx = direction.getNormalizedDX();
    		float dy = direction.getNormalizedDY(); 
    		
    		projectile = new Projectile(x, y, dx, dy, anim);
    	}
	}
	
	/*
	 * If the player has created a projectile, returns that projectile.
	 * Otherwise returns null.
	 * Once a projectile has been returned, it is removed from the player.
	 */
	public Projectile getProjectile()
	{
		Projectile returnProjectile = projectile;
		projectile = null;
		return returnProjectile;
	}
	
	private void setDirection(Direction direction)
	{
		activeAnimation = animations.get(direction);
		this.direction = direction;
	}
}
