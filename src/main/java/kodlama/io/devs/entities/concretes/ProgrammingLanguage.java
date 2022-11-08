package kodlama.io.devs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="programming_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programming_id")
	private int programmingLanguageId;
	
	@Column(name="programming_name")
	private String programmingLanguageName;

	
	@OneToMany(mappedBy = "programmingLanguage", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private List<ProgrammingLanguageTechnology> programmingLanguageTechnologies;
}
