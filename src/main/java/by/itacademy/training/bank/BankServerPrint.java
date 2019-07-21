package by.itacademy.training.bank;

import by.itacademy.training.сlient.Client;

import java.io.IOException;

public class BankServerPrint {

    private static Client client;

    public static void errorAccount() throws IOException {
        System.out.println("Ваша карта не действительна");
        System.out.println("Обратитесь в банк в которым вы обслуживаетесь");
        client.newCashMachine();

    }
}
