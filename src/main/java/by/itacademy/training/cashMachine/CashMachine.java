package by.itacademy.training.cashMachine;

import by.itacademy.training.Client.Client;
import by.itacademy.training.bank.BankAccounts;
import by.itacademy.training.bank.BankServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import static by.itacademy.training.Client.Client.getClientCardId;

public class CashMachine {

    private static Client client;
    private static BankServer bankServer;
    private static BankAccounts account;
    private static CashMachineDriver cashMachineDriver;
    private static CashMachineMoney cashMachineMoney;
    private static CashMashinePrint cashMashinePrint;

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


    public static void actionId() throws IOException {

        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");


        client.setClientCardId(input.readLine());

        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", getClientCardId())) {
            valid(getClientCardId());
        } else {
            cashMashinePrint.errorCardId();
        }
        input.close();
    }

    public static void valid(String getClientCardId) throws IOException {
        account = bankServer.getAccount(getClientCardId);
        actionPin(account.getCardPin());
        if (account == null) {
            cashMashinePrint.errorCardId();
        }

    }

    public static void actionPin(String cardPin) throws IOException {

        System.out.println("Введите пин-код, состоящий из цифр, в формате: ХХХХ");

        client.setClientCardPin(input.readLine());

        if (Pattern.matches("^\\d{4}", client.getClientCardPin()) && client.getClientCardPin().equals(cardPin)) {

            cashMachineMoney.getCashMachineMoney();
            operation();
        } else {
            cashMashinePrint.errorCardPin(cardPin);
        }
        input.close();
    }

    public static void operation() throws IOException {

        System.out.println("1 - Проверить баланс");
        System.out.println("2 - Снять наличные");
        System.out.println("3 - Пополнить баланс");
        System.out.println("4 - Вернуть карту");

        String num = input.readLine();
        if (Pattern.matches("^[1-4]{1}", num)) {
            switch (num) {
                case "1":
                    account.setCardValue(cashMachineDriver.getValue(account.getCardValue()));
                    yesNo();
                    break;
                case "2":
                    account.setCardValue(cashMachineDriver.getCash(account.getCardValue()));
                    yesNo();
                    break;
                case "3":
                    account.setCardValue(cashMachineDriver.setValue(account.getCardValue()));
                    yesNo();
                    break;
                case "4":
                    System.out.println("Заберите вашу карту");
                    bankServer.setNewValue(account.getCardId(), account.getCardValue());
                    cashMachineMoney.setCashMachineMoney();
                    cashMashinePrint.successCardId();
                    break;
            }

        } else {
            cashMashinePrint.errorInputOperation();

        }
        input.close();
    }

    public static void yesNo() throws IOException {
        System.out.println("Желаете продолжить?");
        System.out.println("1 - Продолжить");
        System.out.println("2 - Отмена");
        String num = input.readLine();


        if (Pattern.matches("^[1-2]{1}", num)) {
            switch (num) {
                case "1":
                    operation();
                    break;
                case "2":
                    System.out.println("Заберите вашу карту");
                    bankServer.setNewValue(account.getCardId(), account.getCardValue());
                    cashMachineMoney.setCashMachineMoney();
                    cashMashinePrint.successCardId();
                    break;
            }
        }else {
            cashMashinePrint.errorInputYesNo();
        }
        input.close();
    }

}