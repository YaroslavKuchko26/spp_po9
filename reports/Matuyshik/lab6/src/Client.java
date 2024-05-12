// Фасад для универсальной электронной карты
class ElectronicCardFacade {
    private Passport passport;
    private Insurance insurance;
    private Bank bank;

    public ElectronicCardFacade() {
        this.passport = new Passport();
        this.insurance = new Insurance();
        this.bank = new Bank();
    }

    // Методы для отображения информации о различных функциях карты
    public void displayPassportInfo() {
        passport.displayInfo();
    }

    public void displayInsuranceInfo() {
        insurance.displayInfo();
    }

    public void displayBankInfo() {
        bank.displayInfo();
    }
}

// Классы для различных функций на карте
class Passport {
    public void displayInfo() {
        System.out.println("Displaying passport information...");
    }
}

class Insurance {
    public void displayInfo() {
        System.out.println("Displaying insurance information...");
    }
}

class Bank {
    public void displayInfo() {
        System.out.println("Displaying bank information...");
    }
}

public class Client {
    public static void main(String[] args) {
        ElectronicCardFacade facade = new ElectronicCardFacade();

        // Отображение информации о паспорте, страховке и банке
        facade.displayPassportInfo();
        facade.displayInsuranceInfo();
        facade.displayBankInfo();
    }
}
