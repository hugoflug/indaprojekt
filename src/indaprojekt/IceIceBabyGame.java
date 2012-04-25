package indaprojekt;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class IceIceBabyGame extends StateBasedGame{
	public static final int MAIN_MENU_STATE = 0;
	public static final int GAME_PLAY_STATE = 1;
	
	public IceIceBabyGame() {
		super("Ice Ice Baby");
		
		this.addState(new MainMenuState(MAIN_MENU_STATE));
		this.addState(new Game(GAME_PLAY_STATE));
		this.enterState(MAIN_MENU_STATE);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(MAIN_MENU_STATE).init(container, this);
		this.getState(GAME_PLAY_STATE).init(container, this);
	}
	
    public static void main(String[] args) throws SlickException
    {	
         AppGameContainer app = new AppGameContainer(new IceIceBabyGame());
         app.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
         app.setVSync(true);
         app.setFullscreen(false);
         app.setShowFPS(false);
         app.start();
    }

}
