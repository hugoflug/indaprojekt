package indaprojekt;

import indaprojekt.entities.LifeUp;
import indaprojekt.entities.PowerUp;
import indaprojekt.entities.SpeedUp;
import indaprojekt.general.Expirer;
import indaprojekt.states.Game;

import java.util.Random;

import org.newdawn.slick.SlickException;

public class PowerUpGenerator {
	private final int MIN_TIME = 2000; // ms
	private final int MAX_TIME = 10000; // ms
	
	private Expirer expirer;
	private Random rand;
	
	public PowerUpGenerator() 
	{
		rand = new Random();
		expirer = new Expirer(5000);
	}
	
	private Expirer generatePowerUpTime() 
	{
		return new Expirer(MIN_TIME + rand.nextInt(MAX_TIME-MIN_TIME));
		
	}
	
	public PowerUp generatePowerUp() throws SlickException 
	{
		PowerUp power = null;
		if (expirer.hasExpired()) {
			// TODO - the powerUps can end up anywhere, but if they hit an 
			// obstacle, they will disappear immediately, but will be 
			// visible for 1/FPS seconds.
			int choosePower = rand.nextInt(2);

			switch(choosePower) {
			case 0:
				power = new SpeedUp(rand.nextFloat()*Game.WINDOW_WIDTH,
						rand.nextFloat()*Game.WINDOW_HEIGHT, 0.2f, 4000);
				break;
			default:
				power = new LifeUp(rand.nextFloat()*Game.WINDOW_WIDTH,
						rand.nextFloat()*Game.WINDOW_HEIGHT);
				break;
				
			}
			expirer = generatePowerUpTime();
		}
		return power;
	}
}
