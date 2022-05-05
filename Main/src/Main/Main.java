package Main;

import Utillities.Utillities;

public class Main {

	Game game;
	Utillities util;

	public Main() {
		util = Utillities.getInstance();
		game = Game.getInstance();
		menu();

	}

	public void menu() {
		int optMenu = game.menu();
		switch (optMenu) {
		case 1:
			startGame();
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

	public void startGame() {
		game.createNewRoom();
		game.createRestaurant();
		game.updateRoom();
		game.start(); 
		playGame();
	}

	public void playGame()
	{
		game.unpause();
		util.nextLine();
		pauseGame();
	}
	
	public void pauseGame()
	{
		game.pause();
		int opt = game.pauseMenu();
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
		
	}
	
	public void upgradeRestaurant()
	{
		
	}
	
	public void highScore() {
		
	}

	public void exit() {

	}

	public static void main(String[] args) {
		new Main();
	}

}
