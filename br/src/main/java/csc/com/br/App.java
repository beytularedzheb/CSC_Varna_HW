package csc.com.br;

import csc.com.br.dataprovider.DataProvider;
import csc.com.br.dataprovider.IDataProvider;
import csc.com.br.dataprovider.machineprovider.ConsoleCommandProvider;
import csc.com.br.dataprovider.machineprovider.ConsoleMachineProvider;
import csc.com.br.dataprovider.machineprovider.FileCommandProvider;
import csc.com.br.dataprovider.machineprovider.FileMachineProvider;
import csc.com.br.dataprovider.machineprovider.ICommandProvider;
import csc.com.br.dataprovider.machineprovider.IMachineProvider;
import csc.com.br.statemachine.ConsoleWriter;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;
import csc.com.br.statemachine.StateMachine;

public class App {
	public static void main(String[] args) {
		/*IMachineProvider machineProvider = new FileMachineProvider("C:\\interns\\workspace\\br\\src\\main\\resources\\input_state_machine.txt");
		ICommandProvider commandProvider = new FileCommandProvider("C:\\interns\\workspace\\br\\src\\main\\resources\\input_program.txt");
		IDataProvider dataProvider= new DataProvider(machineProvider, commandProvider);
		StateMachine stateMachine = new StateMachine(dataProvider, new ConsoleWriter());
		stateMachine.start();*/
		
		IMachineProvider machineProvider = new ConsoleMachineProvider();
		ICommandProvider commandProvider = new ConsoleCommandProvider();
		IDataProvider dataProvider= new DataProvider(machineProvider, commandProvider);
		StateMachine stateMachine = new StateMachine(dataProvider, new ConsoleWriter());
		stateMachine.start();
		
	}
}
