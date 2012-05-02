package indaprojekt;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A game state with some more advanced features
 *
 */

public abstract class AdvancedGameState extends BasicGameState
{
	private Music theme;
	
	@Override
	public void leave(GameContainer gc, StateBasedGame game)
	{
		if (theme != null) {
			theme.stop();
		}
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame game)
	{
		if (theme != null) {
			theme.loop();
		}
	}
	
	/**
	 * Sets the theme song of this game state
	 * @param theme
	 */
	protected void setTheme(Music theme)
	{
		this.theme = theme;
	}
}
