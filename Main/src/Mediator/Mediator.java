package Mediator;

import Chef.Chef;
import Employee.Employee;
import User.User;
import Waiter.Waiter;

public abstract class Mediator {
	public abstract void sendMessage(User user, String msg);
	public abstract void sendMessage(Employee employee, String msg);
	public abstract void addUser(User user);
	public abstract void addChef(Chef chef);
	public abstract void addWaiter(Waiter waiter);
}
