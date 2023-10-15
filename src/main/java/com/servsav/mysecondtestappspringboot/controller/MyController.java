package com.servsav.mysecondtestappspringboot.controller;
import com.servsav.mysecondtestappspringboot.exception.UnsupportedCodeException;
import com.servsav.mysecondtestappspringboot.exception.ValidationFailedException;
import com.servsav.mysecondtestappspringboot.model.*;
import com.servsav.mysecondtestappspringboot.service.*;
import com.servsav.mysecondtestappspringboot.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final CheckUidService checkUidService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    @Autowired
    public MyController(ValidationService validationService,
                        CheckUidService checkUidService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySourceRequestService") ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.checkUidService = checkUidService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) throws ParseException {
        log.info("Входящий request: {}",request);
        Response response = ResponseFactory.createResponse(request);
        log.info("Первоначальный response: {}",response);
        try {
            validationService.isValid(bindingResult);
            checkUidService.isChecked(request);
            log.info(" После валидации request: {}",request);
        } catch (ValidationFailedException e) {
            return ErrorHandling.handleValidationException(response, e);
        } catch (UnsupportedCodeException e) {
            return ErrorHandling.handleUnsupportedCodeException(response, e);
        } catch (Exception e) {
            return ErrorHandling.handleUnknownException(response, e);
        }
        modifyResponseService.modify(response);
        log.info("Отдаваемый response: {}",response);
        /*** Вот тут я беру время из респонза который отсылается в постман и посылаю его в реквест
         * который будет послан во второй сервис
         */
        modifyRequestService.sendTime(response, request);
        modifyRequestService.modify(request);
        log.info("Отдаваемый request: {}",request);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
