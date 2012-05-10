package indaprojekt.states;

import indaprojekt.IceIceBabyGame;
import indaprojekt.ui.Button;
import indaprojekt.ui.GrowButton;
import indaprojekt.ui.ToggleButton;
import indaprojekt.ui.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.StateBasedGame;

public class PauseState extends ButtonMenuState {

	private final int MIDDLE_X = Game.WINDOW_WIDTH/2;
	private int pauseTextY = 50;
	private int resumeGameY = 200;
	private int mainMenuY = 300;
	private int howToPlayY = 400;
		
	public PauseState(int stateID) {
		super(stateID);
	}

	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException 
	{
		
		Sound hoverSound = new Sound("res//sounds//click.ogg");
		Sound clickSound = new Sound("res//sounds//click.ogg");
		
		//background is in ButtonMenuState
		background = new Image("res//images//bakgrund.png");
		
		// Resume button:
		Image resumeOption = new Image("res//images//resumeGame.png");
		int resumeGameX = MIDDLE_X - (resumeOption.getWidth()/2);
		int resumeW = resumeOption.getWidth();
		int resumeH = resumeOption.getHeight();
		Button resumeButton = new GrowButton(resumeOption, resumeOption,
				new Rectangle2D.Float(resumeGameX, resumeGameY, resumeW, resumeH),
				MainMenuState.BUTTON_ENDSCALE, MainMenuState.BUTTON_SCALEMILLIS,
				hoverSound, clickSound);
		
		resumeButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
			}
		});
		addButton(resumeButton);

		Image pauseImage = new Image("res//images//pause.png");
		int pauseTextX = MIDDLE_X - (pauseImage.getWidth()/2);
		Button pauseText = new Button(pauseImage, pauseImage, 
				new Rectangle2D.Float(pauseTextX, pauseTextY, 
						pauseImage.getWidth(), pauseImage.getHeight()), hoverSound, clickSound);
		addButton(pauseText);
		
		// Main menu button.
		Image mainMenuImage = new Image("res//images//mainMenu.png");
		int mainMenuX = MIDDLE_X - (mainMenuImage.getWidth()/2);
		Button mainMenuButton = new GrowButton(mainMenuImage, mainMenuImage,
				new Rectangle2D.Float(mainMenuX, mainMenuY,
						mainMenuImage.getWidth(), mainMenuImage.getHeight()),
						MainMenuState.BUTTON_ENDSCALE, MainMenuState.BUTTON_SCALEMILLIS,
						hoverSound, clickSound);
		mainMenuButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				game.enterState(IceIceBabyGame.MAIN_MENU_STATE);
			}
		});
		addButton(mainMenuButton);
		
		// How-to-play button
		Image howToPlayImage = new Image("res//images//howToPlay.png");
		int howToPlayX = MIDDLE_X - (howToPlayImage.getWidth()/2);
		Button howToPlayButton = new GrowButton(howToPlayImage, howToPlayImage,
						new Rectangle2D.Float(howToPlayX, howToPlayY, 
						howToPlayImage.getWidth(), howToPlayImage.getHeight()), 
						MainMenuState.BUTTON_ENDSCALE, MainMenuState.BUTTON_SCALEMILLIS,
						hoverSound, clickSound);
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
								    	    new Rectangle2D.Float(MainMenuState.SOUND_X, MainMenuState.SOUND_Y, soundW, soundH),
								    	    hoverSound, clickSound);
		
		soundGameButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				boolean soundsOn = gc.isSoundOn() && gc.isMusicOn();
				gc.setMusicOn(!soundsOn);
				gc.setSoundOn(!soundsOn);
			}
		});
		addButton(soundGameButton);
	}
}
