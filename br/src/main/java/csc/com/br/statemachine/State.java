package csc.com.br.statemachine;

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

	public void addNextState(ICommand command, IState state) {
		this.nextStates.put(command, state);
	}

	public IState getNextState(ICommand command) {
		if (this.nextStates.containsKey(command)) {

			System.out.println(this.toString()); // TODO:

			return this.nextStates.get(command);
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
