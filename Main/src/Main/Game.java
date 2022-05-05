package Main;

import Chef.Chef;
import Mediator.Room;
import User.User;
import User.UserGenerator;
import Utillities.Highscore;
import Utillities.Utillities;
import Waiter.Waiter;

public class Game extends Thread {

	private static Game gameInstance = null;
	private static boolean isPaused = false;

	Utillities util = Utillities.getInstance();
	Restaurant restaurant = Restaurant.getInstance();
	UserGenerator userGenerator = UserGenerator.getInstance();
	Highscore highscore = Highscore.getInstance();

	private int initTotalChef = 4;
	private int initTotalWaiter = 2;
	private boolean runnable;

	public static Game getInstance() {
		if (gameInstance == null) {
			gameInstance = new Game();
		}
		return gameInstance;
	}

	public void setRunnable(Boolean bool)
	{
		 this.runnable = bool;
	}
	
	public int menu() {
		int option;
		System.out.println("1. Play New Restaurant");
		System.out.println("2. High Score");
		System.out.println("3. Exit");
		do {
			option = util.nextInt();
			util.nextLine();
		} while (option < 1 || option > 3);
		return option;
	}

	public void createRestaurant() {
		String restaurantName;

		do {
			System.out.print("Input restaurant name : ");
			restaurantName = util.nextLine();
		} while (restaurantName.length() < 3 || restaurantName.length() > 15);

		restaurant.build(restaurantName);

		for (int i = 0; i < initTotalChef; i++) {
			restaurant.generateEmployee("chef");
		}
		for (int i = 0; i < initTotalWaiter; i++) {
			restaurant.generateEmployee("waiter");
		}
	}

	public void createNewRoom() {
		restaurant.createNewRoom();
	}

	public void updateRoom() {
		restaurant.updateRoom();
	}

	public void showStatus() {
		if (restaurant == null) {
			System.out.println("There's no active restaurant");
		}
//		System.out.println("Paused : " + this.getPause());
		System.out.println("Money : Rp. " + restaurant.getMoney());
		System.out.println("Score : " + restaurant.getScore());
		System.out.println("Size : " + restaurant.getChair());
	}

	public void userDoneEat(Chef c, User u) {
		restaurant.removeUser(u);
		c.setSkill(c.getSkill() * 30);
		
	}

	public int pauseMenu() {
		int option;

		showStatus();
		System.out.println("1. Continue Business");
		System.out.println("2. Upgrade Restaurant");
		System.out.println("3. Close Business");

		do {
			System.out.print(">> ");
			option = util.nextInt();
			util.nextLine();
		} while (option < 1 || option > 3);
		return option;

	}

	int max = 0;

	public void showGameStatus() {
		System.out.printf("%-30s %-50s %-30s\n", "Customer", "Waiter", "Cook");
		max = util.max(restaurant.howManyWaiter(), restaurant.howManyChef(), restaurant.howManyUser());
		for (int i = 0; i < max; i++) {
			String waiter = " ", chef = " ", user = " ";
			if (i < restaurant.howManyWaiter()) {
				waiter = restaurant.getWaiterList().get(i).getName() + " "
						+ restaurant.getWaiterList().get(i).getWaiterState().getStateName();
			}
			if (i < restaurant.howManyChef()) {
				chef = restaurant.getChefList().get(i).getName() + " "
						+ restaurant.getChefList().get(i).getChefState().getStateName();
			}
			if (i < restaurant.howManyUser()) {
				user = restaurant.getUserList().get(i).getUserName() + " "
						+ restaurant.getUserList().get(i).getUserState().getStateName();
			}
			System.out.printf("%-30s %-50s %-30s\n", user, waiter, chef);
		}
	}

	public static boolean getPause() {
		return isPaused;
	}

	public void pause() {
		isPaused = true;
	}

	public void unpause() {
		isPaused = false;
	}

	public void reset()
	{
		runnable = false;
	}
	
	public void run() {
		util.cls();
		userGenerator.start();
		
		while (runnable) {
			util.wait(100);
			if (!isPaused) {
				util.wait(1000);
				util.cls();
				showStatus();
				showGameStatus();
				checkUserTolerance();
			}
		}
	}
	
	public void upgradeWaiter()
	{
		int num = 1;
		for (Waiter curr : restaurant.getWaiterList()) {
			System.out.printf("%-2d %-10s\n", num, curr.getName());
			num += 1;
		}
		int opt;
		do {
			System.out.print("Input number of waiter to update : ");
			opt = util.nextInt();
			util.nextLine();
		} while (opt < 0 || opt > restaurant.howManyWaiter());
		if(opt == 1)
		{
			return;
		}
		opt -= 1;
		
		int inputSpeed;
		do {
			System.out.print("Input speed [maximum speed 5] : ");
			inputSpeed = util.nextInt();
			util.nextLine();
		} while (inputSpeed < 1);
		
		int price = inputSpeed * 150;
		if(restaurant.getMoney() < price)
		{
			System.out.println("You don't have enough price");
			return;
		}
		
		restaurant.getWaiterList().get(opt).setSpeed(restaurant.getWaiterList().get(opt).getSpeed() + inputSpeed);
		System.out.println("Succesfully increased Speed");
		restaurant.setMoney(restaurant.getMoney() - price);
		
		if(restaurant.getWaiterList().get(opt).getSpeed() > 5)
		{
			restaurant.getWaiterList().get(opt).setSpeed(5);
			System.out.println("Max speed only 5");
		}
	}
	
