package Waiter;

public class TakeOrderState extends WaiterState{

	
	public TakeOrderState(Waiter w) {
		super(w);
		this.name = "take order";
	}

	@Override
	public void changeState() {
		w.setState(new WaitCookState(w));
	}

}
