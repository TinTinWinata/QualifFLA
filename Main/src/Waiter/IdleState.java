package Waiter;

public class IdleState extends WaiterState {
	public IdleState(Waiter w) {
		super(w);
		this.name = "idle";
	}

	@Override
	public void changeState() {
		w.setState(new IdleState(w));
	}
}