package covid.app.data.model;

public class User {


    private String userId;
    private String password;
    private String email;
    private String username;
    private String userType;

    public User() {
    }

    public User(String userId, String password, String email, String username,String userType) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.username = username;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
