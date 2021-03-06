package csc.com.br.statemachine.provider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csc.com.br.statemachine.contract.ICommand;
import csc.com.br.statemachine.contract.ICommandProvider;
import csc.com.br.statemachine.util.Command;
import csc.com.br.statemachine.util.Identity;

public class FileCommandProvider implements ICommandProvider {

	private String filePath;
	private BufferedReader bufferedReader;

	public FileCommandProvider(String filePath) {
		this.filePath = filePath;
	}

	public List<ICommand> getCommands() {
		List<ICommand> commands = new ArrayList<ICommand>();

		String line;

		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));

			while ((line = bufferedReader.readLine()) != null) {
				ICommand command = new Command(new Identity(line));
				commands.add(command);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}

		return commands;
	}

}
