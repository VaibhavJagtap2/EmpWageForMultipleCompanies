package com.empwageforcompanies;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EmpWageForCompanies implements IComputeWage{
    public static final int absent=1;
    public static final int isFullTime=1;
    public static final int isPartTime=2;
    private int numOfCompany;
    private WageCalculation empWageArray[] ;
    public EmpWageForCompanies() {
        empWageArray = new WageCalculation[5];
    }
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
        empWageArray[numOfCompany]=new WageCalculation(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
        numOfCompany++;
    }


    public void computeEmpWage() {
        for(int i=0;i<numOfCompany;i++) {
            empWageArray[i].setTotalEmpWage(this.computeEmpWage(empWageArray[i]));
            System.out.println(empWageArray[i]);
        }

    }
    private int computeEmpWage(com.empwageforcompanies.WageCalculation companyEmpWage) {
        int empHours=0, totalEmpHours=0, totalWorkingDays=0;
        while(totalEmpHours<=companyEmpWage.maximumHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays){
            int check=(int)(Math.floor(Math.random()*10)%3);
            switch(check){
                case isPartTime:
                    empHours = 4;
                    break;
                case isFullTime:
                    empHours = 8;
                    break;
                default :
                    empHours = 0;
            }
            totalEmpHours+=empHours;
            totalWorkingDays += 1;
        }
        return totalEmpHours * companyEmpWage.empRatePerHour;

    }
    public static void main(String args[]) {
        EmpWageForCompanies EmpWageForCompanies=new EmpWageForCompanies();
        EmpWageForCompanies.addCompanyEmpWage("dmart",28 , 29, 20);
        EmpWageForCompanies.addCompanyEmpWage("reliance", 27, 30, 25);
        EmpWageForCompanies.addCompanyEmpWage("TCS",30,28,20);
        EmpWageForCompanies.computeEmpWage();

    }
}

