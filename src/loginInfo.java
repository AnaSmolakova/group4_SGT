public class loginInfo {

    private String userName;
    private String password;
    private String fullName;

    private String email;

    public void setUsername(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public void setEmail (String email){
        this.email = email;
    }
    public String getUsername() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getFullName(){
        return fullName;
    }
    public String getEmail(){
        return email;
    }
}

