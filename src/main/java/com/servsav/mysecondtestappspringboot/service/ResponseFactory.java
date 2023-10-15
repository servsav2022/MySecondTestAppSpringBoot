package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.*;
import com.servsav.mysecondtestappspringboot.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;

public class ResponseFactory {
    public static Response createResponse(Request request) throws ParseException {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    }
}