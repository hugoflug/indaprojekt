package indaprojekt;

import org.newdawn.slick.Image;

/**
 * The user interface shown on the screen
 */
public class UserInterface 
{
	private int player1Lives, player2Lives;
	private Image lifeImage, noLifeImage;
	private int imageDistance;
	private int lifePos1x, lifePos1y;
	private int lifePos2x, lifePos2y;
	private int maxLives;
	
	public void setPlayer1Lives(int lives)
	{
		player1Lives = lives;
	}
	
	public void setPlayer2Lives(int lives)
	{
		player2Lives = lives;
	}
	
	public UserInterface(int lifePos1x, int lifePos1y,
						 int lifePos2x, int lifePos2y,
					 	 Image lifeImage,
					 	 Image noLifeImage,
					 	 int imageDistance,
					 	 int maxLives)
	{
		this.lifePos1x = lifePos1x;
		this.lifePos2x = lifePos2x;
		this.lifePos1y = lifePos1y;
		this.lifePos2y = lifePos2y;
		this.lifeImage = lifeImage;
		this.noLifeImage = noLifeImage;
		this.imageDistance = imageDistance;
		this.maxLives = maxLives;
		player1Lives = maxLives;
		player2Lives = maxLives;
	}		 	 
	
	public void draw()
	{
		drawLives(lifePos1x, lifePos1y, player1Lives);
		drawLives(lifePos2x, lifePos2y, player2Lives);
	}
	
	private void drawLives(int xPos, int yPos, int lives)
	{
		int i = 0;
		for (; i < lives; i++) {
			lifeImage.draw(xPos + i*(lifeImage.getWidth() + imageDistance), yPos);
		}
		
		for (; i < maxLives; i++) {
			noLifeImage.draw(xPos + i*(noLifeImage.getWidth() + imageDistance), yPos);
		}
	}
}
