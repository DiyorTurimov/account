package uz.bank.account.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder
@Schema(description = "A pageable response containing paginated data")
public record PageableResponse<T>(
		@Schema(description = "Current page number, starts from 0", example = "0")
		Integer page,

		@Schema(description = "Total number of pages, starts from 1", example = "57")
		Integer totalPages,

		@Schema(description = "Number of items per page, starts from 1", example = "20")
		Integer size,

		@Schema(description = "Indicates if this is the first page", example = "true")
		Boolean isFirst,

		@Schema(description = "Indicates if this is the last page", example = "false")
		Boolean isLast,

		@ArraySchema(schema = @Schema(description = "List of items on the current page"))
		List<T> data
) {
}

