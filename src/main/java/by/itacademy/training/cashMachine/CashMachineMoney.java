package by.itacademy.training.cashMachine;

import java.io.*;

public class CashMachineMoney {

    private static double money;
    private static File file;

    public static double getMoney() {

        return money;
    }

    public static void setMoney(double money) {

        CashMachineMoney.money = money;
    }

    public static Double getCashMachineMoney() throws IOException {
        file = new File("src/main/resources/money");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        money = Double.parseDouble(reader.readLine());
        return money;
    }

//    public static void setCashMachineMoney(double money) throws IOException {
//        file = new File("src/main/resources/money");
//        FileWriter writer = new FileWriter(file, false);
//        writer.write();

}

