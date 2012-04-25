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
	
	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		background = new Image("res//images//bakgrund.png");
		startGameOption = new Image("res//images//play.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		background.draw(0, 0);
		startGameOption.draw(startGameOptionLeftBorderX,
				startGameOptionTopBorderY);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		Input input = gc.getInput();
		float mouseX = input.getMouseX();
		float mouseY = input.getMouseY();

		if (startIsClicked(mouseX, mouseY)) {
			game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
		}
	}
	
	/**
	 * 
	 * @param mouseX the x-coordinate for the mouse click.
	 * @param mouseY the y-coordinate for the mouse click.
	 * @return
	 */
	private boolean startIsClicked(float mouseX, float mouseY) {
		return (mouseX > startGameOptionLeftBorderX && 
				mouseX < startGameOptionLeftBorderX+startGameOption.getWidth() &&
				mouseY > startGameOptionTopBorderY &&
				mouseY < startGameOptionTopBorderY+startGameOption.getHeight());
			
	}

	@Override
	public int getID() {
		return stateID;
	}

}
