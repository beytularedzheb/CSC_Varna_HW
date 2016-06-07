package csc.com.br.dataprovider.machineprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.Identity;

public class ConsoleCommandProvider implements ICommandProvider {

	private static final String END_INPUT_STRING = "/";
	
	public List<ICommand> getCommands() {
		List<ICommand> commands = new ArrayList<ICommand>();
		Scanner scanner = new Scanner(System.in);
		
		String line;
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.equals(END_INPUT_STRING)) {
				break;
			}
			ICommand command = new Command(new Identity(line));
			commands.add(command);
		}

		return commands;
	}


}
