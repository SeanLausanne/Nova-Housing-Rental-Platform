//Author: Sidharth
package com.dalhousie.university.novahousing.services.rentGenerator;

public class MinAnnualIncomeServiceImpl implements MinAnnualIncomeService {

    @Override
    public int minAnnualIncome(int rent) {
        int annualIncome;
        annualIncome= (int) (rent*12/0.3);
        return annualIncome;
    }
}
