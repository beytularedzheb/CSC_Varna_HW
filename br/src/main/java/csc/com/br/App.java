package csc.com.br;

import csc.com.br.statemachine.*;
import csc.com.br.statemachine.contract.ICommandProvider;
import csc.com.br.statemachine.contract.IDataProvider;
import csc.com.br.statemachine.contract.IMachineProvider;
import csc.com.br.statemachine.provider.ConsoleCommandProvider;
import csc.com.br.statemachine.provider.ConsoleMachineProvider;
import csc.com.br.statemachine.provider.DataProvider;
import csc.com.br.statemachine.provider.FileCommandProvider;
import csc.com.br.statemachine.provider.FileMachineProvider;
import csc.com.br.statemachine.util.Identity;
import csc.com.br.statemachine.util.State;
import csc.com.br.statemachine.writer.*;

public class App {
	public static void main(String[] args) {
		try {
			/*IMachineProvider machineProvider = new FileMachineProvider("src/main/resources/input_state_machine.txt");
			ICommandProvider commandProvider = new FileCommandProvider("src/main/resources/input_program.txt");
			IDataProvider dataProvider= new DataProvider(machineProvider, commandProvider);
			StateMachine stateMachine = new StateMachine(dataProvider, new FileAppender("src/main/resources/output.txt"));
			stateMachine.start(new State(new Identity("S1")));*/
			
			IMachineProvider machineProvider = new ConsoleMachineProvider();
			ICommandProvider commandProvider = new ConsoleCommandProvider();
			IDataProvider dataProvider= new DataProvider(machineProvider, commandProvider);
			StateMachine stateMachine = new StateMachine(dataProvider, new ConsoleWriter());
			stateMachine.start(new State(new Identity("S1")));
			
			/*IMachineProvider machineProvider = new FileMachineProvider("src/main/resources/input_state_machine.txt");
			ICommandProvider databaseCommandProvider = new DatabaseCommandProvider();
			IDataProvider dataProvider= new DataProvider(machineProvider, databaseCommandProvider);
			IStateMachine stateMachine = new StateMachine(dataProvider, new ConsoleWriter());
			stateMachine.start(new State(new Identity("S1")));*/
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
