package at.fhv.se.banking.domain.model.account;

public class Red extends AccountState {

    private static final Red inst = new Red();

    private Red() { }

    public static Red instance() {
        return inst;
    }

    @Override
    public void overdraw(Account account) {


    }

    @Override
    public void restoreOverdrawn(Account account) {

        if(account.balance() < Account.OVERDRAFT_LIMIT) {
            throw new IllegalStateException();
        }

        account.changeState(Silver.instance());
    }
}
