package uz.bank.account.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import uz.bank.account.dto.Response;

public final class ResponseUtil {

	public static <T> Response<T> toSuccessResponse(T data) {
		return Response.<T>builder()
				.isSuccess(Boolean.TRUE)
				.code("0")
				.message("success")
				.timestamp(LocalDateTime.now(ZoneId.of("Asia/Tashkent")))
				.data(data)
				.build();
	}

	public static Response<Void> toErrorResponse(String code, String message) {
		return Response.<Void>builder()
				.isSuccess(Boolean.FALSE)
				.code(code)
				.message(message)
				.data(null)
				.timestamp(LocalDateTime.now(ZoneId.of("PLT")))
				.build();
	}

	public static <T> Response<T> toErrorResponse(String code, String message, T data) {
		return Response.<T>builder()
				.isSuccess(Boolean.FALSE)
				.code(code)
				.message(message)
				.data(data)
				.timestamp(LocalDateTime.now(ZoneId.of("PLT")))
				.build();
	}

}
