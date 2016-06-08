package csc.com.br.statemachine.contract;

public interface IDataProvider {
	ICommandProvider getCommandProvider();
	IMachineProvider getMachineProvider();
}
