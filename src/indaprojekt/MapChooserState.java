package indaprojekt;

import indaprojekt.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MapChooserState extends ButtonMenuState 
{

	public MapChooserState(int stateID) 
	{
		super(stateID);
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException
	{
		background = new Image("res//images//bakgrund.png");
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Image levelImage = new Image("res//images//map" + getMap(j, i, 3) + ".png");
				Image levelImageHover = new Image("res//images//map" + getMap(j, i, 3) + "h" + ".png");
				Rectangle2D.Float area = new Rectangle2D.Float(i*333, j*200, 333, 200);
				Button levelButton = new Button(levelImage, levelImageHover, area);
				
				final int x = j;
				final int y = i;
				levelButton.setAction(new ActionPerformer() {
					@Override
					public void doAction() throws SlickException {
						game.addState(new Game(IceIceBabyGame.GAME_PLAY_STATE, "res//maps//map" + getMap(x, y, 3) + ".txt"));
						game.getState(IceIceBabyGame.GAME_PLAY_STATE).init(gc, game);
						game.enterState(IceIceBabyGame.GAME_PLAY_STATE);	
					}
				});
				
				addButton(levelButton);
			}
		}
	}
	
	private int getMap(int x, int y, int width) 
	{
		return y + x*width + 1;
	}
	
}
