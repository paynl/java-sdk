package nl.pay.sdk.transactioninfo;


public class EndUser {
    public String accessCode = "";
    public String language = "";
    public String initials = "";
    public String lastName = "";
    public String gender = "";
    public String dob = "";
    public String phoneNumber = "";
    public String emailAddress = "";
    public String bankAccount = "";
    public String iban = "";
    public String bic = "";
    public boolean sendConfirmEmail = false;
    public String confirmMailTemplate = "";
    public Address address;
    public InvoiceAddress invoiceAddress;

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public boolean isSendConfirmEmail() {
        return sendConfirmEmail;
    }

    public void setSendConfirmEmail(boolean sendConfirmEmail) {
        this.sendConfirmEmail = sendConfirmEmail;
    }

    public String getConfirmMailTemplate() {
        return confirmMailTemplate;
    }

    public void setConfirmMailTemplate(String confirmMailTemplate) {
        this.confirmMailTemplate = confirmMailTemplate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public InvoiceAddress getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(InvoiceAddress invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }
}
