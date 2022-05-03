package User;

public class OrderWaiterState extends UserState{
	
	public OrderWaiterState(User u) {
		super(u);
		this.setStateName("order food");
	}
		
	
	@Override
	public void changeState() {
		u.setState(new WaitFoodState(u));
	}
}
