package by.itacademy.training.cashMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CashMachineDriver {

    private static CashMachine cashMachine;
    private static CashMachineMoney cashMachineMoney;
    private static CashMashinePrint cashMashinePrint;

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static String getValue(String value) throws IOException {
        System.out.println("На вашем счету = " + value);
        return value;
    }

    public static String getCash(String value) throws IOException {
        int cash;
        System.out.println("Введите сумму, которую желаете снять");
        cash = Integer.parseInt(input.readLine());

        if (cash > stringToInt(value)) {
            cashMashinePrint.errorGetCashId();
        }
        if (cash >= cashMachineMoney.getMoney()) {
            cashMashinePrint.errorGetCashMachine();
        }

        System.out.println("Операция выполнена успешно, заберите деньги: " + cash);
        cashMachineMoney.setMoney(cashMachineMoney.getMoney() - cash);

        return value = String.valueOf(stringToInt(value) - cash);

    }

    public static String setValue(String value) throws IOException {
        int cash;
        System.out.println("Введите сумму, на которую желаете пополнить счет");
        cash = Integer.parseInt(input.readLine());
        if (cash >= 1000000) {
            cashMashinePrint.errorSetCashMachine();
        }
        cashMachineMoney.setMoney(cashMachineMoney.getMoney() + cash);
        cashMachineMoney.setCashMachineMoney();
        System.out.println("Операция выполнена успешно, вы пополнили счет на: " + cash);

        return value = String.valueOf(stringToInt(value) + cash);
    }

    public static Integer stringToInt (String str) {
        return Integer.parseInt(str);
    }
}