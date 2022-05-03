package Employee;

import Mediator.Mediator;
import User.User;

public interface EmployeeInterface {
	
	public void joinRoom(Mediator room);
	public void recieveSignal(User user, String msg);
	
}
