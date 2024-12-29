package bankdeposit;

public class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount){
        System.out.println("Пополнение счета");
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть больше 0.");
        }
        balance += amount;
    }

    public synchronized void remove(int amount) {
        System.out.println("Снятие со счета");
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть больше 0.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Недостаточно средств");
        }
        balance -= amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
}
