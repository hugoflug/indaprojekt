package indaprojekt.states;

import indaprojekt.IceIceBabyGame;
import indaprojekt.ui.Button;
import indaprojekt.ui.GrowButton;
import indaprojekt.ui.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.StateBasedGame;

public class MapChooserState extends ButtonMenuState 
{
	private static float BUTTON_ENDSCALE = 1.2f;
	private static int BUTTON_SCALEMILLIS = 70;

	public MapChooserState(int stateID) 
	{
		super(stateID);
	}
	
	private int centralize(int i, int max, int size)
	{
		if (i == 0) {
			return 0;
		} else if (i == max) {
			return size;
		} else {
			return size/2;
		}
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException
	{
		background = new Image("res//images//bakgrund.png");
		Sound hoverSound = new Sound("res//sounds//click.ogg");
		Sound clickSound = new Sound("res//sounds//click.ogg");
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Image levelImage = new Image("res//images//map" + getMap(j, i, 3) + ".png");
				Image levelImageHover = new Image("res//images//map" + getMap(j, i, 3) + ".png");
				Rectangle2D.Float area = new Rectangle2D.Float(i*333, j*200, 333, 200);
				
				int centerX = centralize(i, 2, levelImage.getWidth());
				int centerY = centralize(j, 2, levelImage.getHeight());
				
				Button levelButton = new GrowButton(levelImage, levelImage, area, //levelImageHover second arg?
									 BUTTON_ENDSCALE, BUTTON_SCALEMILLIS, centerX, centerY, hoverSound, clickSound);
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
//		return 1;
		return y + x*width + 1;
	}
	
}
