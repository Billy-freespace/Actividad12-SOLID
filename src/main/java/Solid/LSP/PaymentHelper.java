package Solid.LSP;

import java.util.ArrayList;
import java.util.List;

public class PaymentHelper {
    List<NewPayment> newPayments = new ArrayList<NewPayment>();
    List<PreviousPayment> previousPayments = new ArrayList<PreviousPayment>();

    public void addNewPayment(NewPayment user){
        newPayments.add(user);
    }

    public void showPreviousPayments() {
        for (PreviousPayment payment: previousPayments) {
            payment.previousPaymentInfo();
            System.out.println("------");
        }
    }

    public void processNewPayments()  {
        for (NewPayment payment: newPayments) {
            payment.newPayment();
            System.out.println("------");
        }
    }

    public void addPreviousPayment(PreviousPayment user) {
        previousPayments.add(user);
    }
}
