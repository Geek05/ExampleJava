package DesignPatterns.ChainOfResponsibility7.client;

import DesignPatterns.ChainOfResponsibility7.builders.ChainBuilder;
import DesignPatterns.ChainOfResponsibility7.domain.Currency;
import DesignPatterns.ChainOfResponsibility7.handlers.*;

import java.util.Scanner;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class ATMDispenseChain {

    private DispenseChain c1;

    public void CreateATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar2000Dispenser();
        DispenseChain c2 = new Dollar2000Dispenser();
        DispenseChain c3 = new Dollar1000Dispenser();
        DispenseChain c4 = new Dollar500Dispenser();
        DispenseChain c5 = new Dollar100Dispenser();
        DispenseChain c6 = new Dollar50Dispenser();
        DispenseChain c7 = new Dollar20Dispenser();
        DispenseChain c8 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
        c5.setNextChain(c6);
        c6.setNextChain(c7);
        c7.setNextChain(c8);
    }

    public void ATMDispenseChainUsingBuilder() {
        DispenseChain dispenseChain = ChainBuilder.Builder().
                with2kDispenser().
                with1kDispenser().
                with500Dispenser().
                with100Dispenser().
                with50Dispenser().
                with20Dispenser().
                with10Dispenser().
                Build();
        c1 = dispenseChain;
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        //atmDispenser.CreateATMDispenseChain();
        atmDispenser.ATMDispenseChainUsingBuilder();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount <= 0) {
                System.out.println("Thank you.. Exiting..!");
                break;
            }
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }
    }
}