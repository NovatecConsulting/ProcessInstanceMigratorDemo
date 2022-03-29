package info.novatec.bpm.demo_migrator.delegates;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SellingContext {

    public boolean areDocsOkay() {
        return new Random().nextInt(2) < 1;
    }

    public void sendDocs() {
        System.out.println("Docs have been sent!\n");
    }

    public void doPayment() {
        System.out.println("Payment successful!\n");
    }
}
