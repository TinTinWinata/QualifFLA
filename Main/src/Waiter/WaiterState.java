package Waiter;

public abstract class WaiterState {

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
	
	public abstract void changeState();
}
