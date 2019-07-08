package per.sc.util;

import lombok.Data;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/7/4 下午2:34
 * @Version 1.0
 */
@Data
public class HttpResult {

    private Integer status;
    private String msg;
    private Object data;

}
