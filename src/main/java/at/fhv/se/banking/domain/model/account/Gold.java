package at.fhv.se.banking.domain.model.account;

public class Gold extends AccountState {

    private static final Gold inst = new Gold();

    private Gold() { }

    public static Gold instance() {
        return inst;
    }

    @Override
    public void downgradeToSilver(Account account) {

        if(account.balance() >= Account.INTEREST_THRESHOLD) {
            throw new IllegalStateException();
        }

        account.changeState(Silver.instance());
    }
}
