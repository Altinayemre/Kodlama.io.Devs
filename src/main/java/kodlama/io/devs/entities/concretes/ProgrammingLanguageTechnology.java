package kodlama.io.devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="programming_language_technologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingLanguageTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technology_id")
	private int techonologyId;
	
	@Column(name="technology_name")
	private String technologyName;
	
	@ManyToOne
	@JoinColumn(name="programming_id")
	private ProgrammingLanguage programmingLanguage;
}
