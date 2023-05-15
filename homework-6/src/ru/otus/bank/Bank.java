package ru.otus.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private final Map<Long, List<Account>> clientIdMapAccounts = new HashMap<>();
    private final Map<Long, Client> clientIdMapClient = new HashMap<>();

    public void addClients(Client... clients) {
        for (Client client : clients) {
            clientIdMapClient.put(client.getId(), client);
        }
    }

    public void addAccounts(Account... accounts) {
        for (Account account : accounts) {
            List<Account> clientsAccounts = clientIdMapAccounts.computeIfAbsent(account.getClientId(), k -> new ArrayList<>());
            clientsAccounts.add(account);
        }
    }

    public List<Account> getAccounts(Client client) {
        return clientIdMapAccounts.get(client.getId());
    }

    public Client findClient(Account account) {
        return clientIdMapClient.get(account.getClientId());
    }
}
