package top.wujinxing.ch15jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wujinxing
 * date 2019 2019/5/20 10:00
 * description
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
}
