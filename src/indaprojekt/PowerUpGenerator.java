package indaprojekt;

import java.util.Random;

import org.newdawn.slick.SlickException;

public class PowerUpGenerator {
	private final int MIN_TIME = 5000; // ms
	private final int MAX_TIME = 10000; // ms
	
	private Expirer expirer;
	private Random rand;
	
	public PowerUpGenerator() {
		rand = new Random();
		expirer = new Expirer(5000);
	}
	
	private Expirer generatePowerUpTime() {
		return new Expirer(MIN_TIME + rand.nextInt(MAX_TIME-MIN_TIME));
		
	}
	
	public PowerUp generatePowerUp() throws SlickException {
		PowerUp power = null;
		if (expirer.hasExpired()) {
			power = new SpeedUp(Game.WINDOW_WIDTH/2, Game.WINDOW_HEIGHT/2, 0.3f, 4000);
			expirer = generatePowerUpTime();
		}
		return power;
	}
}