	public void upgradeCook()
	{
		int num = 1;
		for (Chef curr : restaurant.getChefList()) {
			System.out.printf("%-2d %-10s\n", num, curr.getName());
			num += 1;
		}
		int opt;
		do {
			System.out.print("Input number of chef to update : ");
			opt = util.nextInt();
			util.nextLine();
		} while (opt < 0 || opt > restaurant.howManyChef());
		if(opt == 1)
		{
			return;
		}
		opt -= 1;
		
		System.out.println("Choose attribute to upgrade : ");
		System.out.println("1. Skill");
		System.out.println("2. Speed");
		
		int attributeOption;
		do {
			attributeOption = util.nextInt();
			util.nextLine();
		} while (attributeOption < 0);
		
		if(attributeOption == 0)
			return;
		switch (attributeOption) {
		case 1:
			int inputSkill;
			do {
				System.out.print("Input speed [maximum speed 5] : ");
				inputSkill = util.nextInt();
				util.nextLine();
			} while (inputSkill < 1);
			
			int price = inputSkill * 150;
			if(restaurant.getMoney() < price)
			{
				System.out.println("You don't have enough price");
				return;
			}
			
			restaurant.getChefList().get(opt).setSkill(restaurant.getChefList().get(opt).getSkill() + inputSkill);
			System.out.println("Succesfully increased Skill");
			restaurant.setMoney(restaurant.getMoney() - price);
			
			if(restaurant.getChefList().get(opt).getSkill() > 5)
			{
				restaurant.getChefList().get(opt).setSkill(5);
				System.out.println("Max skill only 5");
			}
			break;
		case 2:
			int inputSpeed;
			do {
				System.out.print("Input speed [maximum speed 5] : ");
				inputSpeed = util.nextInt();
				util.nextLine();
			} while (inputSpeed < 1);
			
			int speedPrice = inputSpeed * 150;
			if(restaurant.getMoney() < speedPrice)
			{
				System.out.println("You don't have enough price");
				return;
			}
			
			restaurant.getChefList().get(opt).setSpeed(restaurant.getChefList().get(opt).getSpeed() + inputSpeed);
			System.out.println("Succesfully increased Speed");
			restaurant.setMoney(restaurant.getMoney() - speedPrice);
			
			if(restaurant.getChefList().get(opt).getSpeed() > 5)
			{
				restaurant.getChefList().get(opt).setSpeed(5);
				System.out.println("Max speed only 5");
			}
			break;
		}
	}
	
	
	public void increaseSeat(int increasedSeat)
	{
		int price = increasedSeat * 100;
		if(price > restaurant.getMoney())
		{
			System.out.println("You don't had enough money!");
			return;
		}
		
		if(restaurant.getChair() == 7)
		{
			System.out.println("You already get maximum chair");
			return;
		}
		
		restaurant.setChair(restaurant.getChair() + increasedSeat);
		System.out.println("Succesfully increase seat!");
		restaurant.setMoney(restaurant.getMoney() - price);
		if(restaurant.getChair() > 7)
		{
			restaurant.setChair(7);
			System.out.println("Max chair only 7");
		}
	}
	public void hireEmployee(String str)
	{
		if(str == "waiter")
		{			
			if(restaurant.howManyWaiter() == 7)
			{
				System.out.println("Max Waiter is 7");
				return;
			}
			int price = restaurant.howManyWaiter() * 150;
			restaurant.generateEmployee("waiter");
			restaurant.setMoney(restaurant.getMoney() - price);
			System.out.println("Sucessfully added waiter!");
			
		} else if (str == "chef")
		{
			if(restaurant.howManyChef() == 7)
			{
				System.out.println("Max Chef is 7");
				return;
			}
			int price = restaurant.howManyChef() * 200;
			restaurant.setMoney(restaurant.getMoney() - price);
			restaurant.generateEmployee("chef");
			System.out.println("Sucessfully added chef!");
		}

	}
	
	
	
	public void saveCurrentScore()
	{
		highscore.setCurrentScore(restaurant.getName(), restaurant.getScore());
	}

	public void checkUserTolerance() {
		int deletedIdx = -1;
		
		for(int i =0;i < restaurant.getUserLength();i++)
		{
			if(restaurant.getUserList().get(i).getTolerance() <= 0)
			{
				deletedIdx = i;
			}
		}
		
		if(deletedIdx != -1)
		{
//			restaurant.removeUser(restaurant.getUserList().get(deletedIdx));
		}
	}

}
