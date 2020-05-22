package per.sc.service;

import per.sc.pojo.Menu;
import per.sc.result.ResultData;
import per.sc.service.base.BaseService;
import per.sc.util.HttpResult;


/**
 *
 * @author Administrator
 * @date 2019/10/18
 */
public interface MenuServiceI  extends BaseService<Menu,String> {

    ResultData getMenu();
}
