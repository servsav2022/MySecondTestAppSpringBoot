package com.servsav.mysecondtestappspringboot.service;

import com.servsav.mysecondtestappspringboot.model.Positions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuarterlyBonusServiceImplTest {

       @Test
        void calculateQuarterlyBonus() {
            Positions position = Positions.TL;
            double bonus = 2.0;
            int workDays = 243;
            double salary = 100000.00;

            //when
            double result = new AnnualBonusServiceImpl().calculateQuarterlyBonus(position, salary, bonus, workDays);

            //then
            double expected = 195267.48971193415;
            assertThat(result).isEqualTo(expected);
       }
}
