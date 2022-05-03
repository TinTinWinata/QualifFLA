package User;

public abstract class UserState extends Thread{

	public User u;
	private String name;
	
	public String getStateName() {
		return name;
	}
	
	public void setStateName(String str)
	{
		this.name = str;
	}
	
	public UserState(User u)
	{
		this.u = u;
	}
	
	public abstract void changeState();
}
