import java.util.Stack;

public class Runner {
	private Command command;
	
	public void start() {
		command.execute();
		
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	
}
