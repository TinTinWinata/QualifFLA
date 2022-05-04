package Waiter;

public class WaitCookState extends WaiterState{

	public WaitCookState(Waiter w) {
		super(w);
		this.name = "wait cook";
	}

	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}

}
