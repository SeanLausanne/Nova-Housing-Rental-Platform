//Author: Sidharth
package com.dalhousie.university.novahousing.services.rentGenerator;

public class CreditScoreCalculatorServiceImpl implements CreditScoreCalculatorService {

    @Override
    public int calculateCredit(String userType, int annualIncome, boolean rentalHistory) {
        int min =300;
        int max= 850;

        double rentalMultiplier=0.7;
        double userTypeMultiplier;
        double annualIncomeMultiplier=1;

        if(rentalHistory){
            rentalMultiplier=1.4;
        }
        switch (userType){
            case "EMPLOYEE":
                userTypeMultiplier=2;
                break;
            case "STUDENT":
                userTypeMultiplier=1.2;
                break;
            case "SELF-EMPLOYED":
                userTypeMultiplier=1.7;
                break;
            case "BUSINESS-PERSON":
                userTypeMultiplier=2.8;
                break;
            case "RETIRED":
                userTypeMultiplier=0.8;
                break;
            case "UNEMPLOYED":
                userTypeMultiplier=0.3;
                break;
            default:
                userTypeMultiplier=1;
                break;
        }

        if(annualIncome<=10000){
            annualIncomeMultiplier=1.2;
        }
        else if(annualIncome<=30000){
            annualIncomeMultiplier=1.5;
        }
        else if(annualIncome<=50000){
            annualIncomeMultiplier=1.8;
        }
        else if(annualIncome>=70000){
            annualIncomeMultiplier=2.0;
        }

        min=(int) (min+(min*annualIncomeMultiplier)/10+(min+min*userTypeMultiplier)/5+(min+min*rentalMultiplier)/100);
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}
