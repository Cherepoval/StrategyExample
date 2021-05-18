package strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CreditCardPayment implements PayStrategy{
    BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;

    @Override
    public void collectDetails() {
        try {
            System.out.print("Enter the card number :");
            String cardNumber = READER.readLine();
            System.out.print("Enter the card expiration date 'mm/yy' :");
            String expirationDate = READER.readLine();
            System.out.println("Enter the CVV code :");
            String svvCode = READER.readLine();

            creditCard = new CreditCard(cardNumber, expirationDate, svvCode);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean pay (int paymentAmount) {
        if (creditCardExist()){
            System.out.println("Paying " +paymentAmount+ " using Credit Card.");
            creditCard.setAmount(creditCard.getAmount() - paymentAmount);
            return true;
        } else {
        return false;
        }
    }

    private boolean creditCardExist() {
        return creditCard != null;
    }
}
