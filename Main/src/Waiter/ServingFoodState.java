package Waiter;


public class ServingFoodState extends WaiterState{

	public ServingFoodState(Waiter w) {
		super(w);
		this.name = "serving food";
	}

	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}
	

}
