package Waiter;

import Chef.Chef;
import User.User;

public abstract class WaiterState extends Thread{

	public Waiter w;
	public String name;
	
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
	
	public void changeStateWaitCook()
	{
		w.setState(new WaitCookState(this.w));
	}
	
	public void changeStateBringOrder(Chef c)
	{
		w.setState(new BringOrderState(this.w, c));
	}
	
	public void changeStateServingFood(User u)
	{
		w.setState(new ServingFoodState(this.w,  u));
	}
	
	public abstract void changeState();
}
