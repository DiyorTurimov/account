package uz.bank.account.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bank.account.constant.paging.AccountFilter;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.PageableRequest;
import uz.bank.account.dto.PageableResponse;
import uz.bank.account.dto.Response;
import uz.bank.account.service.AccountService;
import uz.bank.account.util.ResponseUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
@Tag(name = "Accounts", description = "Apis for managing client account")
public class AccountController {

	private final AccountService accountService;

	@Operation(
			summary = "Get accounts by client ID with filtering and pagination",
			description = "Retrieves a pageable list of accounts filtered by client ID. Supports dynamic filtering, sorting, and pagination.",
			requestBody = @RequestBody(
					description = "PageableRequest with filtering and sorting options",
					required = true,
					content = @Content(
							schema = @Schema(implementation = PageableRequest.class)
					)
			),
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved account data",
							content = @Content(
									schema = @Schema(implementation = Response.class)
							)),
					@ApiResponse(responseCode = "400", description = "Bad request"),
					@ApiResponse(responseCode = "500", description = "Internal server error")
			}
	)
	@PostMapping("/client/")
	public ResponseEntity<Response<PageableResponse<AccountInfosDto>>> getAccountsByClientId(
			@org.springframework.web.bind.annotation.RequestBody PageableRequest<AccountFilter> pageableRequest) {
		return ResponseEntity.ok(ResponseUtil.toSuccessResponse(accountService.getAccountsByClientId(pageableRequest)));
	}

	@Operation(
			summary = "Get all accounts by client ID",
			description = "Retrieves all accounts for a specific client ID without pagination."
	)
	@GetMapping("/client/{clientId}")
	public ResponseEntity<Response<AccountInfosDto>> getAllAccountsByClientId(@PathVariable String clientId) {
		// TODO Implement logic to retrieve all accounts for a client
		return ResponseEntity.ok(null);
	}

	@Operation(
			summary = "Get pageable account list",
			description = "Retrieves a pageable list of all accounts.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved account list")
			}
	)
	@PostMapping("/list")
	public ResponseEntity<Response<PageableResponse<AccountInfosDto>>> getAllAccountsPageable(
			@RequestBody PageableRequest<AccountFilter> pageableRequest) {
		// TODO Implement logic for retrieving all pageable accounts
		return ResponseEntity.ok(null);
	}
}
