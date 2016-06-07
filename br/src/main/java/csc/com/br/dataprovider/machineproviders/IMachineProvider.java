package csc.com.br.dataprovider.machineproviders;

import csc.com.br.statemachine.IState;

public interface IMachineProvider {
	IState getInitialState();
	void getMachine();
}
