package csc.com.br.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "machine_entries", catalog = "statemachine")
public class MachineEntryEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "machine_id", nullable = false)
	private MachineEntity machineEntity;

	@Column(name = "from_state", nullable = false, length = 45)
	private String fromState;

	@Column(name = "to_state", nullable = false, length = 45)
	private String toState;

	@Column(name = "command", nullable = false, length = 45)
	private String command;

	public MachineEntryEntity() {
	}

	public MachineEntryEntity(MachineEntity machineEntity, String fromState, String toState, String command) {
		this.machineEntity = machineEntity;
		this.fromState = fromState;
		this.toState = toState;
		this.command = command;
	}

	public MachineEntity getMachineEntity() {
		return this.machineEntity;
	}

	public String getFromState() {
		return this.fromState;
	}

	public String getToState() {
		return this.toState;
	}

	public String getCommand() {
		return this.command;
	}

}
