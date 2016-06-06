package csc.com.br.dataprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;

public class FileDataProvider implements IDataProvider {	
	private BufferedReader bufferedReader;
	private IState initialState;
	private File file;
	
	public FileDataProvider(String filePath) {
		this.file = new File(filePath);
	}

	public IState getInitialState() {
		return this.initialState;
	}

	public List<ICommand> getProgram() {
		List<ICommand> commands = new ArrayList<ICommand>();
		String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            while ((line = bufferedReader.readLine()) != null) {
        		ICommand command = new Command(new Identity(line));
        		
        		commands.add(command);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return commands;
	}

	public void getMachine() {
		Map<IState, HashMap<ICommand, IState>> machine = new HashMap<IState, HashMap<ICommand, IState>>();
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\s+", 3);
                
                State mainState = new State(new Identity(tokens[0]));
        		State nextState = new State(new Identity(tokens[1]));
        		ICommand command = new Command(new Identity(tokens[2]));
        		
        		mainState.addNextState(command, nextState);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}