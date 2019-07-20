package by.itacademy.training.bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class BankServer {

    private static File file;
    private static ArrayList<Accounts> clientList = new ArrayList<Accounts>();

    public static ArrayList<Accounts> getAccountValue() throws IOException {
        file = new File("src/main/resources/creditCardList");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        String[] account = line.split(" ");
        while ((line = reader.readLine()) != null) {
            account = line.split(" ");

            clientList.add(new Accounts(account[0], account[1], account[2]));

        }
        return clientList;

    }

    public static Accounts getAccount(String clientCardId) throws IOException {

        Optional<Accounts> account = getAccountValue().stream().filter(c -> c.getCardId().equals(clientCardId)).findFirst();
        if (account.isPresent()) {
            return account.get();
        } else {
            System.out.println("Данного клиента не существует");
            return null; //todo Change return statements;
        }
    }

    public static void setNewValue(String id, String newValue) throws IOException {
        clientList.stream().filter(c -> c.getCardId().equals(id)).findFirst().get().setCardValue(newValue);
        FileWriter writer = new FileWriter(file, false);
        for (int i = 0; i < clientList.size(); i++) {
            writer.write(clientList.get(i).getCardId() + " " + clientList.get(i).getCardPin() + " " + clientList.get(i).getCardValue() + "\n");
        }
        writer.close();
    }
}