package Main;
import java.util.Vector;

import Chef.Chef;
import Mediator.Room;
import User.User;
import Utillities.Utillities;
import Waiter.Waiter;
import oracle.jrockit.jfr.ActiveRecordingEvent;

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
	
	
	RestaurantState state;
	Room room;
	
	public void addMoney(int addedMoney)
	{
		money += addedMoney;
	}
	
	public void addScore(int addedScore)
	{
		score += addedScore;
	}
	
	public int howManyEmployee()
	{
		return howManyChef() + howManyUser();
	}
	
	public void build(String name)
	{
		this.name = name;
		chair = 4;
		score = 0;
		money = 1300;
		state = new ActiveState(this);
	}
	
	public int getUserLength()
	{
		return userList.size();
	}
	
	public void createNewRoom()
	{
		room = new Room();
	}
	
	
	public void updateRoom()
	{
		if(room == null)
		{
			System.out.println("Please create a room first before update");
			return;
		}
		
		for (Chef chef : chefList) {
			chef.joinRoom(room);
//			System.out.println(chef.getName() + " chef join room!");
		}
		for (Waiter waiter : waiterList) {
			waiter.joinRoom(room);
//			System.out.println(waiter.getName() + " waiter join room!");
		}
		for (User user : userList) {
			user.joinRoom(room);
//			System.out.println(user.getName() + " user join room!");
		}
	}
	
	public Chef findChef(String initial)
	{
		for (Chef chef : chefList) {
			if(chef.getName().equals(initial))
				return chef;
		}
		return null;
	}
	public User findUser(String name)
	{
		for (User user : userList) {
			if(user.getUserName().equals(name))
			{
				return user;
			}
		}
		return null;
	}
	
	public void removeUser(User u)
	{
		if(userList.contains(u))
		{			
			room.removeUser(u);
			userList.remove(u);
		}
	}
	
	public boolean ifUserExist(User user)
	{
		for (User currUser : userList) {
			if(currUser.getUserName().equals(user.getUserName()))
				return true;
		}
		return false;
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
			if(user.getUserName().equals(initial))
				return true;
		}
		return false;
	}
	
	public void newUser(User user)
	{
		user.joinRoom(this.room);
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
