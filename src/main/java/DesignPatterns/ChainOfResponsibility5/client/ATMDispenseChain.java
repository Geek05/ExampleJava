package DesignPatterns.ChainOfResponsibility5.client;

import DesignPatterns.ChainOfResponsibility5.domain.Currency;
import DesignPatterns.ChainOfResponsibility5.handlers.DispenseChain;
import DesignPatterns.ChainOfResponsibility5.handlers.Dollar10Dispenser;
import DesignPatterns.ChainOfResponsibility5.handlers.Dollar20Dispenser;
import DesignPatterns.ChainOfResponsibility5.handlers.Dollar50Dispenser;

import java.util.Scanner;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class ATMDispenseChain {

    private DispenseChain c1;

    public ATMDispenseChain(){}

    public void InitilizeATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        atmDispenser.InitilizeATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }
    }
}