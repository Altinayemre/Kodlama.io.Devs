package kodlama.io.devs.business.requests.programmingLanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProgrammingLanguageTechnologyRequest {
	private String technologyName;
	private int programmingLanguageId;
}
