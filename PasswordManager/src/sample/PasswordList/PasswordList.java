package sample.PasswordList;

public class PasswordList {
    private String passwordName;
    private String passwordValue;
    private String passwordWebsite;
    private String passwordUsername;

    public PasswordList(String passwordName, String passwordValue, String passwordWebsite,String passwordUsername) {
        this.passwordName = passwordName;
        this.passwordValue = passwordValue;
        this.passwordWebsite = passwordWebsite;
        this.passwordUsername = passwordUsername;
    }

    public String getPasswordName() {
        return passwordName;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getPasswordWebsite() {
        return passwordWebsite;
    }

    public void setPasswordWebsite(String passwordWebsite) {
        this.passwordWebsite = passwordWebsite;
    }

    public String getPasswordUsername() { return passwordUsername; }

    @Override
    public String toString() {
        return this.passwordName + " - " + this.passwordUsername;
    }
}
