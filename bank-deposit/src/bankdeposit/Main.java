package bankdeposit;

class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        ClientThread clientThread2 = new ClientThread(bankAccount, 5, false);
        ClientThread clientThread3 = new ClientThread(bankAccount, 5, false);
        ClientThread clientThread4 = new ClientThread(bankAccount, 5, true);
        ClientThread clientThread1 = new ClientThread(bankAccount, 1, true);

        clientThread1.start();
        clientThread4.start();
        clientThread2.start();
        clientThread3.start();

        try {
            clientThread1.join();
            clientThread2.join();
            clientThread3.join();
            clientThread4.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bankAccount.getBalance());
    }
}
