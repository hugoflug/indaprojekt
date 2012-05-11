package indaprojekt.ui;

import indaprojekt.ui.Button.ActionPerformer;

import java.awt.geom.Rectangle2D;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * A class for ScrollingText
 * (doesn't currently work as intended, always scrolls from top and width is ignored)
 *
 */
public class ScrollingText 
{
	private final Rectangle2D.Float area;
	private final String[] lines;
	private float yPos;
	private float scrollSpeed;
	private Font font;
	private ActionPerformer finishPerformer;
	
	public ScrollingText(Rectangle2D.Float area, String text, Font font, boolean centerText, float scrollSpeed)
	{
		this.area = area;
		this.scrollSpeed = scrollSpeed;
		this.font = font;
		lines = text.split("\n");
		yPos = area.y + area.height;
	}
	
	public void doLogic(int delta) throws SlickException 
	{
		yPos -= scrollSpeed*delta;
		
		if (yPos + lines.length*font.getLineHeight() < area.y) {
			if (finishPerformer != null) {
				finishPerformer.doAction();
			}
		}
	}
	
	public void draw(Graphics g)
	{
		g.setFont(font);
		for (int i = 0; i < lines.length; i++) {
			float x = area.x - font.getWidth(lines[i])/2;
			g.drawString(lines[i], x, yPos + i*font.getLineHeight());
		}
	}
	
	public void setFinishAction(ActionPerformer performer)
	{
		finishPerformer = performer;
	}
}
