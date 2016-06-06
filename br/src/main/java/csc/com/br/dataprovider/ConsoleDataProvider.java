package csc.com.br.dataprovider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Scanner;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;

public class ConsoleDataProvider implements IDataProvider {
	private final Scanner scanner = new Scanner(System.in);
	private final HashSet<IState> states = new HashSet<IState>();
	private final IState initialState;

	public ConsoleDataProvider(IState initialState) {
		this.initialState = initialState;
		this.states.add(initialState);
	}

	public IState getInitialState() {
		return this.initialState;
	}

	public List<ICommand> getProgram() {
		List<ICommand> commands=new ArrayList<ICommand>();
		String line;
		while (this.scanner.hasNextLine()) {
			line = this.scanner.nextLine();
			ICommand command = new Command(new Identity(line));
			commands.add(command);
		}
		
		return commands;
	}

	public void getMachine() {

		String line;
		while (this.scanner.hasNextLine()) {
			line = this.scanner.nextLine();
			String[] tokens = line.split("\\s+", 3);
			IState firstState = new State(new Identity(tokens[0]));
			IState nextState = new State(new Identity(tokens[1]));
			ICommand command = new Command(new Identity(tokens[2]));
			this.states.add(firstState);
			this.states.add(nextState);
			firstState.addToNextStates(command, nextState);
		}

	}

}
