package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Describes the actual game.
 */
public class Game extends BasicGameState
{
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 600;
	
	private List<Player> players;
	private List<Entity> entities;
	private UserInterface ui;
	private Input input;
	private Image background;
	private PowerUpGenerator powerUpGenerator;
	private int stateID;
	
    public Game(int stateID)
    {
        this.stateID = stateID;
    }
    
    /**
     * Sets up and adds all the entities of the map to the game
     */
    private void setupEntities(GameContainer container) throws SlickException
    {	
		entities = MapLoader.loadEntities("res//maps//map1.txt", new Image("res//images//isbit.png"));
    	
    	Player player1 = new PlayerOne(50, 50);
		players.add(player1);
		entities.add(player1);
		
		Player player2 = new PlayerTwo(900, 500);
		players.add(player2);
		entities.add(player2);
		
		background = new Image("res//images//bakgrund.png");
		
		Image itemImage = new Image("res//images//bomb2.png");
		Item item = new Item(itemImage, 250, 250, new Rectangle2D.Float(0, 0, 25, 25));
		entities.add(item);
		
		SpeedUp spdUp = new SpeedUp(300, 300, 0.3f, 4000);
		entities.add(spdUp);
		
		LifeUp lifeUp = new LifeUp(350, 300);
		entities.add(lifeUp);
    }
 
    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException 
    {
    	players = new ArrayList<Player>(2);
    	entities = new LinkedList<Entity>();
    	powerUpGenerator = new PowerUpGenerator();

    	ui = new DefaultUserInterface(gc.getWidth(), gc.getHeight());
    	
    	setupEntities(gc);
    	
    	input = gc.getInput();
    }
 
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException     
    {
    	for (Entity entity : entities) {
    		entity.doLogic(input, delta);
    	}
    	
    	{
	    	Iterator<Player> iterator = players.iterator();
	    	while (iterator.hasNext()) {
	    		Player player = iterator.next();
	    		if (player.isDead()) {
	    			iterator.remove();
	    			entities.remove(player);
	    			game.enterState(IceIceBabyGame.GAME_OVER_STATE);
	    		}
	    	}
    	}
    	
    	for (Entity entity : entities) {
    		for (Entity entity2 : entities) {
    			if (entity != entity2) {
    				if (entity.isCollision(entity2)) {
    					entity.handleCollision(entity2);
    				}
    			}
    		}
    	}
    	
    	{
    		List<Entity> toAdd = new LinkedList<Entity>();
    		Entity spawn = null;
	    	Iterator<Entity> iterator = entities.iterator();
	    	while (iterator.hasNext()) {
	    		Entity entity = iterator.next();
	    		spawn = entity.spawnEntity();
	    		if (spawn != null) {
	    			toAdd.add(spawn);
	    		}
	    		if (entity.shouldBeRemoved()) {
	    			iterator.remove();
	    		}
	    	}
	    	for (Entity e : toAdd) {
	    		entities.add(e);
	    	}
    	}

    	ui.setPlayer1Lives(players.get(0).getLives());
    	
    	if (players.size() >= 2) {
    		ui.setPlayer2Lives(players.get(1).getLives());
    	}
    	
    	PowerUp powerUp = powerUpGenerator.generatePowerUp();
    	if (powerUp != null) {
    		entities.add(powerUp);
    	}
    }
 
    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException 
    {
    	background.draw();
    	
    	for (Entity entity : entities) {
    		entity.draw();
    	}
    	
    	ui.draw();
    }

	@Override
	public int getID() {
		return stateID;
	}
}
