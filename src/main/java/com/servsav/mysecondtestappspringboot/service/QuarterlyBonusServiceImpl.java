package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.Positions;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService {

        public double calculateQuarterlyBonus(Positions position, double salary, double bonus, int workDays) {
        if (position.isManager()) {
            int year = Year.now().getValue(); // Получаем текущий год

            int daysInYear = Year.isLeap(year) ? 366 : 365; // определяем високосный или нет

            return salary * bonus * daysInYear * position.getPositionCoefficient() / workDays/4;
        } else {
            throw new IllegalArgumentException("Этот метод применим только для менеджеров и управленцев.");
        }
    }
}
