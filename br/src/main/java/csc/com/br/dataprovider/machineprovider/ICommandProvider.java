package csc.com.br.dataprovider.machineprovider;

import java.util.List;

import csc.com.br.statemachine.ICommand;

public interface ICommandProvider {
	List<ICommand> getCommands();
}
