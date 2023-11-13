package ru.job4j.ood.ocp;

import java.math.BigDecimal;

public class Payroll {
    BigDecimal calc(PayrollData data){
        /*return data.bonus.add(data.salary).add(data.compensation);*/
    return data.bonus.add(data.salary); /*поле убрали*/
    }
}

class PayrollData {
    BigDecimal bonus;
    BigDecimal salary;
    BigDecimal compensation;
}
