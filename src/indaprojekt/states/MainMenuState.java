package indaprojekt.states;

import indaprojekt.IceIceBabyGame;
import indaprojekt.ui.Button;
import indaprojekt.ui.GrowButton;
import indaprojekt.ui.ToggleButton;
import indaprojekt.ui.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * This is the state in which you are in the main menu. From here
 * you can close the game, go to game state or the choose level state.
 *
 */
public class MainMenuState extends ButtonMenuState 
{
	private final static int MIDDLE_X = Game.WINDOW_WIDTH/2;
//	private final static int START_GAME_X = 400; 
	private final static int START_GAME_Y = 200;
	private final static int EXIT_GAME_X = Game.WINDOW_WIDTH-150;
	private final static int EXIT_GAME_Y = Game.WINDOW_HEIGHT-100;
//	private final static int HOW_TO_PLAY_X = 450;
	private final static int HOW_TO_PLAY_Y = 450;
	private final static int SOUND_X = 50;
	private final static int SOUND_Y = Game.WINDOW_HEIGHT-100;
	private final static int CHOOSE_MAP_Y = 350;
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
		
		// Ice Ice Baby Text
		Image iceIceBaby = new Image("res//images//iceIceBaby.png");
		Button iceIceBabyText = new Button(iceIceBaby, iceIceBaby,
				new Rectangle2D.Float(0, 0, iceIceBaby.getWidth(),
						iceIceBaby.getHeight()));
		addButton(iceIceBabyText);
		
		
		// Play
		Image startGameOption = new Image("res//images//play.png");
		int startW = startGameOption.getWidth();
		int startH = startGameOption.getHeight();
		int startGameX = MIDDLE_X - (startGameOption.getWidth()/2);
		Button startGameButton = new GrowButton(startGameOption, 
								     			startGameOption, 
								     			new Rectangle2D.Float(startGameX, START_GAME_Y, startW, startH),
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
		
		// Exit
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
		
		// How to play
		Image howToPlayOption = new Image("res//images//howToPlay.png");
		int howToW = howToPlayOption.getWidth();
		int howToH = howToPlayOption.getHeight();
		int howToPlayX = MIDDLE_X - (howToPlayOption.getWidth()/2);
		Button howToPlayButton = new GrowButton(howToPlayOption, 
								     howToPlayOption, 
								     new Rectangle2D.Float(howToPlayX, HOW_TO_PLAY_Y, howToW, howToH),
								     BUTTON_ENDSCALE, BUTTON_SCALEMILLIS);
		
		howToPlayButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() throws SlickException {
				game.addState(new HowToPlayState(IceIceBabyGame.HOW_TO_PLAY_STATE, getID()));
				game.getState(IceIceBabyGame.HOW_TO_PLAY_STATE).init(gc, game);
				game.enterState(IceIceBabyGame.HOW_TO_PLAY_STATE);
			}
		});
		addButton(howToPlayButton);

		// Sound on/off
		Image soundOption = new Image("res//images//sound.gif");
		Image soundOffOption = new Image("res//images//soundoff.png");
		int soundW = soundOption.getWidth();
		int soundH = soundOption.getHeight();
		Button soundGameButton = new ToggleButton(soundOption, 
								    	    soundOption, 
								    	    soundOffOption,
								    	    soundOffOption,
								    	    new Rectangle2D.Float(SOUND_X, SOUND_Y, soundW, soundH));
		
		soundGameButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				boolean soundsOn = gc.isSoundOn() && gc.isMusicOn();
				gc.setMusicOn(!soundsOn);
				gc.setSoundOn(!soundsOn);
			}
		});
		addButton(soundGameButton);
		
		//choose map
		Image chooseMap = new Image("res//images//chooseLevel.png");
		int chooseW = chooseMap.getWidth();
		int chooseH = soundOption.getHeight();
		int chooseMapX = MIDDLE_X - (chooseMap.getWidth()/2);
		Button chooseMapButton = new GrowButton(chooseMap, 
								    	    	chooseMap, 
								    	    	new Rectangle2D.Float(chooseMapX, CHOOSE_MAP_Y, chooseW, chooseH),
								    	    	BUTTON_ENDSCALE, BUTTON_SCALEMILLIS);
		
		chooseMapButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				game.enterState(IceIceBabyGame.MAP_CHOOSER_STATE);
			}
		});
		addButton(chooseMapButton);

		// Pressed key
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

		this.setTheme(new Music("res//sounds//iceicebegin.ogg", true));
	}

}
