public class User extends mainData{
    public String username;
    private String password;

    public User() {
    }

    public void setterPassword(String thatWord) {
        this.password = thatWord;
    }

    public String getterPassword() {
        return this.password;
    }
}
