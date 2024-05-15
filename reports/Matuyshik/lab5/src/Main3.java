// Интерфейс для банковского счета
interface Account {
    void topUp(double amount);
    void withdraw(double amount);
    void cancelAccount();
    double getBalance();
    String getAccountNumber();
}

// Интерфейс для кредитной карты
interface Card {
    boolean checkCreditExceed(double amount);
    void blockCard();
    String getCardNumber();
    double getAvailableCredit();
}

class Client {
    private String name;
    private String phoneNumber;
    private Account bankAccount;
    private Card creditCard;

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setCreditCard(Card creditCard) {
        this.creditCard = creditCard;
    }

    public void payOrder(Order order) {
        System.out.println("Имя клиента: " + name);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Счет в банке: " + bankAccount.getAccountNumber() + ", Баланс: " + bankAccount.getBalance());
        System.out.println("Кредитная карта: " + creditCard.getCardNumber() + ", Доступный кредит: " + creditCard.getAvailableCredit());
        System.out.println("Клиент " + name + " оплачивает заказ на сумму " + order.getAmount() + " с помощью кредитной карты.");
    }

    public void makePaymentToAccount(Account recipientAccount, double amount) {
        System.out.println("Имя клиента: " + name);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Счет в банке: " + bankAccount.getAccountNumber() + ", Баланс: " + bankAccount.getBalance());
        System.out.println("Кредитная карта: " + creditCard.getCardNumber() + ", Доступный кредит: " + creditCard.getAvailableCredit());
        System.out.println("Клиент " + name + " делает платеж на другой счет на сумму " + amount + " с помощью счета в банке.");
    }

    public void blockCreditCard() {
        if (creditCard != null) {
            creditCard.blockCard();
            System.out.println("Кредитная карта клиента " + name + " была заблокирована.");
        }
    }

    public void cancelBankAccount() {
        if (bankAccount != null) {
            bankAccount.cancelAccount();
            System.out.println("Счет клиента " + name + " был аннулирован.");
        }
    }
}

class BankAccount implements Account {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void topUp(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств на счете");
        }
    }

    @Override
    public void cancelAccount() {
        // Логика аннулирования счета
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}

class CreditCard implements Card {
    private String cardNumber;
    private double creditLimit;
    private double availableCredit;
    private boolean blocked;

    public CreditCard(String cardNumber, double creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.availableCredit = creditLimit;
    }

    @Override
    public boolean checkCreditExceed(double amount) {
        return (availableCredit - amount) < 0;
    }

    @Override
    public void blockCard() {
        blocked = true;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public double getAvailableCredit() {
        return availableCredit;
    }
}

class Order {
    private String orderNumber;
    private double amount;

    public Order(String orderNumber, double amount) {
        this.orderNumber = orderNumber;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class Administrator {
    public void blockCardForOverdraft(Client client) {
        System.out.println("Администратор заблокировал карту клиента " + client.getName() + " за превышение кредита.");
    }
}

public class Main3 {
    public static void main(String[] args) {
        // Пример использования системы
        Client client = new Client("John Doe", "+123456789");
        Account bankAccount = new BankAccount("123456", 1000.0);
        Card creditCard = new CreditCard("789012345678", 500.0);

        client.setBankAccount(bankAccount);
        client.setCreditCard(creditCard);

        Order order = new Order("0001", 200.0);
        client.payOrder(order);

        Account recipientAccount = new BankAccount("654321", 0.0);
        client.makePaymentToAccount(recipientAccount, 100.0);

        Administrator administrator = new Administrator();
        administrator.blockCardForOverdraft(client);
    }
}
