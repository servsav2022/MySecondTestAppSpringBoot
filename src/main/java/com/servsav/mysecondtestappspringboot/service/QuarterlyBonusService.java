package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public interface QuarterlyBonusService {
    double calculateQuarterlyBonus(Positions position, double salary, double bonus, int workDays);
}
