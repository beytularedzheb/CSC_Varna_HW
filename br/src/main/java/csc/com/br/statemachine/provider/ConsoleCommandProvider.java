package csc.com.br.statemachine.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csc.com.br.statemachine.contract.ICommand;
import csc.com.br.statemachine.contract.ICommandProvider;
import csc.com.br.statemachine.util.Command;
import csc.com.br.statemachine.util.Identity;

public class ConsoleCommandProvider implements ICommandProvider {

	public List<ICommand> getCommands() {
		List<ICommand> commands = new ArrayList<ICommand>();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String line;
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.trim().length() == 0) {
				break;
			}
			ICommand command = new Command(new Identity(line));
			commands.add(command);
		}

		return commands;
	}
}
