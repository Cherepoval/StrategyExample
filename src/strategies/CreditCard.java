package strategies;

public class CreditCard {
    private int amount;
    private String cardNumber;
    private String expirationDate;
    private String svvCode;


    public CreditCard(String cardNumber, String expirationDate, String svvCode) {
        this.amount = 100000;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.svvCode = svvCode;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }
}
