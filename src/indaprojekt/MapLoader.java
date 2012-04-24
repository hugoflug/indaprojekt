package indaprojekt;

import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MapLoader 
{
	public static List<Entity> loadEntities(String filename, Image obstacleImage)
	{
		List<Entity> entities = new LinkedList<Entity>();
		int errCode = 0;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filename));
			String line;
			int row = 0;
			while ((line = in.readLine()) != null) {
				for (int col = 0; col < line.length(); col++) {
					char c = line.trim().charAt(col);
					if (c == 'x') {
						entities.add(new Obstacle(col*obstacleImage.getWidth(), row*obstacleImage.getHeight(), 
								new Rectangle2D.Float(0, 0, obstacleImage.getWidth(), obstacleImage.getHeight()), 
								new Animation(new Image[]{obstacleImage}, 1)));
					}
				}
				row++;					
			}
		} catch (IOException e) {
			System.err.println("Couldn't load file " + filename);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				System.err.println("Couldn't close file " + filename);
			}
		}
		return entities;
	}
}
