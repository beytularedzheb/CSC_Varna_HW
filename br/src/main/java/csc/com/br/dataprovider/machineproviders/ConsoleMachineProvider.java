package csc.com.br.dataprovider.machineproviders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;

public class ConsoleMachineProvider implements IMachineProvider {

	private static final String END_INPUT_STRING = "/";
	
	private final List<IState> states = new ArrayList<IState>();
	private IState initialState;
	
	public IState getInitialState() {
		return this.initialState;
	}

	public void getMachine() {
		String line;
		Scanner scanner = new Scanner(System.in);
		
		this.initialState = new State(new Identity(scanner.nextLine()));
		this.states.add(this.initialState);
		
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.equals(END_INPUT_STRING)) {
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

}
