package indaprojekt;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {
	private int stateID;
	Image background;
	Image information;
	
	public GameOverState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		background = new Image("res//images//bakgrund.png");
//		information = new Image("res//images//gameOverInformation");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		background.draw(0, 0);
		information.draw(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
		} else if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			game.enterState(IceIceBabyGame.MAIN_MENU_STATE);
		}
		
	}

	@Override
	public int getID() {
		return stateID;
	}
}
