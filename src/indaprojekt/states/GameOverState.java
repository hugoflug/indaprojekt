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
	private int stateID;
	private Image background;
	private Image information;
	private int informationLeftBorderX;
	private int informationTopBorderY;
	private int playerWon;
	
	public GameOverState(int stateID) 
	{
		super(stateID);
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException {
		background = new Image("res//images//bakgrund.png");
		information = new Image("res//images//gameOverInformation.png");
		informationLeftBorderX = (Game.WINDOW_WIDTH/2)-(information.getWidth()/2);
		informationTopBorderY = (Game.WINDOW_HEIGHT/2)-(information.getHeight()/2);
		
//		// Information
//		Image information = new Image("res//images//gameOverInformation.png");
//		Button infoText = new Button(information, information,
//									 new Rectangle2D.Float((Game.WINDOW_WIDTH/2)-(information.getWidth()/2), (Game.WINDOW_HEIGHT/2)-(information.getHeight()/2), 
//									 information.getWidth(), information.getHeight()),
//									 null, null);
//		addButton(infoText);
//		
//		mapKey(Input.KEY_ENTER, new ActionPerformer() {
//			@Override
//			public void doAction() throws SlickException {
//				game.addState(new Game(IceIceBabyGame.GAME_PLAY_STATE, "res//maps//map1.txt"));
//				game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
//				game.enterState(IceIceBabyGame.GAME_PLAY_STATE);
//			}
//		});
//		
//		mapKey(Input.KEY_ESCAPE, new ActionPerformer() {
//			@Override
//			public void doAction() throws SlickException {
//				game.enterState(IceIceBabyGame.MAIN_MENU_STATE);
//			}
//		});
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
		
		//TEMP
//		java.awt.Font font = new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20);
//      Font unicodeFont = new UnicodeFont(font, 36, false, false);
//      g.setFont(unicodeFont);
		
		g.setColor(Color.red);
		g.drawString("Player " + playerWon + " won!!!", 430, 100);
		
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
}