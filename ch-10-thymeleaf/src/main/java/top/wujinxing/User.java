package top.wujinxing;

/**
 * @author: wujinxing
 * @date: 2019/3/13 09:26
 * @description:
 */
public class User {
    private String userName;
    private String password;
    private int age;

    public User(String userName, String password, int age) {
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
