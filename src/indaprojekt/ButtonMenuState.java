package indaprojekt;

import indaprojekt.Button.ActionPerformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The general properties for a menu with buttons.
 *
 */
public abstract class ButtonMenuState extends AdvancedGameState
{	
	protected Image background;
	private List<Button> buttons;
	private Map<Integer, ActionPerformer> keyMap;
	
	public ButtonMenuState(int stateID) 
	{
		super(stateID);
		buttons = new ArrayList<Button>();
		keyMap = new HashMap<Integer, ActionPerformer>();
	}
	
	protected void addButton(Button button)
	{
		buttons.add(button);
	}

	
	protected void mapKey(int key, ActionPerformer action)
	{
		keyMap.put(key, action);
	}
	
	@Override
	public void init(final GameContainer gc, final StateBasedGame game)
			throws SlickException 
	{
		background = new Image("res//images//bakgrund.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException 
	{
		background.draw(0, 0);
		
		Collections.sort(buttons);
		
		for (Button button : buttons) {
			button.draw();
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException 
	{
		Input input = gc.getInput();

		for (Button button : buttons) {
			button.doLogic(delta, input);
		}
		
		for (Integer i : keyMap.keySet()) {
			if (input.isKeyPressed(i)) {
				keyMap.get(i).doAction();
			}
		}
	}

}
