package Mediator;

import Chef.Chef;
import Employee.Employee;
import User.User;
import Waiter.Waiter;

public abstract class Mediator {
	public abstract void sendUserSignal(Employee employee, String msg);
	public abstract void sendChefSignal(User user, String msg);
	public abstract void sendWaiterSignal(User user, String msg);
	public abstract void addUser(User user);
	public abstract void addChef(Chef chef);
	public abstract void addWaiter(Waiter waiter);
}
