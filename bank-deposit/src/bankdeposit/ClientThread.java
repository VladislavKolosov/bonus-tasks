package bankdeposit;

public class ClientThread extends Thread {
    private BankAccount bankAccount;
    private int amount;
    private boolean isDeposit;

    public ClientThread(BankAccount bankAccount, int amount, boolean isDeposit) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            bankAccount.deposit(amount);
        } else {
            bankAccount.remove(amount);
        }
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public void setDeposit(boolean deposit) {
        isDeposit = deposit;
    }
}
