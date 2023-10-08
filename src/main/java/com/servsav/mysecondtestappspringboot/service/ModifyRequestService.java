package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.Request;
import com.servsav.mysecondtestappspringboot.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyRequestService {
    void modify(Request request);
    void sendTime(Response response, Request request);
}
