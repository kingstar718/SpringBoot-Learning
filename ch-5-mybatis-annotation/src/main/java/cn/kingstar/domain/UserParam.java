package cn.kingstar.domain;

/**
 * @author wujinxing
 * date 2019 2019/5/27 15:05
 * description
 */
public class UserParam extends PageParam {
    private String userName;

    private String userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
