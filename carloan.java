package com.company;

import java.util.Scanner;

public class testing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        float carPrice, downPayment, Principal, balance, monthlyPayment, interest, interestRate;
        int loanPeriod, years=0;

        System.out.println("ENTER THE CAR PRICE (RM):");
        carPrice = sc.nextFloat();

        if (carPrice < 30000) {
            System.out.println("VALUE CAR PRICE CANNOT LESS THAN RM30 000 ");
        }

        System.out.println("\nENTER THE DOWNPAYMENT(RM) : ");
        downPayment = sc.nextFloat();

        if (downPayment >= carPrice) {
            System.out.println("THE LOAN WAS PAID IN FULL");
            downPayment = sc.nextFloat();
        }

        System.out.println("\nENTER LOAN PERIOD(years) : ");
        loanPeriod = sc.nextInt();

        if (loanPeriod < 5) {
            System.out.println("THE LOAN PERIOD CANNOT LESS THAN 5 YEARS");
        } else if (loanPeriod > 9) {
            System.out.println("THE LOAN CANNOT BE LONGER THAN 9 YEARS");
            loanPeriod = sc.nextInt();
        }

        System.out.println("\nENTER INTEREST RATE(%) :");
        interestRate = sc.nextInt();

        if (interestRate < 3) {
            System.out.println("INTEREST RATE CANNOT LESS THAN 3%");
        } else if (interestRate > 7) {
            System.out.println("INTEREST RATE CANNOT MORE THAN 7%");
        }

        float totalInterest = (carPrice - downPayment) * interestRate * loanPeriod;
        monthlyPayment = (carPrice - downPayment + totalInterest) / (loanPeriod * 12);

        System.out.printf("YOUR MONTHLY REPAYMENT IS: RM%.2f\n", monthlyPayment);
        System.out.printf("\t\t%s %17s%20s%20s", "years", "principal", "interest", "balance");


        while (years <= loanPeriod){
            Principal = monthlyPayment * 12 * years;
            interest = (carPrice - downPayment) * (interestRate / 100) * years;
            balance = (monthlyPayment * loanPeriod) * 12 - Principal;

            System.out.printf("\n\t\t%d, %20.2f, %20.5f, %20.5f", years, Principal, interest, balance);
            years++;
        }

    }
}
 
