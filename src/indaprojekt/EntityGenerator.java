package indaprojekt;

import indaprojekt.entities.DefaultBomb;
import indaprojekt.entities.Entity;
import indaprojekt.entities.LifeUp;
import indaprojekt.entities.PowerUp;
import indaprojekt.entities.SpeedUp;
import indaprojekt.general.Expirer;
import indaprojekt.states.Game;

import java.util.Random;

import org.newdawn.slick.SlickException;

public class EntityGenerator {
	private final int MIN_TIME = 2000; // ms
	private final int MAX_TIME = 10000; // ms
	private final boolean GENERATE_BOMBS = false;
	
	private Expirer expirer;
	private Random rand;
	
	public EntityGenerator() 
	{
		rand = new Random();
		expirer = new Expirer(5000);
	}
	
	private Expirer generatePowerUpTime() 
	{
		return new Expirer(MIN_TIME + rand.nextInt(MAX_TIME-MIN_TIME));
		
	}
	
	public Entity generateEntity() throws SlickException 
	{
		Entity entity = null;
		if (expirer.hasExpired()) {
			
			int entities;
			if (GENERATE_BOMBS) {
				entities = 3;
			} else {
				entities = 2;
			}
			int chooseEntity = rand.nextInt(entities);

			switch(chooseEntity) {
			case 0:
				entity = new SpeedUp(rand.nextFloat()*Game.WINDOW_WIDTH,
						rand.nextFloat()*Game.WINDOW_HEIGHT, 0.2f, 4000);
				break;
			case 1:
				entity = new LifeUp(rand.nextFloat()*Game.WINDOW_WIDTH,
						rand.nextFloat()*Game.WINDOW_HEIGHT);
				break;
			case 2:
				entity = new DefaultBomb(rand.nextFloat()*Game.WINDOW_WIDTH,
										 rand.nextFloat()*Game.WINDOW_HEIGHT,
										 0,
										 0);
				
			}
			expirer = generatePowerUpTime();
		}
		return entity;
	}
}
