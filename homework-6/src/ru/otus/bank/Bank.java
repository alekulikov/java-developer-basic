package ru.otus.bank;

import java.util.*;

public class Bank {
    private final Map<Client, Set<Account>> clientMapAccounts = new HashMap<>();
    private final Map<Account, Client> accountMapClient = new HashMap<>();

    public void addClients(Set<Client> clients) {
        for (Client client : clients) {
            clientMapAccounts.computeIfAbsent(client, k -> new HashSet<>());
        }
    }

    public void addAccounts(Map<Client, Set<Account>> accounts) {
        for (Map.Entry<Client, Set<Account>> entry : accounts.entrySet()) {
            if (clientMapAccounts.containsKey(entry.getKey())) {
                Set<Account> existsClientsAccounts = clientMapAccounts.get(entry.getKey());
                for (Account account : entry.getValue()) {
                    accountMapClient.computeIfAbsent(account, k -> entry.getKey());
                    existsClientsAccounts.add(account);
                }
            }
        }
    }

    public Set<Account> getAccounts(Client client) {
        return clientMapAccounts.get(client);
    }

    public Client findClient(Account account) {
        return accountMapClient.get(account);
    }
}
