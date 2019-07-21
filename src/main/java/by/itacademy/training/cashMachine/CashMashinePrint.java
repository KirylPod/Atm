package by.itacademy.training.cashMachine;

import by.itacademy.training.Client.Client;

import java.io.IOException;

public class CashMashinePrint {

    private static CashMachine cashMachine;
    private static CashMachineDriver cashMachineDriver;
    private static Client client;

    public static void errorCardId() throws IOException {
        System.out.println("Введенный номер карты не соотвествует заданному формату");
        cashMachine.actionId();
    }

    public static void errorCardPin(String cardPin) throws IOException {
        System.out.println("Введенный пин-код не соотвествует заданному формату");
        cashMachine.actionPin(cardPin);
    }

    public static void errorGetCashId() throws IOException {
        System.out.println("Недостаточно средств на счете");
        cashMachine.yesNo();
    }

    public static void errorGetCashMachine() throws IOException {
        System.out.println("Недостаточно средств в банкомате");
        cashMachine.yesNo();
    }

    public static void errorSetCashMachine() throws IOException {
        System.out.println("Сумма пополнения не должна превышать 1 000 000");
        cashMachine.yesNo();
    }
    public static void successCardId() throws IOException {
        System.out.println("Спасибо за то, что вы с нами. Удачного дня");
        System.out.println(" ");
        client.newCashMachine();

    }
    public static void errorInputOperation() throws IOException {
        System.out.println("Данной операции не существует");
        cashMachine.operation();
    }

    public static void errorInputYesNo() throws IOException {
        System.out.println("Данной операции не существует");
        cashMachine.yesNo();
    }

}
