package csc.com.br.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "machines", catalog = "statemachine")
public class MachineEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "machineEntity")
    private Set<MachineEntryEntity> machineEntryEntities = new HashSet<MachineEntryEntity>(0);

    @SuppressWarnings("unused")
	private MachineEntity() {
    }

    public MachineEntity(Set<MachineEntryEntity> machineEntryEntities) {
        this.machineEntryEntities = machineEntryEntities;
    }

    public Set<MachineEntryEntity> getMachineEntries() {
        return this.machineEntryEntities;
    }
}
