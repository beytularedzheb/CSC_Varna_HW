package csc.com.br.statemachine;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class State implements IState {

	private Identity id;
	private HashMap<ICommand, IState> nextStates;

	public State(Identity id) {
		this.id = id;
		this.nextStates = new HashMap<ICommand, IState>();
	}

	public State(Identity id, HashMap<ICommand, IState> nextStates) {
		this(id);
		this.nextStates = nextStates;
	}

	public void addToNextStates(ICommand command, IState state) {
		if (command == null || state == null) {
			throw new InvalidParameterException("State or command can not be null!");
		}
		this.nextStates.put(command, state);
	}

	public IState getNextState(ICommand command) {
		if (this.nextStates.containsKey(command)) {
			return this.nextStates.get(command);
		}
		return null;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		State other = (State) obj;
		return this.id.equals(other.id);
	}

	@Override
	public String toString() {
		return this.id.toString();
	}
}
