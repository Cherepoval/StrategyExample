package strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayPalPaymentTest {
    @Test
    void testPayWhenNotSigned() {
        assertFalse((new PayPalPayment()).pay(15000));
    }

    @Test
    void testPayWhenSignedIn() {
        PayPalPayment payPalPayment = new PayPalPayment();
        payPalPayment.setSignedIn(true);
        assertTrue(payPalPayment.pay(15000));
    }

}

