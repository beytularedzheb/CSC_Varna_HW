package csc.com.br.statemachine;

public class Command implements ICommand {

	private final Identity identity;

	public Command(Identity identity) {
		this.identity = identity;
	}
	
	public Identity getIdenity(){
		return this.identity;
	}
}
