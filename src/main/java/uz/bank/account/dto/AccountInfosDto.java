package uz.bank.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@Schema(description = "DTO representing account information")
public record AccountInfosDto(
		@Schema(description = "Unique identifier of the account", example = "12345")
		Long id,

		@Schema(description = "Phone number associated with the account", example = "998XXXXXXXXX")
		String phone,

		@Schema(description = "Client identifier", example = "XXXXXX")
		String clientId,

		@Schema(description = "Account number", example = "XXXXXXXXXXXXXXXXXXXX")
		String accountNumber,

		@Schema(description = "Account creation timestamp", example = "2024-06-14T12:30:00")
		LocalDateTime createdAt,

		@Schema(description = "Account last update timestamp", example = "2024-06-14T15:45:00")
		LocalDateTime updatedAt,

		@Schema(description = "Currency information associated with the account")
		CurrencyDto currency
) {
}
