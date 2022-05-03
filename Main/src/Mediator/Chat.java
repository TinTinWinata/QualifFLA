package Mediator;

import java.util.Vector;

import Chef.Chef;
import Employee.Employee;
import User.User;
import Waiter.Waiter;

public class Chat extends Mediator{

	Vector<User> userList;
	Vector<Chef> chefList;
	Vector<Waiter> waiterList;
	
	public Chat()
	{
		userList = new Vector<User>();
		chefList = new Vector<Chef>();
		waiterList = new Vector<Waiter>();
	}
	

	@Override
	public void addUser(User user) {
		userList.add(user);
	}

	@Override
	public void addChef(Chef chef) {
		chefList.add(chef);
	}

	@Override
	public void addWaiter(Waiter waiter) {
		waiterList.add(waiter);
	}


	@Override
	public void sendMessage(User user, String msg) {

	}


	@Override
	public void sendMessage(Employee employee, String msg) {
		
	}

}
