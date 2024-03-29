package by.itacademy.training.bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankServer {

    private static File file;
    private static List<BankAccounts> clientList = new ArrayList<BankAccounts>();
    private static BankServerPrint bankServerPrint;


    public static List<BankAccounts> getAccountValue() throws IOException {
        file = new File("src/main/resources/creditCardList");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        String[] account = line.split(" ");
        while ((line = reader.readLine()) != null) {
            account = line.split(" ");
            clientList.add(new BankAccounts(account[0], account[1], account[2]));
        }
        reader.close();
        return clientList;

    }

    public static BankAccounts getAccount(String clientCardId) throws IOException {
        Optional<BankAccounts> account = getAccountValue()
                .stream().filter(c -> c.getCardId().equals(clientCardId))
                .findFirst();
        if (account.isPresent()) {
            return account.get();
        } else {
            bankServerPrint.errorAccount();
            return null;
        }
    }

    public static void setNewValue(String id, String newValue) throws IOException {
        clientList.stream().filter(c -> c.getCardId().equals(id)).findFirst().get().setCardValue(newValue);
        file = new File("src/main/resources/creditCardList");
        FileWriter writer = new FileWriter(file, false);
        for (int i = 0; i < clientList.size(); i++) {
            writer.write(clientList.get(i).getCardId() + " " + clientList.get(i).getCardPin() + " " + clientList.get(i).getCardValue() + "\n");
        }
        clientList.clear();
             writer.close();
    }
}