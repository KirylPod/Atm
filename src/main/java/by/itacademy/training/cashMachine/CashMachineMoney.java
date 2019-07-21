package by.itacademy.training.cashMachine;

import java.io.*;

public class CashMachineMoney {

    private static double money;
    private static File file;
    private static CashMashinePrint cashMashinePrint;

    public static double getMoney() {

        return money;
    }

    public static void setMoney(double money) {

        CashMachineMoney.money = money;
    }

    public static void getCashMachineMoney() throws IOException {
        file = new File("src/main/resources/money");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        setMoney(Double.parseDouble(reader.readLine()));

    }

    public static void setCashMachineMoney() throws IOException {
        FileWriter writer = new FileWriter(file, false);
        writer.write(String.format("%.2f", getMoney()).replace(',', '.'));
        writer.close();

    }
}

