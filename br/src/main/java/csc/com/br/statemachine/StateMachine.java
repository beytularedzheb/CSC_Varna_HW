package csc.com.br.statemachine;

import java.security.InvalidParameterException;
import java.util.List;

import csc.com.br.dataprovider.IDataProvider;

public class StateMachine {
	private final IDataProvider dataProvider;
	private final IWriter writer;

	public StateMachine(final IDataProvider dataProvider, final IWriter writer) {
		this.dataProvider = dataProvider;
		this.writer = writer;

	}

	public void start() {
		this.dataProvider.getMachineProvider().getMachine();
		IState current = this.dataProvider.getMachineProvider().getInitialState();
		List<ICommand> programList = this.dataProvider.getCommandProvider().getCommands();
		int size = programList.size();

		for (int i = 0; i < size; i++) {
			ICommand command = programList.get(i);
			IState next = current.getNextState(command);

			if (next != null) {
				this.writer.Writer(String.format("From %s to %s", current.toString(), next.toString()));
				current = next;
			} else {
				throw new InvalidParameterException("Invalid state");
			}
		}
	}
}
