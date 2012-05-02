package indaprojekt;

import indaprojekt.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class HowToPlay2State extends ButtonMenuState {
	
	private final static int BACK_X = Game.WINDOW_WIDTH-230;
	private final static int BACK_Y = 50;
	private final static int NEXT_X = Game.WINDOW_WIDTH-170;
	private final static int NEXT_Y = 50;

	private int previousStateID;
	
	public HowToPlay2State(int stateID, int previousStateID) {
		super(stateID);
		this.previousStateID = previousStateID;
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException {
		
		super.init(gc, game);
		
		// Back/previous
		Image backOption = new Image("res//images//prevArrow.png");
		int backW = backOption.getWidth();
		int backH = backOption.getHeight();
		Button backButton = new GrowButton(backOption, backOption, 
				new Rectangle2D.Float(BACK_X, BACK_Y, backW, backH), 
				MainMenuState.BUTTON_ENDSCALE, MainMenuState.BUTTON_SCALEMILLIS);
		backButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				game.enterState(IceIceBabyGame.HOW_TO_PLAY_STATE);
			}
		});
		addButton(backButton);

		// Next
		Image nextOption = new Image("res//images//nextArrow.png");
		int nextW = nextOption.getWidth();
		int nextH = nextOption.getHeight();
		Button nextButton = new GrowButton(nextOption, nextOption, 
				new Rectangle2D.Float(NEXT_X, NEXT_Y, nextW, nextH), 
				MainMenuState.BUTTON_ENDSCALE, MainMenuState.BUTTON_SCALEMILLIS);
		nextButton.setAction(new ActionPerformer() {
			@Override
			public void doAction() {
				game.enterState(previousStateID);
			}
		});
		addButton(nextButton);

		// ControllerText
		Image goalPowerUps = new Image("res//images//HowToPlayPowerUps.png");
		Button goalPowerUpsText = new Button(goalPowerUps, goalPowerUps,
				new Rectangle2D.Float(0, 0, goalPowerUps.getWidth(),
						goalPowerUps.getHeight()));
		addButton(goalPowerUpsText);
	}


}
