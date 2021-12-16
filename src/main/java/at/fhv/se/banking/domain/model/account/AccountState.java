package at.fhv.se.banking.domain.model.account;

public abstract class AccountState {

    public void overdraw(Account account){
        throw new IllegalStateException();
    }

    public void restoreOverdrawn(Account account) {
        throw new IllegalStateException();
    }

    public void downgradeToSilver(Account account) {
        throw new IllegalStateException();
    }

    public void upgradeToGold(Account account) {
        throw new IllegalStateException();
    }

}
