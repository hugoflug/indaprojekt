package indaprojekt.states;

import java.awt.geom.Rectangle2D;

import indaprojekt.IceIceBabyGame;
import indaprojekt.ui.Button;
import indaprojekt.ui.Button.ActionPerformer;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The state that will run when a player has died. From here you 
 * can play again or go to the main menu.
 *
 */

public class GameOverState extends ButtonMenuState 
{
	private final float PLAYER_WON_Y = 80;
	private final float INFORMATION_Y = 170;
	private Button playerWonButton;
	
	public GameOverState(int stateID) 
	{
		super(stateID);
	}

	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException 
	{
		background = new Image("res//images//bakgrund.png");
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
			public void doAction() throws SlickException {
				game.enterState(IceIceBabyGame.MAIN_MENU_STATE);
			}
		});
	}
	
	public void setPlayerWon(int playerWon) throws SlickException 
	{
		if (playerWonButton != null) {
			removeButton(playerWonButton);
		}
		
		// Information
		Image playerWonImage;
		if (playerWon == 1) {
			playerWonImage = new Image("res//images//player1won.png");
		} else {
			playerWonImage = new Image("res//images//player2won.png");
		}
		playerWonButton = new Button(playerWonImage, playerWonImage,
									 		new Rectangle2D.Float(MainMenuState.MIDDLE_X-(playerWonImage.getWidth()/2), PLAYER_WON_Y, 
									 		playerWonImage.getWidth(), playerWonImage.getHeight()),
									 		null, null);
		addButton(playerWonButton);
	}
}
