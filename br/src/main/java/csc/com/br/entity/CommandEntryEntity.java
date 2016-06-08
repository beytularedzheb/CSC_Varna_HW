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
@Table(name = "command_entries", catalog = "statemachine")
public class CommandEntryEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "command_id", nullable = false)
    private CommandEntity commandEntity;
    
    @Column(name = "value", nullable = false, length = 45)
    private String value;

    @SuppressWarnings("unused")
	private CommandEntryEntity() {
    }

    public CommandEntryEntity(CommandEntity commandEntity, String value) {
        this.commandEntity = commandEntity;
        this.value = value;
    }

    public CommandEntity getCommandEntity() {
        return this.commandEntity;
    }

    public String getValue() {
        return this.value;
    }
}
