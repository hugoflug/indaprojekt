package indaprojekt;

import indaprojekt.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends ButtonMenuState {
	private final int START_GAME_X = 400; 
	private final int START_GAME_Y = 250;
	private final int EXIT_GAME_X = 0;
	private final int EXIT_GAME_Y = 0;
	
	public MainMenuState(int stateID) throws SlickException
	{
		super(stateID);
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException {
		
		background = new Image("res//images//bakgrund.png");
		
		Image startGameOption = new Image("res//images//play.png");
		int startW = startGameOption.getWidth();
		int startH = startGameOption.getHeight();
		Button startGameButton = new Button(startGameOption, 
								     startGameOption, 
								     new Rectangle2D.Float(START_GAME_X, START_GAME_Y, startW, startH));
		
		startGameButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				game.addState(new Game(IceIceBabyGame.GAME_PLAY_STATE));
				try {
					game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
				} catch (SlickException e) {
					System.err.println("Error on init new game.");
				}
				game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
			}
		});
		addButton(startGameButton);
		
		Image exitGameOption = new Image("res//images//exit.png");
		int exitW = exitGameOption.getWidth();
		int exitH = exitGameOption.getHeight();
		Button exitGameButton = new Button(exitGameOption, 
								    exitGameOption, 
								    new Rectangle2D.Float(EXIT_GAME_X, EXIT_GAME_Y, exitW, exitH));
		exitGameButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				gc.exit();
			}
		});
		addButton(exitGameButton);
		
		mapKey(Input.KEY_ENTER, new ActionPerformer() {
			@Override
			public void doAction() {
				game.addState(new Game(IceIceBabyGame.GAME_PLAY_STATE));
				try {
					game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
				} catch (SlickException e) {
					System.err.println("Error on init new game.");
				}
				game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
			}
		});
		
		mapKey(Input.KEY_ESCAPE, new ActionPerformer() {
			@Override
			public void doAction() {
				gc.exit();
			}
		});
	}

}
