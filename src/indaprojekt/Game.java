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
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Describes the actual game.
 */
public class Game extends AdvancedGameState
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
	private String mapFilename;
	
    public Game(int stateID, String filename)
    {
    	super(stateID);
        this.stateID = stateID;
        this.mapFilename = filename;
    }
    
    /**
     * Sets up and adds all the entities of the map to the game
     */
    private void setupEntities(GameContainer container) throws SlickException
    {	
		entities = MapLoader.loadEntities(mapFilename, new Image("res//images//isbit.png"));
    	
    	Player player1 = new PlayerOne(50, 50);
		players.add(player1);
		entities.add(player1);
		
		Player player2 = new PlayerTwo(900, 500);
		players.add(player2);
		entities.add(player2);
		
		background = new Image("res//images//bakgrund.png");
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
    	
    	
    	gc.setSoundVolume(0.5f);
		this.setTheme(new Music("res//sounds//iceiceend.ogg", true));
    }
 
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException     
    {
    	for (Entity entity : entities) {
    		entity.doLogic(input, delta);
    	}
    	
    	{
    		int i = 0;
	    	Iterator<Player> iterator = players.iterator();
	    	while (iterator.hasNext()) {
	    		i++;
	    		Player player = iterator.next();
	    		if (player.isDead()) {
	    			iterator.remove();
	    			entities.remove(player);
					game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
					((GameOverState)(game.getState(IceIceBabyGame.GAME_OVER_STATE))).setPlayerWon(i);
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
    	
    	if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
    		game.enterState(IceIceBabyGame.PAUSE_STATE);
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
    
    public String getMapName()
    {
    	return mapFilename;
    }

	@Override
	public int getID() {
		return stateID;
	}
}
