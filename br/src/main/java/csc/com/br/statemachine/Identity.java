package csc.com.br.statemachine;

public class Identity {

	private String id;

	public Identity(String id) {
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
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Identity other = (Identity) obj;
		if ((id == null && other.id != null) || !id.equals(other.id)) {
			return false;
		}
		return true;

	}

	@Override
	public String toString() {
		return this.id;
	}
}
