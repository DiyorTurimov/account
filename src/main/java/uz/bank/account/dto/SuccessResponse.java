package uz.bank.account.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

    @Builder
    public record SuccessResponse<T>(String message,
                                   HttpStatus code,
                                   LocalDateTime timestamp,
                                   T extra) {
    }


