package indaprojekt;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * This is the main class that controls everything. In here are all
 * the different states of the game.
 *
 */
public class IceIceBabyGame extends StateBasedGame
{
	public static final int MAIN_MENU_STATE = 0;
	public static final int GAME_PLAY_STATE = 1;
	public static final int GAME_OVER_STATE = 2;
	public static final int     PAUSE_STATE = 3;
	public static final int MAP_CHOOSER_STATE = 4;
	public static final int HOW_TO_PLAY_STATE = 5;
	public static final int HOW_TO_PLAY_2_STATE = 6;
	
	public IceIceBabyGame() throws SlickException 
	{
		super("Ice Ice Baby");
		
		this.addState(new MainMenuState(MAIN_MENU_STATE));
		this.addState(new Game(GAME_PLAY_STATE, "res//maps//map1.txt"));
		this.addState(new GameOverState(GAME_OVER_STATE));
		this.addState(new PauseState(PAUSE_STATE));
		this.addState(new MapChooserState(MAP_CHOOSER_STATE));
		this.addState(new HowToPlayState(HOW_TO_PLAY_STATE, MAIN_MENU_STATE));
		this.addState(new HowToPlay2State(HOW_TO_PLAY_2_STATE, MAIN_MENU_STATE));
		this.enterState(MAIN_MENU_STATE);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException 
	{
//		this.getState(MAIN_MENU_STATE).init(container, this);
//		this.getState(GAME_PLAY_STATE).init(container, this);
//		this.getState(GAME_OVER_STATE).init(container, this);
//		this.getState(PAUSE_STATE).init(container, this);
//		this.getState(MAP_CHOOSER_STATE).init(container, this);
//		this.getState(HOW_TO_PLAY_STATE).init(container, this);
	}
	
    public static void main(String[] args) throws SlickException
    {		
         AppGameContainer app = new AppGameContainer(new IceIceBabyGame());
         app.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
         app.setVSync(true);
         app.setFullscreen(false);
         app.setShowFPS(false);
         app.setIcon("res//images//icon.png");
         app.start();
    }

}
