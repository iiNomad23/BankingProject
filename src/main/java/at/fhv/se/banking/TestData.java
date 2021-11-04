package at.fhv.se.banking;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestData implements ApplicationRunner {
    
    // TODO: inject Repositories Interfaces for which to create Test Data

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // TODO: create Test Data and add to injected Repositories
    }

}
