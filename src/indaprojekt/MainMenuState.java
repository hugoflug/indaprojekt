package indaprojekt;

import indaprojekt.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.StateBasedGame;

/**
 * This is the state in which you are in the main menu. From here
 * you can close the game, go to game state or the choose level state.
 *
 */
public class MainMenuState extends ButtonMenuState 
{
	private final static int START_GAME_X = 400; 
	private final static int START_GAME_Y = 250;
	private final static int EXIT_GAME_X = 0;
	private final static int EXIT_GAME_Y = 0;
	public final static float BUTTON_ENDSCALE = 1.3f;
	public final static int BUTTON_SCALEMILLIS = 75;
	
	
	public MainMenuState(int stateID) throws SlickException
	{
		super(stateID);
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException 
	{
		
		background = new Image("res//images//bakgrund.png");
		
		Image startGameOption = new Image("res//images//play.png");
		int startW = startGameOption.getWidth();
		int startH = startGameOption.getHeight();
		Button startGameButton = new GrowButton(startGameOption, 
								     startGameOption, 
								     new Rectangle2D.Float(START_GAME_X, START_GAME_Y, startW, startH),
								     BUTTON_ENDSCALE, BUTTON_SCALEMILLIS);
		
		startGameButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() throws SlickException {
				game.addState(new Game(IceIceBabyGame.GAME_PLAY_STATE, "res//maps//map1.txt"));
				game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
				game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
			}
		});
		addButton(startGameButton);
		
		Image exitGameOption = new Image("res//images//exit.png");
		int exitW = exitGameOption.getWidth();
		int exitH = exitGameOption.getHeight();
		Button exitGameButton = new GrowButton(exitGameOption, 
								    exitGameOption, 
								    new Rectangle2D.Float(EXIT_GAME_X, EXIT_GAME_Y, exitW, exitH),
								    BUTTON_ENDSCALE, BUTTON_SCALEMILLIS);
		exitGameButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				gc.exit();
			}
		});
		addButton(exitGameButton);
		
		mapKey(Input.KEY_ENTER, new ActionPerformer() {
			@Override
			public void doAction() throws SlickException {
				game.addState(new Game(IceIceBabyGame.GAME_PLAY_STATE, "res//maps//map1.txt"));
				game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
				game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
			}
		});
		
		mapKey(Input.KEY_ESCAPE, new ActionPerformer() {
			@Override
			public void doAction() {
				gc.exit();
			}
		});
		
		mapKey(Input.KEY_V, new ActionPerformer() {
			@Override
			public void doAction() throws SlickException {
				game.enterState(IceIceBabyGame.MAP_CHOOSER_STATE);
			}
		});
		
		this.setTheme(new Sound("res//sounds//theme.ogg"));
	}

}
