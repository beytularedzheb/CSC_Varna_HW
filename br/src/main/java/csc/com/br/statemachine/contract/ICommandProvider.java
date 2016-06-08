package csc.com.br.statemachine.contract;

import java.util.List;

public interface ICommandProvider {
	List<ICommand> getCommands();
}
