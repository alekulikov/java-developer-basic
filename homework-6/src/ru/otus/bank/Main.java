package ru.otus.bank;

public class Main {
    private static final Client[] clients = {
            new Client(42341414L, "John", 18),
            new Client(124141244L, "Sarah", 30),
            new Client(5252352352L, "John", 20)
    };
    private static final Account[] accounts = {
            new Account(4564_2423_2342_9234L, 42341414L, 956),
            new Account(4564_2423_2342_6536L, 124141244L, 423),
            new Account(4564_2423_5236_5242L, 124141244L, 423),
            new Account(4580_2423_5236_9664L, 5252352352L)
    };

    public static void main(String[] args) {
        Bank bank = createBank();
        System.out.println(bank.getAccounts(clients[1]));
        System.out.println(bank.findClient(accounts[1]));
    }

    private static Bank createBank() {
        Bank bank = new Bank();
        bank.addClients(clients);
        bank.addAccounts(accounts);
        return bank;
    }
}
