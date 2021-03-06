package ads.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
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
