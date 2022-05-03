package Waiter;

public class BringOrderState extends WaiterState{

	public BringOrderState(Waiter w) {
		super(w);
		this.name = "bring order";
	}

	@Override
	public void changeState() {
		w.setState(new ServingFoodState(w));
	}
	

}
