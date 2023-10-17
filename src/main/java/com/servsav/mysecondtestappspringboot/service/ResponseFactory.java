package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.*;
import com.servsav.mysecondtestappspringboot.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;


public class ResponseFactory {
    public static Response createResponse(Request request) throws ParseException {
        Response.ResponseBuilder builder = Response.builder();
        if (request.getPosition().isManager()) {
        //если управленец, то в ответ добавляется квартальная премия
           builder.uid(request.getUid());
           builder.operationUid(request.getOperationUid());
           builder.systemTime(DateTimeUtil.getCustomFormat().format(new Date()));
           builder.code(Codes.SUCCESS);
           builder.annualBonus(new AnnualBonusServiceImpl().calculate
                   (request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()));
           builder.quarterlyBonus(new QuarterlyBonusServiceImpl().calculateQuarterlyBonus
                   (request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()));
           builder.errorCode(ErrorCodes.EMPTY);
           builder.errorMessage(ErrorMessages.EMPTY);
         return   builder.build();
       } else {
         // если не управленец, то только годовая
           builder.uid(request.getUid());
           builder.operationUid(request.getOperationUid());
           builder.systemTime(DateTimeUtil.getCustomFormat().format(new Date()));
           builder.code(Codes.SUCCESS);
           builder.annualBonus(new AnnualBonusServiceImpl().calculate
                   (request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()));
           builder.quarterlyBonus(0.0);
           builder.errorCode(ErrorCodes.EMPTY);
           builder.errorMessage(ErrorMessages.EMPTY);
          return builder.build();
       }
    }
}