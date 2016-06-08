package csc.com.br.statemachine;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import csc.com.br.statemachine.contract.ICommand;
import csc.com.br.statemachine.contract.IDataProvider;
import csc.com.br.statemachine.contract.IState;
import csc.com.br.statemachine.contract.IStateMachine;
import csc.com.br.statemachine.util.Command;
import csc.com.br.statemachine.util.Identity;
import csc.com.br.statemachine.util.State;
import csc.com.br.statemachine.writer.IWriter;
import javassist.NotFoundException;

public class StateMachine implements IStateMachine {
	private final IDataProvider dataProvider;
	private final IWriter writer;
	private List<IState> states;
	
	public StateMachine(final IDataProvider dataProvider, final IWriter writer) {
		if (dataProvider == null) {
			throw new InvalidParameterException("Data provider can not be null !");
		}
		if (writer == null) {
			throw new InvalidParameterException("Writer can not be null !");
		}
		this.dataProvider = dataProvider;
		this.writer = writer;
	}

	private void buildMachine() throws NotFoundException {

		List<String> machineEntries = this.dataProvider.getMachineProvider().getMachine();
		this.states = new ArrayList<IState>();
		
		for (int i = 0; i < machineEntries.size(); i++) {
			String entry = machineEntries.get(i);
			
			String[] tokens = entry.split("\\s+", 3);

			IState firstState = new State(new Identity(tokens[0]));
			IState nextState = new State(new Identity(tokens[1]));
			ICommand command = new Command(new Identity(tokens[2]));

			if (!this.states.contains(firstState)) {
				this.states.add(firstState);
			}
			if (!this.states.contains(nextState)) {
				this.states.add(nextState);
			}
			this.states.get(this.states.indexOf(firstState)).addToNextStates(command,
					this.states.get(this.states.indexOf(nextState)));
		}
	}
	
	public void start(final IState initialState) throws NotFoundException {
		buildMachine();
		
		IState current;
		if (this.states.contains(initialState)) {
			current = this.states.get(this.states.indexOf(initialState));
		}
		else {
			throw new NotFoundException(String.format("Not found initial state: %s", initialState.toString()));
		}
		
		for (ICommand command : this.dataProvider.getCommandProvider().getCommands()) {
			IState next = current.getNextState(command);

			if (next != null) {
				this.writer.write(String.format("%s: %s -> %s", command.toString(), current.toString(), next.toString()));
				current = next;
			} else {
				String msg = String.format("Invalid command: %s in state %s", command.toString(), current.toString());
				this.writer.write(msg);
				throw new InvalidParameterException(msg);
			}
		}
		
		this.writer.write("Success!");
	}
}
