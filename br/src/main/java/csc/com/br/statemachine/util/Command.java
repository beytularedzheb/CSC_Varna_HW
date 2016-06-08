package csc.com.br.statemachine.util;

import java.security.InvalidParameterException;

import csc.com.br.statemachine.contract.ICommand;

public class Command implements ICommand {

	private final Identity identity;

	public Command(Identity identity) {
		if (identity == null) {
			throw new InvalidParameterException("Identity can not be null !");
		}
		this.identity = identity;
	}
	
	public Identity getIdenity(){
		return this.identity;
	}

	@Override
	public int hashCode() {
		return identity.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Command other = (Command) obj;
		return identity.equals(other.identity);
	}
	
	@Override
	public String toString() {
		return identity.toString();
	}

}