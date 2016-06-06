package csc.com.br.statemachine;

public interface IState {
	IState getNextState(ICommand command);
}
