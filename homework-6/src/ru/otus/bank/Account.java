package ru.otus.bank;

public class Account {
    private final Long number;
    private final Long clientId;
    private Integer amount;

    public Account(Long number, Long clientId, Integer amount) {
        this.number = number;
        this.clientId = clientId;
        this.amount = amount;
    }

    public Account(Long number, Long clientId) {
        this(number, clientId, 0);
    }

    public Long getClientId() {
        return clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!number.equals(account.number)) return false;
        if (!clientId.equals(account.clientId)) return false;
        return amount.equals(account.amount);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + clientId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", clientId=" + clientId +
                ", amount=" + amount +
                '}';
    }
}
