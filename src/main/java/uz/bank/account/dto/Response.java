package uz.bank.account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Response<T>(
		@Schema(description = "Flag indicating whether the operation was successful", example = "true")
		Boolean isSuccess,

		@Schema(description = "Message describing the result of the operation", example = "success")
		String message,

		@Schema(description = "Timestamp of the response", example = "2024-12-14 15:30:00")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		LocalDateTime timestamp,

		@Schema(description = "The data returned in the response, depends on whether data is required in the response, can be null.")
		T data,

		@Schema(description = "Response code")
		String code
) {
}

