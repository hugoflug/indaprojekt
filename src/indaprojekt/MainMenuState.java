package indaprojekt;

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

	private Image startGameOption;
	private final float startGameOptionLeftBorderX = 400;
	private final float startGameOptionTopBorderY = 250;
	
	private Image exitGameOption;
	private final float exitGameOptionLeftBorderX = 0;
	private final float exitGameOptionTopBorderY = 0;
	
	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		background = new Image("res//images//bakgrund.png");
		startGameOption = new Image("res//images//play.png");
		exitGameOption = new Image("res//images//exit.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		background.draw(0, 0);
		startGameOption.draw(startGameOptionLeftBorderX,
				startGameOptionTopBorderY);
		exitGameOption.draw(exitGameOptionLeftBorderX,
				exitGameOptionTopBorderY);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			float mouseX = input.getMouseX();
			float mouseY = input.getMouseY();

			if (startIsClicked(mouseX, mouseY)) {
				game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
			} else if (exitGameOptionIsClicked(mouseX, mouseY)) {
				gc.exit();
			}
		}
	}
	
	/**
	 * 
	 * @param mouseX the x-coordinate for the mouse click.
	 * @param mouseY the y-coordinate for the mouse click.
	 * @return true if the mouse click was on the play button.
	 */
	private boolean startIsClicked(float mouseX, float mouseY) {
		return (mouseX > startGameOptionLeftBorderX && 
				mouseX < startGameOptionLeftBorderX+startGameOption.getWidth() &&
				mouseY > startGameOptionTopBorderY &&
				mouseY < startGameOptionTopBorderY+startGameOption.getHeight());
	}
	
	/**
	 * @param mouseX the x-coordinate for the mouse click.
	 * @param mouseY the y-coordinate for the mouse click.
	 * @return true if the mouse click was on the exit button.
	 */
	private boolean exitGameOptionIsClicked(float mouseX, float mouseY) {
		return (mouseX > exitGameOptionLeftBorderX && 
				mouseX < exitGameOptionLeftBorderX+exitGameOption.getWidth() &&
				mouseY > exitGameOptionTopBorderY &&
				mouseY < exitGameOptionTopBorderY+exitGameOption.getHeight());
	}

	@Override
	public int getID() {
		return stateID;
	}

}
