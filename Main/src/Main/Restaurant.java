package Main;
import java.util.Vector;

import Chef.Chef;
import Employee.Employee;
import Employee.EmployeeInterface;
import User.User;
import Utillities.Utillities;
import Waiter.Waiter;

public class Restaurant {

	private Utillities util = Utillities.getInstance();
	private static Restaurant activeRestaurant;
	
//	Restaurant Component
	private int chair;
	private String name;
	private int money;
	private Vector<Waiter> waiterList = new Vector<>();
	private Vector<Chef> chefList = new Vector<>();
	private Vector<User> userList = new Vector<>();
	private int score;
		
	public void build(String name)
	{
		this.name = name;
		chair = 4;
		score = 0;
		money = 1300;
	}
	
	
	public Vector<Waiter> getWaiterList() {
		return waiterList;
	}


	public void setWaiterList(Vector<Waiter> waiterList) {
		this.waiterList = waiterList;
	}


	public Vector<Chef> getChefList() {
		return chefList;
	}


	public void setChefList(Vector<Chef> chefList) {
		this.chefList = chefList;
	}


	public Vector<User> getUserList() {
		return userList;
	}


	public void setUserList(Vector<User> userList) {
		this.userList = userList;
	}


	public void generateEmployee(String str)
	{	
		String employeeName;
		boolean isExist;
		do {			
			employeeName = util.generateInitial();
			isExist = validateIfExist(employeeName);
		} while (isExist);
		if(str.equals("chef"))
		{
			chefList.add(new Chef(employeeName));
		}
		else if(str.equals("waiter"))
		{
			waiterList.add(new Waiter(employeeName));
		}
	}
	
	public boolean validateIfExist(String initial)
	{
		for (Chef chef : chefList) {
			if(chef.getName().equals(initial))
				return true;
		}
		for (Waiter waiter : waiterList) {
			if(waiter.getName().equals(initial))
				return true;
		}
		for (User user : userList) {
			if(user.getName().equals(initial))
				return true;
		}
		return false;
	}
	
	public void newUser(User user)
	{
		userList.add(user);
	}
	
	public void done(String userInitial)
	{
		int idx = 0;
		for (User curr : userList) {
			if(curr.equals(userInitial))
			{
				userList.remove(idx);
				break;
			}
			idx += 1;
		}
	}
	
	public static Restaurant getInstance()
	{
		if(activeRestaurant == null)
		{
			activeRestaurant = new Restaurant();
		}
		return activeRestaurant;
	}
	
	public int howManyWaiter()
	{
		return waiterList.size();
	}
	public int howManyChef()
	{
		return chefList.size();
	}
	public int howManyUser()
	{
		return userList.size();
	}
	public int getChair() {
		return chair;
	}

	public void setChair(int chair) {
		this.chair = chair;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
