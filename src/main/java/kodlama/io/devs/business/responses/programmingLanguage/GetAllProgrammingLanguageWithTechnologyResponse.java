package kodlama.io.devs.business.responses.programmingLanguage;

import java.util.List;

import kodlama.io.devs.business.responses.programmingLanguageTechnology.GetOnlyProgrammingTechnologyNameResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProgrammingLanguageWithTechnologyResponse {
	private int programmingLanguageId;
	private String programmingLanguageName;
	private List<GetOnlyProgrammingTechnologyNameResponse> TechnologyNames ;
}
