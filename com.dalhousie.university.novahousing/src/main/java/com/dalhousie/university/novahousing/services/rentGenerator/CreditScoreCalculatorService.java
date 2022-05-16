//Author: Sidharth
package com.dalhousie.university.novahousing.services.rentGenerator;

public interface CreditScoreCalculatorService {
    int calculateCredit(String userType, int annualIncome, boolean rentalHistory);
}
