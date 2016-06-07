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

public class FileDataProvider /*implements IDataProvider*/ {	
	/*private BufferedReader bufferedReader;
	private IState initialState;
	private final List<IState> states = new ArrayList<IState>();
	private File file;
	private final String END = "END";
	
	public FileDataProvider(String machineFilePath, String programFilePath) {
		this.file = new File(machineFilePath);
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
    			if (line.equals(END)) {
    				break;
    			}
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
		
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            
            initialState = new State(new Identity(bufferedReader.readLine()));
            this.states.add(initialState);
            
            while ((line = bufferedReader.readLine()) != null) {
        		
    			if (line.equals(END)) {
    				break;
    			}
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
    			this.states.get(this.states.indexOf(firstState)).addToNextStates(command, this.states.get(this.states.indexOf(nextState)));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}*/
}