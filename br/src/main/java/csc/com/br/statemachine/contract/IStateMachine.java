package csc.com.br.statemachine.contract;

import javassist.NotFoundException;

public interface IStateMachine {
	void start(IState initialState) throws NotFoundException ;
}
