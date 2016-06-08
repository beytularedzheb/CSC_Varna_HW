package csc.com.br.statemachine.util;

import java.security.InvalidParameterException;

public class Identity {

	private String id;

	public Identity(String id) {
		setId(id);
	}

	private void setId(String id) {
		if (id == null) {
			throw new InvalidParameterException("String identity can not be null value");
		}
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Identity other = (Identity) obj;
		return this.id.equals(other.id);
	}

	@Override
	public String toString() {
		return this.id;
	}
}