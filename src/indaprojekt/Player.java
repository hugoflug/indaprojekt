package indaprojekt;

import java.awt.geom.Rectangle2D;
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
	private int lives;
	private float dx, dy;
	private float speed;
	private float friction;
	
	//TEMP, should later take a bunch of animations as parameters
	//instead of just one image
	public Player(float x, float y, PlayerControls controls, Rectangle2D.Float hitBox, Map<Direction, Animation> animations) throws SlickException
	{
		super(x, y, hitBox);
		this.animations = animations;
		activeAnimation = animations.get(Direction.DOWN);
		setDirection(Direction.DOWN);
		this.controls = controls;
		lives = 5; //TEMP?
		speed = 2; //TEMP?
		dx = 0;
		dy = 0;
		friction = 1;
	}

	@Override
	public void draw() throws SlickException 
	{
		//TEMP, remove getCurrentFrame() later
		//only there to be able to use scale
		activeAnimation.getCurrentFrame().draw(x, y, 0.1f);
	}

	@Override
	public void doLogic(Input input, int delta) throws SlickException 
	{	
		super.doLogic(input, delta);
		
		move(dx, dy);
		
		dx = General.towardsZero(dx, friction);
		dy = General.towardsZero(dy, friction);
		
		for (Direction dir : Direction.values()) {
			Integer key = controls.directionMap.get(dir);
			if (key != null) {
				if (input.isKeyDown(key)) {
					setDirection(dir);
		//			move(dir.getNormalizedDX()*(delta/2), dir.getNormalizedDY()*(delta/2));
					dx += dir.getNormalizedDX()*speed;
					dy += dir.getNormalizedDY()*speed;
				}
			}
    	} if (input.isKeyPressed(controls.keyThrow)) {
    		Image image = new Image("res//bomb.png");
    		
    		//TEMP
    		Animation anim = new Animation(new Image[]{image}, 1);
    		
    		float dx = direction.getNormalizedDX();
    		float dy = direction.getNormalizedDY(); 
    		
    		Rectangle2D.Float projRect = new Rectangle2D.Float(0, 0, 10, 10);
    		projectile = new Projectile(x + 50, y + 50, dx, dy, projRect, anim);
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

	@Override
	public void handleCollision(Entity entity) 
	{
		if (entity instanceof Projectile) {
			lives--;
		} else {
			if (hasMoved()) {
				moveBack();
			}
		}
	}
	
	/**
	 * @return whether the player has died
	 */
	public boolean isDead()
	{
		return lives <= 0;
	}
}
