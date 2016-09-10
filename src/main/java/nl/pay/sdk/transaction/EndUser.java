package nl.pay.sdk.transaction;


public class EndUser {
    public String accessCode = "";
    public String language = "";
    public String initials = "";
    public String lastName = "";
    public String gender = "";
    public String dob = "";
    public String phoneNumber = "";
    public String emailAddress = "";
    public String iban = "";
    public String bic = "";
    public boolean sendConfirmEmail;
    public String confirmMailTemplate = "";
    public Address address = new Address();
    public InvoiceAddress invoiceAddress = new InvoiceAddress();

    /**
     * getAccessCode
     * @deprecated
     * @return the accesscode
     */
    public String getAccessCode() {
        return accessCode;
    }

    /**
     * setAccessCode
     * @deprecated
     * @param accessCode the accesscode
     */
    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    /**
     * getLanguage
     * @return the language of the enduser
     */
    public String getLanguage() {
        return language;
    }

    /**
     * setLanguage
     * Sets the language of the enduser (ISO 639-1).
     * Pay.nl will communicate with the user in this language (if supported, otherwise it will default to English)
     * @param language the language of the enduser (ISO 639-1)
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * getInitials
     * @return initials of the enduser (if known)
     */
    public String getInitials() {
        return initials;
    }

    /**
     * setInitials
     * Set the initials of the enduser paying for the transaction
     * @param initials initials of the enduser
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * getLastName
     * @return the last name of the enduser
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName
     * Set the lastname of the enduser
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getGender
     * @return gender of the enduser (if known)
     */
    public String getGender() {
        return gender;
    }

    /**
     * setGender
     * Set the gender of the enduser (M/F)
     * @param gender gender of the enduser (M)ale / (F)emale
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * getDob
     * @return date of birth of enduser (if known)
     */
    public String getDob() {
        return dob;
    }

    /**
     * setDob
     * Set the birthdate of the enduser
     * @param dob date of birth in format: (DD-MM-YYYY)
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * getPhoneNumber
     * @return the phone number (if known)
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * setPhoneNumber
     * @param phoneNumber the phone number of the end user
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * getEmailAddress
     * @return the email address of the end user (if known)
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * setEmailAddress
     * @param emailAddress the email address of the end user
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * getIban
     * @return the IBAN of the end user (if known)
     */
    public String getIban() {
        return iban;
    }

    /**
     * setIban
     * @param iban the IBAN of the end user
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * getBic
     * @return the BIC of the end user
     */
    public String getBic() {
        return bic;
    }

    /**
     * setBic
     * Set the BIC of the end user
     * @param bic the BIC
     */
    public void setBic(String bic) {
        this.bic = bic;
    }

    /**
     * isSendConfirmEmail
     * Does Pay.nl send the enduser any e-mails about the transaction?
     * @return true if enduser will get mail from Pay.nl (if known)
     */
    public boolean isSendConfirmEmail() {
        return sendConfirmEmail;
    }

    /**
     * setSendConfirmEmail
     * Does Pay.nl need to send confirmation e-mails after payment has been completed?
     * @param sendConfirmEmail true / false
     */
    public void setSendConfirmEmail(boolean sendConfirmEmail) {
        this.sendConfirmEmail = sendConfirmEmail;
    }

    /**
     * getConfirmMailTemplate
     * @return confirm mail template id
     */
    public String getConfirmMailTemplate() {
        return confirmMailTemplate;
    }

    /**
     * setConfirmMailTemplate
     * Please note, contact Pay.nl support before setting this.
     * @param confirmMailTemplate the id of the mail template
     */
    public void setConfirmMailTemplate(String confirmMailTemplate) {
        this.confirmMailTemplate = confirmMailTemplate;
    }

    /**
     * getAddress
     * @return the Address object
     */
    public Address getAddress() {
        return address;
    }

    /**
     * setAddress
     * @param address the Address object
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * getInvoiceAddress
     * @return the InvoiceAddress object
     */
    public InvoiceAddress getInvoiceAddress() {
        return invoiceAddress;
    }

    /**
     * setInvoiceAddress
     * @param invoiceAddress the InvoiceAddress object
     */
    public void setInvoiceAddress(InvoiceAddress invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }
}
