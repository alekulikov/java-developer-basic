package ru.otus.bank;

import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Client> clients = Set.of(
            new Client(42341414L, "John", 18),
            new Client(124141244L, "Sarah", 30),
            new Client(5252352352L, "John", 20)
    );
    private static final Map<Client, Set<Account>> accounts = Map.of(
            new Client(42341414L, "John", 18),
            Set.of(new Account(4564_2423_2342_9234L, 956)),

            new Client(124141244L, "Sarah", 30),
            Set.of(new Account(4564_2423_2342_6536L, 423),
                    new Account(4564_2423_5236_5242L, 423)),

            new Client(5252352352L, "John", 20),
            Set.of(new Account(4580_2423_5236_9664L))
    );

    public static void main(String[] args) {
        Bank bank = createBank();
        System.out.println(bank.getAccounts(new Client(124141244L, "Sarah", 30)));
        System.out.println(bank.findClient(new Account(4564_2423_2342_6536L, 423)));
    }

    private static Bank createBank() {
        Bank bank = new Bank();
        bank.addClients(clients);
        bank.addAccounts(accounts);
        return bank;
    }
}
