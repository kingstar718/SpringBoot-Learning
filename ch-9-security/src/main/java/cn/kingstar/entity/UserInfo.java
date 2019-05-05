package cn.kingstar.entity;

import javax.persistence.*;

/**
 * @author wujinxing
 * date 2019 2019/4/30 16:34
 * description
 */
@Entity
public class UserInfo {

    public enum Role{
        admin, normal
    }

    @Id @GeneratedValue
    private long uid;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
