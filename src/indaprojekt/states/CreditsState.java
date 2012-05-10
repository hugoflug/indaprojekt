package indaprojekt.states;

import java.awt.geom.Rectangle2D;

import indaprojekt.ui.ScrollingText;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CreditsState extends AdvancedGameState
{
	private ScrollingText scroller;

	public CreditsState(int stateID) 
	{
		super(stateID);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException 
	{
		scroller = new ScrollingText(new Rectangle2D.Float(Game.WINDOW_WIDTH/2, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT),
									 getCreditsString(),
									 gc.getGraphics().getFont(),
									 true,
									 0.1f);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException 
	{
		scroller.draw(g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException 
	{
		scroller.doLogic(delta);
	}
	
	private static String getCreditsString()
	{
		return "Game Designer	\n" +
			   "Jewgoe\n" +
			   "\n" +
			   "Stuff Goes Here\n" +
			   "Here goes more stuff\n";
	}
	
}
