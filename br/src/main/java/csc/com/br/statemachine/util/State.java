package csc.com.br.statemachine.util;

import java.security.InvalidParameterException;
import java.util.HashMap;

import csc.com.br.statemachine.contract.ICommand;
import csc.com.br.statemachine.contract.IState;

public class State implements IState {

	private Identity id;
	private HashMap<ICommand, IState> nextStates;

	public State(Identity id) {
		setIdentity(id);
		this.nextStates = new HashMap<ICommand, IState>();
	}

	private void setIdentity(Identity id) {
		if (id == null) {
			throw new InvalidParameterException("Identity can not be null !");
		}
		this.id = id;
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