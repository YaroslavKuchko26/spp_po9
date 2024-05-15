package org.example.task02;

public class DigitalCard {
    protected String personalId;
    protected String bankCardNumber;
    protected String insuranceNumber;

    public DigitalCard(String personalId, String bankCardNumber, String insuranceNumber) {
        this.personalId = personalId;
        this.bankCardNumber = bankCardNumber;
        this.insuranceNumber = insuranceNumber;
    }

    public String getPassportInfo() {
        return PassportSubsystem.getInfo(personalId);
    }

    public String getBankCardInfo() {
        return BankSubsystem.getInfo(bankCardNumber);
    }

    public String getInsuranceInfo() {
        return InsuranceSubsystem.getInfo(insuranceNumber);
    }

}
