// Фасад, предоставляющий унифицированный интерфейс к подсистемам
class UniversalCardFacade {
    private PassportSubsystem passportSubsystem;
    private InsuranceSubsystem insuranceSubsystem;
    private BankCardSubsystem bankCardSubsystem;

    public UniversalCardFacade() {
        passportSubsystem = new PassportSubsystem();
        insuranceSubsystem = new InsuranceSubsystem();
        bankCardSubsystem = new BankCardSubsystem();
    }

    public void getPersonalInformation() {
        passportSubsystem.getPersonalInformation();
    }

    public void getInsuranceDetails() {
        insuranceSubsystem.getInsuranceDetails();
    }

    public void performPayment(double amount) {
        bankCardSubsystem.performPayment(amount);
    }
}