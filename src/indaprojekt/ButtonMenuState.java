package indaprojekt;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ButtonMenuState extends BasicGameState {
	private int stateID;
	
	protected Image background;
	private List<Button> buttons;
	
	public ButtonMenuState(int stateID) 
	{
		this.stateID = stateID;
		buttons = new ArrayList<Button>();
	}
	
	protected void addButton(Button button)
	{
		buttons.add(button);
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException {
		
		buttons = new ArrayList<Button>();
		background = new Image("res//images//bakgrund.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException 
	{
		background.draw(0, 0);
		
		for (Button button : buttons) {
			button.draw();
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		Input input = gc.getInput();

		for (Button button : buttons) {
			button.doLogic(delta, input);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
