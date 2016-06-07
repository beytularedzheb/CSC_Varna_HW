package csc.com.br.statemachine;

public class Command implements ICommand {

	private final Identity identity;

	public Command(Identity identity) {
		this.identity = identity;
	}
	
	public Identity getIdenity(){
		return this.identity;
	}

	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());*/
		return identity.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Command other = (Command) obj;
		return identity.equals(other.identity);
	}	
}
