package by.itacademy.training;

import by.itacademy.training.сlient.Client;

import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {

        Client client = new Client();

        client.newCashMachine();
    }
}