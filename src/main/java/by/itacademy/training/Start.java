package by.itacademy.training;

import by.itacademy.training.cashMachine.CashMachine;

import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {
        CashMachine cashMachine = new CashMachine();
        cashMachine.actionId();
    }
}