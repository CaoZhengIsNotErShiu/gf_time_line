package per.sc.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Administrator
 * @date 2019/7/17
 */
@Data
@ToString
@Entity
@Table(name = "user_info")
public class UserVO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    // getter and setter...
}
