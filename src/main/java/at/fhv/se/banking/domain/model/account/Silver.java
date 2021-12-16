package at.fhv.se.banking.domain.model.account;

public class Silver extends AccountState {

    private static final Silver inst = new Silver();

    private Silver() { }

    public static Silver instance() {
        return inst;
    }

    @Override
    public void overdraw(Account account) {

        if(account.balance() > Account.OVERDRAFT_LIMIT) {
            throw new IllegalStateException();
        }

        account.changeState(Red.instance());

    }

    @Override
    public void upgradeToGold(Account account) {

        if(account.balance() < Account.INTEREST_THRESHOLD) {
            throw new IllegalStateException();
        }

        account.changeState(Gold.instance());
    }
}
