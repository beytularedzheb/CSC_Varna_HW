package csc.com.br.statemachine.contract;

public interface IState {
	IState getNextState(ICommand command);
	void addToNextStates(ICommand command, IState state);
}
