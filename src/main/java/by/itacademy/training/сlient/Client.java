package by.itacademy.training.сlient;

import by.itacademy.training.cashMachine.CashMachine;

import java.io.IOException;

public class Client {

    private static String clientCardId;
    private static String clientCardPin;

    public static String getClientCardId() {
        return clientCardId;
    }

    public static void setClientCardId(String clientCardId) {
        Client.clientCardId = clientCardId;
    }

    public static String getClientCardPin() {
        return clientCardPin;
    }

    public static void setClientCardPin(String clientCardPin) {
        Client.clientCardPin = clientCardPin;
    }

    public static void newCashMachine() throws IOException {

        CashMachine cashMachine = new CashMachine();

        cashMachine.actionId();
    }


}
