package Main;

import Utillities.Highscore;
import Utillities.Utillities;

public class Main {

	Game game;
	Utillities util;
	Highscore highscore;

	public Main() {
		util = Utillities.getInstance();
		game = Game.getInstance();
		highscore = Highscore.getInstance();
		menu();

	}

	public void menu() {
		util.cls();
		int optMenu = game.menu();
		util.cls();
		switch (optMenu) {
		case 1:
			startGame();
			break;
		case 2:
			highScore();
			break;
		case 3:
			break;
		}
	}
	public void exit()
	{			
		System.exit(0);
	}

	public void startGame() {
		game.createNewRoom();
		game.createRestaurant();
		game.updateRoom();
		game.setRunnable(true);
		game.start(); 
		playGame();
	}

	public void playGame()
	{
		game.unpause();
		game.showStatus();
		util.nextLine();
		pauseGame();
	}
	
	public void pauseGame()
	{
		util.cls();
		game.pause();
		util.wait(1000);
		pauseMenu();
	}
	public void pauseMenu()
	{
		int opt = game.pauseMenu();
		util.cls();
		switch (opt) {
		case 1:
			playGame();
			break;
		case 2:
			upgradeRestaurant();
			break;
		case 3:
			closeBusiness();
			break;
		}
	}
	
	public void closeBusiness()
	{
		game.saveCurrentScore();
		menu();
	}
	
	public void upgradeRestaurant()
	{
		util.cls();
		int option = -1;
		System.out.println("1. Increase Restaurant's Seat");
		System.out.println("2. Hire New Employee");
		System.out.println("3. Upgrade Waiter");
		System.out.println("4. Upgrade Cook");
		System.out.println("5. Back to Pause Menu");
		do {
			System.out.print(">> ");
			option = util.nextInt();
			util.nextLine();
		} while (option < 1 || option > 5);
		util.cls();
		switch (option) {
		case 1:
			increaseSeat();
			break;
		case 2:
			hireNewEmployee();
			break;
		case 3:
			game.upgradeWaiter();
			break;
		case 4:
			game.upgradeCook();
			break;
		case 5: 
			break;
		}
		pauseMenu();
	}
	
	
	public void hireNewEmployee()
	{
		int opt;
		System.out.println("1. Waiter");
		System.out.println("2. Chef");
		do {
			System.out.print("Choose your option: ");
			opt = util.nextInt();
			util.nextLine();
		} while (opt < 1 || opt > 2);
		switch (opt) {
		case 1:
			game.hireEmployee("waiter");
			break;
		case 2:
			game.hireEmployee("chef");
			break;
		}
	}
	
	public void increaseSeat()
	{
		int seat;
		do {
			System.out.print("How many seats : ");
			seat = util.nextInt();
			util.nextLine();
		} while (seat < 1);
		game.increaseSeat(seat);
		util.nextLine();
	}
	
	
	public void highScore() {
		highscore.displayHighScore();
		System.out.println("Wanna go back ? ");
		util.nextLine();
		menu();
	}


	public static void main(String[] args) {
		new Main();
	}

}
