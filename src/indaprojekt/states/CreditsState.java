package indaprojekt.states;

import java.awt.geom.Rectangle2D;

import indaprojekt.IceIceBabyGame;
import indaprojekt.ui.ScrollingText;
import indaprojekt.ui.Button.ActionPerformer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CreditsState extends ButtonMenuState
{
	private ScrollingText scroller;

	public CreditsState(int stateID) 
	{
		super(stateID);
	}

	@Override
	public void init(GameContainer gc, final StateBasedGame game) throws SlickException 
	{
		scroller = new ScrollingText(new Rectangle2D.Float(Game.WINDOW_WIDTH/2, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT),
									 getCreditsString(),
									 gc.getGraphics().getFont(),
									 true,
									 0.1f);
		
		mapKey(Input.KEY_ESCAPE, new ActionPerformer() {
			@Override
			public void doAction() {
				game.enterState(IceIceBabyGame.MAIN_MENU_STATE);
			}
		});
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException 
	{
		super.render(gc, game, g);
		scroller.draw(g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException 
	{
		super.update(gc, game, delta);
		scroller.doLogic(delta);
	}
	
	private static String getCreditsString()
	{
		return "Game Design\n"+
			   "-----\n" +
			   "Hugo Sandelius\n" +
			   "Johan Bissmark\n" +
			   "Katja Röös\n" + 
			   "\n\n" +
			   "Programming\n" +
			   "-----\n" +
			   "Hugo Sandelius\n" +
			   "Johan Bissmark\n" +
			   "Katja Röös\n" +
			   "\n\n" +
			   "Art\n" +
			   "-----\n" +
			   "Johan Bissmark\n" +
			   "Katja Röös\n";
	}
	
}
