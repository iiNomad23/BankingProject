package at.fhv.se.banking;

import at.fhv.se.banking.domain.model.*;
import at.fhv.se.banking.domain.model.account.Account;
import at.fhv.se.banking.domain.model.transfer.*;
import at.fhv.se.banking.domain.model.transfer.decorators.TransferGiroOnlyDecorator;
import at.fhv.se.banking.domain.model.transfer.decorators.TransferLimitDecorator;
import at.fhv.se.banking.domain.model.transfer.decorators.TransferLoggerDecorator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication {
	public static void main(String[] args) {

		TransferService core = new TransferServiceImpl();
		TransferService limited = new TransferLimitDecorator(core, 5000);
		TransferService giroRestricted = new TransferGiroOnlyDecorator(limited);
		TransferService logged = new TransferLoggerDecorator(giroRestricted);

		Customer max = new Customer("1234567890", "max mustermann");
		Account ma = new Account("AT12 3456 7890 1234", max, "giro");

		Customer moritz = new Customer("0987654321", "moritz mustermann");
		Account mo = new Account("AT09 8765 4321 0987", moritz, "savings");

		try {
			logged.transfer(ma, mo, 100);
		}
		catch (TransferException x) {
			// already logged
			;
		}

		//SpringApplication.run(BankingApplication.class, args);
	}
}
