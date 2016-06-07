package csc.com.br.dataprovider.machineprovider;

import csc.com.br.statemachine.IState;

public interface IMachineProvider {
	IState getInitialState();
	void getMachine();
}
