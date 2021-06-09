package ads.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
	private LocalDateTime time;
	private String title;
	private List<Field> fields;

	@Getter
	@Setter
	@AllArgsConstructor
	public static class Field {
		private String key;
		private String message;
	}
}
