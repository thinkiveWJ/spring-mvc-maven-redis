package beacool.entity;

/**
 * Created by Administrator on 2017/8/16.
 */
public class Login {
    private String userName;
    private String password;
    private String id;
    private String token;

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Login() {
    }
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
