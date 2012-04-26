package indaprojekt;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The state that will run when a player has died. From here you 
 * can play again or go to the main menu.
 *
 */
public class GameOverState extends BasicGameState {
	private int stateID;
	private Image background;
	private Image information;
	private int informationLeftBorderX;
	private int informationTopBorderY;
	private int playerWon;
	
	public GameOverState(int stateID) 
	{
		this.stateID = stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		background = new Image("res//images//bakgrund.png");
		information = new Image("res//images//gameOverInformation.png");
		informationLeftBorderX = (Game.WINDOW_WIDTH/2)-(information.getWidth()/2);
		informationTopBorderY = (Game.WINDOW_HEIGHT/2)-(information.getHeight()/2);
	}
	
	public void setPlayerWon(int playerWon) 
	{
		this.playerWon = playerWon;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException 
	{
		background.draw(0, 0);
		information.draw(informationLeftBorderX, informationTopBorderY);
		
		g.drawString("Player " + playerWon + " won!!!!!1", 0, 0);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			game.addState(new Game(IceIceBabyGame.GAME_PLAY_STATE, "res//maps//map1.txt"));
			game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
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
