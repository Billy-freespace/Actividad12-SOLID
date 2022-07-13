package NoSolid.LSP;

import java.util.ArrayList;
import java.util.List;

public class PaymentHelper {
    List<NewPayment> payments = new ArrayList<NewPayment>();

    public void addUser(NewPayment user){
        payments.add(user);
    }
    public void showPreviousPayments() {
        for (NewPayment payment: payments) {
            payment.previousPaymentInfo();
            System.out.println("------");
        }
    }
    public void processNewPayments()  {
        for (NewPayment payment: payments) {
            payment.newPayment();
            System.out.println("------");
        }
    }
}
