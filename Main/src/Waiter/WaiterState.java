package Waiter;

import Chef.Chef;
import Main.Restaurant;
import User.User;

public abstract class WaiterState extends Thread{

	public Waiter w;
	public String name;
	private Chef chef;
	private User user;
	Restaurant restaurant = Restaurant.getInstance();
	
	private boolean runnable;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isRunnable() {
		return runnable;
	}
	
	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void setRunnable(boolean runnable) {
		this.runnable = runnable;
	}
	
	public void thereIsAChef(Chef chef) {
		this.chef = chef;
	}
	
	public WaiterState(Waiter w)
	{
		this.w = w;
	}
	
	public String getStateName()
	{
		return name;
	}
	
	public void changeStateTakeOrder(User u)
	{
		w.setState(new TakeOrderState(this.w, u));
	}
	
	public void changeStateWaitCook(User u)
	{
		w.setState(new WaitCookState(this.w, u));
	}
	
	public void changeStateBringOrder(Chef c, User u)
	{
		w.setState(new BringOrderState(this.w, c, u));
	}
	
	public void changeStateServingFood(User u)
	{
		w.setState(new ServingFoodState(this.w,  u));
	}
	
	public abstract void changeState();
}
