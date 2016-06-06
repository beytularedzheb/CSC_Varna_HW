package csc.com.br.dataprovider;

import java.util.List;

import csc.com.br.statemachine.ICommand;
import csc.com.br.statemachine.IState;

public interface IDataProvider {
	IState getInitialState();
	List<ICommand> getProgram();
	void getMachine();
}
