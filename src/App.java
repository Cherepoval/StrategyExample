import strategies.CreditCardPayment;
import strategies.PayPalPayment;
import strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static Map<Integer, Integer> productPrices = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        productPrices.put(1, 2200);
        productPrices.put(2, 2000);
        productPrices.put(3, 1800);
        productPrices.put(4, 1400);
    }

    public static void main(String[] args) throws IOException {

        while (!order.isClosed()){
            int cost;
            String continueChoice;
            do {
                System.out.print(" Please select a product: " + "\n" +
                                " 1 - Mother board " + "\n" +
                                " 2 - CPU " + "\n" +
                                " 3 - SSD " + "\n" +
                                " 4 - DDR " + "\n"
                        );
                int choice = Integer.parseInt(reader.readLine());
                cost = productPrices.get(choice);

                System.out.print("Count:");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);

                System.out.print("Do you wish to continue selecting products ? (Y/N) :");
                continueChoice = reader.readLine();

            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null){
                System.out.println(" Please, select a payment method: " + "\n" +
                                " 1 - PayPal/a " + "\n" +
                                " 2 - Credit Card "
                         );
                String paymentMethod = reader.readLine();

                if (paymentMethod.equals("1")){
                    strategy = new PayPalPayment();
                } else {
                    strategy = new CreditCardPayment();
                }
            }
            order.processOrder(strategy);

            System.out.print("Pay " +order.getTotalCost()+ " units or Continue shopping ? (P/C) :");
            String proceed = reader.readLine();

            if (proceed.equalsIgnoreCase("P")){
                if (strategy.pay(order.getTotalCost())){
                    System.out.println("Payment has been successful !");
                } else {
                    System.out.println("Fail ! Please, check your data. ");
                }
            }
            order.setClosed();
        }
    }

}
