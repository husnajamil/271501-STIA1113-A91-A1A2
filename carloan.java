```java
package com.company;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    private static float InterestRate;

    public static void main(String[] args) {

        Scanner sc = new Scanner(in);

        float carPrice, downPayment, Principal = 0, balance, monthlyPayment = 0, interest, interestRate;
        int loanPeriod, years=0;

        out.println("ENTER THE CAR PRICE (RM)");
        carPrice = sc.nextFloat();

        if (carPrice < 30000) {
            out.println("VALUE CAR PRICE CANNOT LESS THAN RM30 000 ");
           // carPrice = sc.nextFloat();
        }

        out.println("\nENTER THE DOWNPAYMENT(RM) : ");
        downPayment = sc.nextFloat();

        if (downPayment >= carPrice) {
            out.println("THE LOAN WAS PAID IN FULL");
            downPayment = sc.nextFloat();
        }

        out.println("\nENTER LOAN PERIOD(years) : ");
        loanPeriod = sc.nextInt();

        if (loanPeriod < 5) {
            out.println("THE LOAN PERIOD CANNOT LESS THAN 5 YEARS");
        } else if (loanPeriod > 9) {
            out.println("THE LOAN CANNOT BE LONGER THAN 9 YEARS");
            loanPeriod = sc.nextInt();
        } 

        out.println("\nENTER INTEREST RATE(%) :");
        interestRate = sc.nextInt();

        if (interestRate < 3) {
            out.println("INTEREST RATE CANNOT LESS THAN 3%");
        } else if (interestRate > 7) {
            out.println("INTEREST RATE CANNOT MORE THAN 7%");
        }

        float totalInterest = (carPrice - downPayment) * interestRate * loanPeriod;
        monthlyPayment = (carPrice - downPayment + totalInterest) / (loanPeriod * 12);

        try (PrintStream monthlyPayment1 = out.printf("*\nYOUR MONTHLY REPAYMENT IS: RM'%.2f'\n", "monthlyPayment")) {
        }

        PrintStream printf = out.printf("\t\t%d %s %s %s %d", new Object[]{"years", "principal", "interest", "balance"});


        while (years <= loanPeriod)
        Principal = monthlyPayment * 12 * years;
        interest = (carPrice - downPayment) * (interestRate / 100) * years;
        balance = (monthlyPayment * loanPeriod) * 12 - Principal;

        System.out.printf("\n\t\t%7d, %f%,%f,%f", new Object[]{years, Principal, interest, balance});
        years++;
    }

    }
    ```
