package kodlama.io.devs.business.responses.programmingLanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProgrammingLanguageTechnologyRequest {
	private int technologyId;
	private String technologyName;
	private String programmingLanguageName;
}
