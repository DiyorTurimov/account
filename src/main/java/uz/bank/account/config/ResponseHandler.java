package uz.bank.account.config;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uz.bank.account.dto.AccountInfosDto;
import uz.bank.account.dto.SuccessResponse;
import uz.bank.account.service.AccountService;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ResponseHandler {

    public <T> ResponseEntity<SuccessResponse<T>> responseEntity(T data) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.<T>builder()
                        .code(HttpStatus.OK)
                        .message("ok")
                        .timestamp(LocalDateTime.now())
                        .extra(data)
                        .build());


    }
}
