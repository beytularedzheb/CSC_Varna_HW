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
@Table(name = "commands", catalog = "statemachine")
public class CommandEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "commandEntity")
    private Set<CommandEntryEntity> commandEntryEntities = new HashSet<CommandEntryEntity>(0);

    @SuppressWarnings("unused")
	private CommandEntity() {
    }

    public CommandEntity(Set<CommandEntryEntity> commandEntryEntities) {
        this.commandEntryEntities = commandEntryEntities;
    }
    
    public Set<CommandEntryEntity> getCommandEntries() {
        return this.commandEntryEntities;
    }

}
