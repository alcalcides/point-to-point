package ads.exceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ApiResponse.Field> fieldsWithError = new ArrayList<>();
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

		for (ObjectError error : allErrors) {
			String key = null;
			if (error instanceof FieldError) {
				key = ((FieldError) error).getField();
			}

			String message = error.getDefaultMessage();
			fieldsWithError.add(new ApiResponse.Field(key, message));
		}

		ApiResponse response = new ApiResponse();
		response.setFields(fieldsWithError);
		response.setTitle("One or more broken fields");
		response.setTime(LocalDateTime.now());

		return super.handleExceptionInternal(ex, response, headers, status, request);
	}
}
