package ru.otus.bank;

public class Account {
    private final Long number;
    private Integer amount;

    public Account(Long number, Integer amount) {
        this.number = number;
        this.amount = amount;
    }

    public Account(Long number) {
        this(number, 0);
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!number.equals(account.number)) return false;
        return amount.equals(account.amount);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", amount=" + amount +
                '}';
    }
}
