package csc.com.br.statemachine;

import csc.com.br.dataprovider.IDataProvider;

public class StateMachine {
	private final IDataProvider dataProvider;
	private final IWriter writer;

	public StateMachine(final IDataProvider dataProvider, final IWriter writer) {
		this.dataProvider = dataProvider;
		this.writer=writer;
		
	}

	public void start() {
		IState current = this.dataProvider.getInitialState();
		this.dataProvider.getMachine();
		for (ICommand command : this.dataProvider.getProgram()) {
			this.writer.Writer(current.toString());
			current = current.getNextState(command);
		}
	}
}
