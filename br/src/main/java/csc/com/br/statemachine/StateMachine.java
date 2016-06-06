package csc.com.br.statemachine;

import csc.com.br.dataprovider.IDataProvider;

public class StateMachine {
	private IDataProvider dataProvider;

	public StateMachine(final IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public void start() {
		IState current = this.dataProvider.getInitialState();

		for (ICommand command : this.dataProvider.getProgram()) {
			current = current.getNextState(command);
		}
	}
}
