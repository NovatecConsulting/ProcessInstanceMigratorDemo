package info.novatec.bpm.demo_migrator.delegates;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SellingContext {

    public boolean areDocsOkay() {
        return new Random().nextInt(2) < 1;
    }
}
