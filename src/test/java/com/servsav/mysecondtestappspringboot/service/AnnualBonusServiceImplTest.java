package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.Positions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when
        double result = new AnnualBonusServiceImpl().calculate(position, salary, bonus, workDays);

        //then
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}