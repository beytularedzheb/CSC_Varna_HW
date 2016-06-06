package csc.com.br.dataprovider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;

public class ConsoleDataProvider implements IDataProvider {

	public IState getInitialState() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ICommand> getProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getMachine() {
		Map<IState, HashMap<ICommand, IState>> machine = new HashMap<IState, HashMap<ICommand, IState>>();
		Scanner scn = new Scanner(System.in);
		String line = scn.nextLine();
		String[] tokens = line.split("\\s+", 3);

		State mainState = new State(new Identity(tokens[0]));
		State nextState = new State(new Identity(tokens[1]));
		//ICommand command = new Command(token[2]);
		
		//mainState.addNextState(command, nextState);
	}

}
