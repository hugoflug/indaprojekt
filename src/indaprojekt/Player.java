package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * Describes a player, i. e. a character that can be controlled using
 * the keyboard
 */
public class Player extends Mover
{
	private Animation activeAnimation;
	private Map<Direction, Animation> animations;
	private List<Effect> effects;
	private PlayerControls controls;
	private Projectile projectile;
	private Direction direction;
	private int lives;
	private float dx, dy;
	private float speed;
	private float friction;
	private Sound throwSound;
	
	//TEMP, should later take a bunch of animations as parameters
	//instead of just one image
	public Player(float x, float y, PlayerControls controls, Rectangle2D.Float hitBox, 
						Map<Direction, Animation> animations) throws SlickException
	{
		super(x, y, hitBox);
		this.animations = animations;
		activeAnimation = animations.get(Direction.DOWN);
		effects = new LinkedList<Effect>();
		setDirection(Direction.DOWN);
		this.controls = controls;
		lives = 5; //TEMP?
		speed = 2; //TEMP?
		throwSound = new Sound("res//sounds//gunfire.ogg");
		dx = 0;
		dy = 0;
		friction = 1f;
	}

	@Override
	public void draw() throws SlickException 
	{
		//TEMP, remove getCurrentFrame() later
		//only there to be able to use scale
		activeAnimation.draw(x, y);
	}

	@Override
	public void doLogic(Input input, int delta) throws SlickException 
	{	
		super.doLogic(input, delta);
		
    	{
	    	Iterator<Effect> iterator = effects.iterator();
	    	while (iterator.hasNext()) {
	    		Effect effect = iterator.next();
				applyEffect(effect);
				effect.doLogic();
	    		if (effect.shouldBeRemoved()) {
	    			iterator.remove();
	    		}
	    	}
    	}
		
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
		//			break;
				}
			}
    	} if (input.isKeyPressed(controls.keyThrow)) {
    		Image image = new Image("res//images//bomb.png");
    		
    		//TEMP
    		Animation anim = new Animation(new Image[]{image}, 1);
    		
    		float dx = direction.getNormalizedDX();
    		float dy = direction.getNormalizedDY(); 
    		
    		throwSound.play();
    		
    		Rectangle2D.Float projRect = new Rectangle2D.Float(0, 0, 32, 32);

    		projectile = new Projectile(projectileOriginX((float)projRect.getWidth()), 
    				projectileOriginY((float)projRect.getWidth()), dx, dy, projRect, anim);
    	} if (input.isKeyPressed(controls.keyBomb)) { //TEMP, should have a proper PlayerControls variable later
    		Image image = new Image("res//images//bomb.png");
    		
    		//TEMP
    		Animation anim = new Animation(new Image[]{image}, 1);
    		
    		float dx = direction.getNormalizedDX()*1.5f;
    		float dy = direction.getNormalizedDY()*1.5f; 
    		
    		Rectangle2D.Float bombRect = new Rectangle2D.Float(0, 0, 32, 32);
    		projectile = new Bomb(projectileOriginX((float)bombRect.getWidth()), 
    				projectileOriginY((float)bombRect.getWidth()), dx, dy, bombRect, anim);
    	}
	}
	
	/*
	 * If the player has created a projectile, returns that projectile.
	 * Otherwise returns null.
	 * Once a projectile has been returned, it is removed from the player.
	 */
	//TEMP, later to be removed
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
		if (entity instanceof Bomb) {
			
		} else if (entity instanceof Explosion) {
			lives -= 2;
	    } else if (entity instanceof Projectile) {
			lives--; 
		} else if (entity instanceof PowerUp) {
			effects.add(((PowerUp)entity).getEffect());
		} else if (entity instanceof Item) {

		} else {
			moveBack();
			dx = 0;
			dy = 0;
		}
	}
	
	@Override
	public boolean shouldBeRemoved()
	{
		return false;
	}
	
	/**
	 * @return whether the player has died
	 */
	public boolean isDead()
	{
		return lives <= 0;
	}
	
	/**
	 * @return	the amount of lives the player has
	 */
	public int getLives()
	{
		return lives;
	}
	
	/**
	 * Calculates the appropriate coordinates for the projectile to start at, according to the projectiles and the player's size.
	 * 
	 * @param prjWidth width of the projectile
	 * @return x coordinates for the projectiles start position
	 */
	private float projectileOriginX(float prjWidth) 
	{
		switch (direction) {
			case RIGHT:
				return offsetHitBox.x + (float) offsetHitBox.getWidth()+1;
			case LEFT:
				return offsetHitBox.x - prjWidth -1;
			default:
				return offsetHitBox.x;		
		}
	}
	
	/**
	 * Calculates the appropriate coordinates for the projectile to start at, according to the projectiles and the player's size.
	 * 
	 * @param prjWidth width of the projectile
	 * @return y coordinates for the projectiles start position
	 */
	private float projectileOriginY(float prjWidth) 
	{
		switch (direction) {
			case UP:
				return offsetHitBox.y - prjWidth - 1;
			case DOWN:
				return (float)(offsetHitBox.y + offsetHitBox.getHeight() + 1);
			default:
				return offsetHitBox.y;
		}		
	}
	
	/**
	 * Applies a certain effect to the player
	 */
	private void applyEffect(Effect effect)
	{
		x = effect.changeX(x);
		y = effect.changeY(y);
		dx = effect.changeDX(dx);
		dy = effect.changeDY(dy);
		speed = effect.changeSpeed(speed);
		friction = effect.changeFriction(friction);
		lives = effect.changeLives(lives);
	}

	@Override
	public Entity getEntity() 
	{
		return null;
		//TEMP
//		Entity returner = projectile;
//		projectile = null;
//		return returner;
	}
}
