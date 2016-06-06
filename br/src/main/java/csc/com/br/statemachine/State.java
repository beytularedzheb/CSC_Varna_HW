package csc.com.br.statemachine;

import java.util.HashMap;

public class State implements IState {

	private String id;
	private HashMap<ICommand, IState> nextStates;

	public State(String id) {
		this.id = id;
		this.nextStates = new HashMap<ICommand, IState>();
	}
	
	public State(String id, HashMap<ICommand, IState> nextStates) {
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

}
