package Main;
import Chef.Chef;
import Mediator.Room;
import User.User;
import User.UserGenerator;
import Utillities.Utillities;
import Waiter.Waiter;

public class Game extends Thread{

	private static Game gameInstance = null;
	private static boolean isPaused = false; 
	
	Utillities util = Utillities.getInstance();
	Restaurant restaurant = Restaurant.getInstance();
	UserGenerator userGenerator = UserGenerator.getInstance();

	
	
	private int initTotalChef = 2;
	private int initTotalWaiter = 2;
	
	
	public static Game getInstance()
	{
		if(gameInstance == null)
		{
			gameInstance = new Game();
		}
		return gameInstance;
	}
	
	public int menu()
	{
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
	
	public void createRestaurant()
	{
		String restaurantName;
		
		do {
			System.out.print("Input restaurant name : ");
			restaurantName = util.nextLine();
		} while (restaurantName.length() < 3 || restaurantName.length() > 15);
		
		restaurant.build(restaurantName);
		
		for(int i = 0;i < initTotalChef;i++)
		{
			restaurant.generateEmployee("chef");
		}
		for(int i = 0;i < initTotalWaiter;i++)
		{
			restaurant.generateEmployee("waiter");
		}
	}
	
	public void createNewRoom()
	{
		restaurant.createNewRoom();
	}
	
	public void updateRoom()
	{
		restaurant.updateRoom();
	}
	
	public void showStatus()
	{
		if(restaurant == null) {
			System.out.println("There's no active restaurant");
		}
//		System.out.println("Max : " + max);
//		System.out.println("User : " + restaurant.howManyUser());
//		System.out.println("Waiter : " + restaurant.howManyWaiter());
//		System.out.println("Cook : " + restaurant.howManyChef());
		System.out.println("Money : Rp. " + restaurant.getMoney());
		System.out.println("Score : " + restaurant.getScore());
		System.out.println("Size : " + restaurant.getChair());
	}
	

	public void userDoneEat(Chef c, User u)
	{
		restaurant.removeUser(u);
		c.setSkill(c.getSkill() * 30);;
	}
	
	public int pauseMenu()
	{
		
		int option;
		
		showStatus();
		System.out.println("1. Continue Business");
		System.out.println("2. Upgrade Restaurant");
		System.out.println("3. Close Business");	
		
		do {
			System.out.print(">> ");
			option = util.nextInt();
		} while (option < 1 || option > 3);
		return option;
		
	}
	int max = 0;
	public void showGameStatus()
	{
		System.out.printf("%-30s %-50s %-30s\n", "Customer", "Waiter", "Cook");
		max = util.max(restaurant.howManyWaiter(), restaurant.howManyChef(), restaurant.howManyUser());
		for(int i=0;i<max;i++)
		{
			String waiter = " ", chef = " ", user = " ";
			if(i < restaurant.howManyWaiter())
			{
				waiter = restaurant.getWaiterList().get(i).getName() +
						" " + restaurant.getWaiterList().get(i).getWaiterState().getStateName();
			} 
			if(i < restaurant.howManyWaiter())
			{
				chef = restaurant.getChefList().get(i).getName() +
						" " + restaurant.getChefList().get(i).getChefState().getStateName();
			}
			if(i < restaurant.howManyUser())
			{
				user = restaurant.getUserList().get(i).getUserName() + 
						" " + restaurant.getUserList().get(i).getUserState().getStateName();	
			}
			System.out.printf("%-30s %-50s %-30s\n",user, waiter, chef);
		}
	}
	
	
	public static boolean getPause()
	{
		return isPaused;
	}
	
	public void pause()
	{
		isPaused = true;
	}
	
	public void unpause()
	{
		isPaused = false;
	}
	
	
	
	public void run()
	{
		util.cls();
		userGenerator.start();
		
		
		while(true)
		{
			if(!isPaused)
			{
				util.wait(1000);
				util.cls();
				
//				Show Status
				showStatus();
				showGameStatus();
				
				
			}
		}
	}
	
}
