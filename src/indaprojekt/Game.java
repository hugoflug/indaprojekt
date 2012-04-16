package indaprojekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Describes the actual game.
 */
public class Game extends BasicGame
{
	private List<Player> players;
	private List<Projectile> projectiles;
	private Input input;
	private Image background;
	
    public Game()
    {
        super("Awsome Game");
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException 
    {
    	players = new ArrayList<Player>(2);
    	projectiles = new LinkedList<Projectile>();
    	
    	//TEMP.
    	PlayerControls player1Controls = new PlayerControls(
											Input.KEY_W,
											Input.KEY_A,
											Input.KEY_S,
											Input.KEY_D,
											Input.KEY_Q);
    	Image player1Image = new Image("res//player.png");
    	Map<Direction, Animation> animMap1 = new HashMap<Direction, Animation>();
    	animMap1.put(Direction.UP, new Animation(new Image[]{player1Image}, 1));
    	animMap1.put(Direction.UPRIGHT, new Animation(new Image[]{player1Image}, 1));
    	animMap1.put(Direction.RIGHT, new Animation(new Image[]{player1Image}, 1));
    	animMap1.put(Direction.DOWNRIGHT, new Animation(new Image[]{player1Image}, 1));
    	animMap1.put(Direction.DOWN, new Animation(new Image[]{player1Image}, 1));
    	animMap1.put(Direction.DOWNLEFT, new Animation(new Image[]{player1Image}, 1));
    	animMap1.put(Direction.LEFT, new Animation(new Image[]{player1Image}, 1));
    	animMap1.put(Direction.UPLEFT, new Animation(new Image[]{player1Image}, 1));
    	players.add(new Player(50, 50, player1Controls, animMap1));
    	
    	
    	//TEMP
    	PlayerControls player2Controls = new PlayerControls(
    										Input.KEY_UP,
    										Input.KEY_LEFT,
    										Input.KEY_DOWN,
    										Input.KEY_RIGHT,
    										Input.KEY_RCONTROL);
    	Image player2Image = new Image("res//player2.png");
    	Map<Direction, Animation> animMap2 = new HashMap<Direction, Animation>();
    	animMap2.put(Direction.UP, new Animation(new Image[]{player2Image}, 1));
    	animMap2.put(Direction.UPRIGHT, new Animation(new Image[]{player2Image}, 1));
    	animMap2.put(Direction.RIGHT, new Animation(new Image[]{player2Image}, 1));
    	animMap2.put(Direction.DOWNRIGHT, new Animation(new Image[]{player2Image}, 1));
    	animMap2.put(Direction.DOWN, new Animation(new Image[]{player1Image}, 1));
    	animMap2.put(Direction.DOWNLEFT, new Animation(new Image[]{player2Image}, 1));
    	animMap2.put(Direction.LEFT, new Animation(new Image[]{player2Image}, 1));
    	animMap2.put(Direction.UPLEFT, new Animation(new Image[]{player2Image}, 1));
    	players.add(new Player(150, 150, player2Controls, animMap2));
    	background = new Image("res//classroom.png");
    	
    	
    	input = gc.getInput();
    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException     
    {
    	for (Player player : players) {
    		player.doLogic(input, delta);
    	}
    	
    	for (Projectile proj : projectiles) {
    		proj.doLogic(delta);
    	}
    	
    	//for each player, if the player have thrown a projectile,
    	//add it to the projectile list
    	for (Player player : players) {
    		Projectile proj = player.getProjectile();
    		if (proj != null) {
    			projectiles.add(proj);
    		}
    	}
    }
 
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException 
    {
    	background.draw();	
    	for (Player player : players) {
    		player.draw();
    	}
    	for (Projectile proj : projectiles) {
    		proj.draw();
    	}
    }
 
    public static void main(String[] args) throws SlickException
    {
         AppGameContainer app = new AppGameContainer(new Game());
         app.setDisplayMode(800, 600, false);
         app.setVSync(true);
         app.start();
    }	
}
