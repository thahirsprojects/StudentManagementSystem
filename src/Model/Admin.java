package Model;

public class Admin {

    private int id;
    static int adminId;
    private String username;
    private String password;

    public Admin(String userName, String password) {
        this.id = ++adminId;
        this.username = userName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                '}';
    }
}
