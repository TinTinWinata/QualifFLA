package Mediator;

import java.util.Vector;

import Chef.Chef;
import Employee.Employee;
import User.User;
import Waiter.Waiter;

public class Room extends Mediator{

	Vector<User> userList;
	Vector<Chef> chefList;
	Vector<Waiter> waiterList;
	
	public Room()
	{
		userList = new Vector<User>();
		chefList = new Vector<Chef>();
		waiterList = new Vector<Waiter>();
	}
	

	@Override
	public void addUser(User user) {
		for (User currUser : userList) {
			if(user.equals(currUser))
			{
				return;
			}
		}
		userList.add(user);
	}
	@Override
	
	public void removeUser(User user) {
		if(userList.contains(user))
		{			
			userList.remove(user);
		}
	}
	
	@Override
	public void addChef(Chef chef) {
		for (Chef currChef : chefList) {
			if(chef.equals(currChef))
			{
				return;
			}
		}
		chefList.add(chef);
	}

	@Override
	public void addWaiter(Waiter waiter) {
		for (Waiter currWaiter : waiterList) {
			if(waiter.equals(currWaiter))
			{
				return;
			}
		}
		waiterList.add(waiter);
	}


	@Override
	public void sendChefSignal(User user, String msg) {
		for (Chef chef : chefList) {
			chef.recieveSignal(user, msg);
		}
	}

	

	@Override
	public void sendUserSignal(Employee employee, String msg) {
		for (User user : userList) {
			user.recieveSignal(employee, msg);
		}
	}


	@Override
	public void sendWaiterSignal(User user, String msg) {
		for (Waiter waiter : waiterList) {
			waiter.recieveSignal(user, msg);
		}
	}


	@Override
	public void sendChefSignal(Waiter waiter, String msg) {
		for(Chef chef : chefList)
		{
			 chef.recieveSignal(waiter, msg);
		}
	}

	
	
	@Override
	public void sendWaiterSignal(Chef chef, String msg) {
		for (Waiter waiter : waiterList) {
			waiter.recieveSignal(chef, msg);
		}
	}


	@Override
	public void sendWaiterServingFoodSignal(Chef chef, User user, String msg) {
		for (Waiter waiter : waiterList) {
			waiter.recieveServingFoodSignal(chef, user, msg);
		}
		
	}



	
}
