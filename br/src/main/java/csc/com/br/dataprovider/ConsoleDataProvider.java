package csc.com.br.dataprovider;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;

public class ConsoleDataProvider /*implements IDataProvider */{
	/*private final String END = "END";
	
	private final Scanner scanner = new Scanner(System.in);
	private final List<IState> states = new ArrayList<IState>();
	private final IState initialState;

	public ConsoleDataProvider(IState initialState) {
		this.initialState = initialState;
		this.states.add(initialState);
	}

	public IState getInitialState() {
		return this.initialState;
	}

	public List<ICommand> getProgram() {
		List<ICommand> commands = new ArrayList<ICommand>();
		String line;
		while (this.scanner.hasNextLine()) {
			line = this.scanner.nextLine();
			if (line.equals(END)) {
				break;
			}
			ICommand command = new Command(new Identity(line));
			commands.add(command);
		}

		return commands;
	}

	public void getMachine() {

		String line;
		while (this.scanner.hasNextLine()) {
			line = this.scanner.nextLine();
			if (line.equals(END)) {
				break;
			}
			String[] tokens = line.split("\\s+", 3);

			IState firstState = new State(new Identity(tokens[0]));
			IState nextState = new State(new Identity(tokens[1]));
			ICommand command = new Command(new Identity(tokens[2]));

			if (!this.states.contains(firstState)) {
				this.states.add(firstState);
			}
			if (!this.states.contains(nextState)) {
				this.states.add(nextState);
			}
			this.states.get(this.states.indexOf(firstState)).addToNextStates(command, this.states.get(this.states.indexOf(nextState)));
		}
	}
*/
}
