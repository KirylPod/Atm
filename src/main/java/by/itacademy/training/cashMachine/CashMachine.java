package by.itacademy.training.cashMachine;

import by.itacademy.training.bank.BankAccounts;
import by.itacademy.training.bank.BankServer;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CashMachine {

    private BankServer bankServer;
    private BankAccounts account;
    private CashMachineDriver cashMachineDriver;
    private static CashMachineMoney cashMachineMoney;

    private static Scanner scanner = new Scanner(System.in);

    public void actionId() throws IOException {

        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");

        String clientCardId = scanner.nextLine();

        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", clientCardId)) {
            System.out.println("Отлично");

            account = bankServer.getAccount(clientCardId);
            actionPin(account.getCardPin());

            scanner.close();
        } else {
            System.out.println("Введенный номер карты не соотвествует заданному формату");
            actionId();
        }
    }

    private void actionPin(String cardPin) throws IOException {

        System.out.println("Введите пин-код, состоящий из цифр, в формате: ХХХХ");

        String clientCardPin = scanner.nextLine();

        System.out.println("Pin code " + clientCardPin);

        if (Pattern.matches("^\\d{4}", clientCardPin) && clientCardPin.equals(cardPin)) {

            cashMachineMoney.getCashMachineMoney();
            operation();

        } else {
            System.out.println("Ошибка ввода пин-кода");
            actionPin(cardPin);
        }
        scanner.close();
    }

    private void operation() throws IOException {

        System.out.println("1 - Проверить баланс");
        System.out.println("2 - Снять наличные");
        System.out.println("3 - Пополнить баланс");
        System.out.println("4 - Закончить");

        int num = scanner.nextInt();
        switch (num) {
            case 1:
                account.setCardValue(cashMachineDriver.getValue(account.getCardValue()));
                yesNo();
                break;
            case 2:
                    account.setCardValue(cashMachineDriver.getCash(account.getCardValue()));
                    yesNo();
                break;
            case 3:
                    account.setCardValue(cashMachineDriver.setValue(account.getCardValue()));
                    yesNo();
                break;
            case 4:
                bankServer.setNewValue(account.getCardId(), account.getCardValue());
                break;
            default:
                break;
        }
        scanner.close();
    }

    public void yesNo() throws IOException {
        System.out.println("Желаете продолжить?");
        System.out.println("1 - Продолжить");
        System.out.println("2 - Отмена");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                operation();
                break;
            case 2:
                bankServer.setNewValue(account.getCardId(), account.getCardValue());
                cashMachineMoney.setCashMachineMoney();
                break;

            default:
                actionId();
                break;
        }
        scanner.close();
    }
}