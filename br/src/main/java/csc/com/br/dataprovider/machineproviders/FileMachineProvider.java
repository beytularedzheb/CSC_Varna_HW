package csc.com.br.dataprovider.machineproviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;

public class FileMachineProvider implements IMachineProvider {
	private IState initialState;
	private final List<IState> states = new ArrayList<IState>();
	private BufferedReader bufferedReader;
	private final String filePath;

	public FileMachineProvider(String filePath) {
		this.filePath = filePath;
	}

	public IState getInitialState() {
		return this.initialState;
	}

	public void getMachine() {
		String line;

		try {
			bufferedReader = new BufferedReader(new FileReader(this.filePath));

			this.initialState = new State(new Identity(bufferedReader.readLine()));
			this.states.add(this.initialState);

			while ((line = bufferedReader.readLine()) != null) {
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
				this.states.get(this.states.indexOf(firstState)).addToNextStates(command,
						this.states.get(this.states.indexOf(nextState)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}

	}

}
