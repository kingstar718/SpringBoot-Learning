package cn.kingstar.pagging.domain;



import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


/**
 * @auther: wujinxing
 * @date: 2018/11/13 17:22
 * @description:
 */
@Entity
@Table(name = "input_user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2,max = 8,message = "姓名长度必须大于2且小于20个字")
    @Column(name = "name")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0,message = "年龄不能小于0")
    @Max(value = 300,message = "年龄不能大于300")
    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "出生时间不能为空")
    @Column(name = "birthday")
    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
