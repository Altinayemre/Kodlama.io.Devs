package kodlama.io.devs.business.requests.programmingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProgramingLanguageRequest {
	private int programmingLanguageId;
	private String programmingLanguageName;
}
