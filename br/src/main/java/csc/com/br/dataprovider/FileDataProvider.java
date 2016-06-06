package csc.com.br.dataprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import csc.com.br.statemachine.Command;
import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;
import csc.com.br.statemachine.Identity;
import csc.com.br.statemachine.State;

public class FileDataProvider implements IDataProvider {	
	private BufferedReader bufferedReader;
	private IState initialState;

	public IState getInitialState() {
		return this.initialState;
	}

	public List<ICommand> getProgram() {
		return null;
	}

	public void getMachine() {
		Map<IState, HashMap<ICommand, IState>> machine = new HashMap<IState, HashMap<ICommand, IState>>();	
		File file = new File("resources/StateMachine.txt");
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\s+", 3);
                
                State mainState = new State(new Identity(tokens[0]));
        		State nextState = new State(new Identity(tokens[1]));
        		//ICommand command = new Command(new Identity(tokens[2]));
        		
        		//mainState.addNextState(command, nextState);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}