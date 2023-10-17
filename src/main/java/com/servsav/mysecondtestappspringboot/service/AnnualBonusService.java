package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
