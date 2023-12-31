package com.servsav.mysecondtestappspringboot.service;
import com.servsav.mysecondtestappspringboot.exception.UnsupportedCodeException;
import com.servsav.mysecondtestappspringboot.exception.ValidationFailedException;
import com.servsav.mysecondtestappspringboot.model.Codes;
import com.servsav.mysecondtestappspringboot.model.ErrorCodes;
import com.servsav.mysecondtestappspringboot.model.ErrorMessages;
import com.servsav.mysecondtestappspringboot.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Slf4j
public class ErrorHandling {
    public static ResponseEntity<Response> handleValidationException(Response response, ValidationFailedException e) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
        response.setErrorMessage(ErrorMessages.VALIDATION);
        log.info("Отдаваемый response: {}", response);
        log.error("Ошибка Валидации: ", e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Response> handleUnsupportedCodeException(Response response, UnsupportedCodeException e)
    {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNSUPPORTED);
        log.info("Отдаваемый response: {}", response);
        log.error("Ошибка Не поддерживая: ", e);
        return new ResponseEntity<>(response, HttpStatus.SEE_OTHER);
    }

    public static ResponseEntity<Response> handleUnknownException(Response response, Exception e) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNKNOWN);
        log.info("Отдаваемый response: {}", response);
        log.error("Ошибка Неизвестная: ", e);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
