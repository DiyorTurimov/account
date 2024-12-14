package uz.bank.account.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.bank.account.dto.Response;
import uz.bank.account.exception.ApplicationException;
import uz.bank.account.util.ResponseUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<Response<Void>> handleEntityNotFoundException(ApplicationException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ResponseUtil.toErrorResponse("101", e.getMessage()));
	}
}
