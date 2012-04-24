package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 600;
	
	private List<Player> players;
	private List<Entity> entities;
	private UserInterface ui;
	private Input input;
	private Image background;
	
    public Game()
    {
        super("Awesome Game");
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
		
		Image spdUpImage = new Image("res//images//Speed.png");
		SpeedUp spdUp = new SpeedUp(spdUpImage, 300, 300, new Rectangle2D.Float(0, 0, 25, 25), 0.3f, 4000);
		entities.add(spdUp);
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException 
    {
    	players = new ArrayList<Player>(2);
    	entities = new LinkedList<Entity>();

    	ui = new DefaultUserInterface(gc.getWidth(), gc.getHeight());
    	
    	setupEntities(gc);
    	
    	input = gc.getInput();
    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException     
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
    }
 
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException 
    {
    	background.draw();
    	
    	for (Entity entity : entities) {
    		entity.draw();
    	}
    	
    	ui.draw();
    }
 
    public static void main(String[] args) throws SlickException
    {	
         AppGameContainer app = new AppGameContainer(new Game());
         app.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
         app.setVSync(true);
         app.setFullscreen(false);
         app.start();
    }	
}
