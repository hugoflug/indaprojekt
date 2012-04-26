package indaprojekt;

import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {
	private int stateID;
	
	private Image background;

	private final float startGameOptionLeftBorderX = 400;
	private final float startGameOptionTopBorderY = 250;
	private final float exitGameOptionLeftBorderX = 0;
	private final float exitGameOptionTopBorderY = 0;
	
	private List<Button> buttons;
	private Button startGameButton;
	private Button exitGameButton;
	
	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		
		buttons = new ArrayList<Button>();
		
		Image background = new Image("res//images//bakgrund.png");
		Image startGameOption = new Image("res//images//play.png");
		Image exitGameOption = new Image("res//images//exit.png");
		
		int startW = startGameOption.getWidth();
		int startH = startGameOption.getHeight();
		startGameButton = new Button(startGameOption, 
								     startGameOption, 
								     new Rectangle2D.Float(400, 250, startW, startH));
		buttons.add(startGameButton);
		
		int exitW = exitGameOption.getWidth();
		int exitH = exitGameOption.getHeight();
		exitGameButton = new Button(exitGameOption, 
								    exitGameOption, 
								    new Rectangle2D.Float(0, 0, exitW, exitH));
		buttons.add(exitGameButton);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException 
	{
		background.draw(0, 0);
		
		for (Button button : buttons) {
			button.draw();
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		Input input = gc.getInput();

		for (Button button : buttons) {
			button.doLogic(delta, input);
		}
		
		if (startGameButton.isPressed()) {
			game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
		} else if (exitGameButton.isPressed()) {
			gc.exit();
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
