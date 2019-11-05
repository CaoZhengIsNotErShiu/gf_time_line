package per.sc.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Administrator
 * @date 2019/11/4
 */
@Data
@AllArgsConstructor
public class PersonModel {
    private String name;
    private Integer age;
    private String sex;
}
