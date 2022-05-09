package User;

import Main.Game;
import Main.Restaurant;
import Utillities.Utillities;

public class UserGenerator extends Thread {

	Restaurant restaurant = Restaurant.getInstance();
	Utillities util = Utillities.getInstance();

	private static UserGenerator userGeneratorInstance;
	private boolean pause = true;

	public void notifyStart() {
		this.start();
	}

	public static UserGenerator getInstance() {
		if (userGeneratorInstance == null) {
			userGeneratorInstance = new UserGenerator();
		}
		return userGeneratorInstance;
	}

	public void run() {
		try {
			while (true) {
				util.wait(1000);
				if (!Game.getPause() && restaurant.getChair() > restaurant.howManyUser()) {
					int randVal = util.rand(100);
					if (randVal < 25) {
						User u = new User(util.generateInitial());
						u.setTolerance(10);
						restaurant.newUser(u);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception!");
		}
	}

}
