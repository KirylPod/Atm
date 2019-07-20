package by.itacademy.training.cashMachine;

import java.io.IOException;
import java.util.Scanner;

public class CashMachineDriver {

    private static CashMachine cashMachine;
    private static CashMachineMoney cashMachineMoney;
    private static Scanner scanner = new Scanner(System.in);

    public static String getValue(String value) throws IOException {
        System.out.println("На вашем счету = " + value);
        return value;

    }

    public static String getCash(String value) throws IOException {
        double cash;
        System.out.println("Введите сумму, которую желаете снять");
        cash = scanner.nextDouble();
        if (cash > stringToDouble(value)) {
            System.out.println("Недостаточно средств на счете");
            cashMachine.yesNo();
        }
        if (cash >= cashMachineMoney.getMoney()) {
            System.out.println("Недостаточно средств в банкомате");
            cashMachine.yesNo();
        }
        System.out.println("Операция выполнена успешно, заберите деньги: " + cash);
        cashMachineMoney.setMoney(cashMachineMoney.getMoney() - cash);
        return String.format("%.2f", stringToDouble(value) - cash).replace(',', '.');  // тут костыль
    }

    public static String setValue(String value) throws IOException {
        double cash;
        System.out.println("Введите сумму, на которую желаете пополнить счет");
        cash = scanner.nextInt();
        if (cash >= 1000000) {
            System.out.println("Сумма пополнения превышает 1 000 000");
            cashMachine.yesNo();
        }
        cashMachineMoney.setMoney(cashMachineMoney.getMoney() + cash);
        cashMachineMoney.setCashMachineMoney();
        System.out.println("Операция выполнена успешно, вы пополнили счет на: " + cash);
        return value = String.format("%.2f", stringToDouble(value) + cash).replace(',', '.');

    }

    public static Double stringToDouble(String str) {
        return Double.parseDouble(str);
    }
}