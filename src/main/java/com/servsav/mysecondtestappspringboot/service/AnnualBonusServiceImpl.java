package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.Positions;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate (Positions position, double salary, double bonus, int workDays) {

        int year = Year.now().getValue(); // Получаем текущий год

        int daysInYear = Year.isLeap(year) ? 366 : 365; // определяем високосный или нет

        return salary * bonus * daysInYear * position.getPositionCoefficient() / workDays;
    }
}
