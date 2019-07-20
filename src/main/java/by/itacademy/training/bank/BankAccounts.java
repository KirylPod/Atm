package by.itacademy.training.bank;

public class BankAccounts {

    private String cardId, cardPin, cardValue;

    public String getCardId() {
        return cardId;
    }

    public String getCardId(String card) {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }
    public BankAccounts() {
    }

    public BankAccounts(String cardId, String cardPin, String cardValue) {
        this.cardId = cardId;
        this.cardPin = cardPin;
        this.cardValue = cardValue;
    }

}
