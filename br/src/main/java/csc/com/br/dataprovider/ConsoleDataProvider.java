package csc.com.br.dataprovider;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
		return null;
	}

	public void getMachine() {

		String line;
		while (this.scanner.hasNextLine()) {
			line = this.scanner.nextLine();
			String[] tokens = line.split("\\s+", 3);

		}

	}

}
