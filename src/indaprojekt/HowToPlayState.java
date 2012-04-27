package indaprojekt;

import indaprojekt.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class HowToPlayState extends ButtonMenuState
{
	private final static int BACK_X = Game.WINDOW_WIDTH-230;
	private final static int BACK_Y = 50;

	private int previousStateID = 0;
	
	public HowToPlayState(int stateID, int previousStateID) {
		super(stateID);
		this.previousStateID = previousStateID;
	}
	
	
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException {
		
		super.init(gc, game);
		
		// Back
		Image backOption = new Image("res//images//back.png");
		int backW = backOption.getWidth();
		int backH = backOption.getHeight();
		Button backButton = new GrowButton(backOption, backOption, 
				new Rectangle2D.Float(BACK_X, BACK_Y, backW, backH), 
				MainMenuState.BUTTON_ENDSCALE, MainMenuState.BUTTON_SCALEMILLIS);
		backButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				game.enterState(previousStateID);
			}
		});
		addButton(backButton);
		
		// ControllerText
		Image controllers = new Image("res//images//HowToPlayControllers.png");
		Button controllerText = new Button(controllers, controllers,
				new Rectangle2D.Float(0, 0, controllers.getWidth(),
						controllers.getHeight()));
		addButton(controllerText);
	}
}
