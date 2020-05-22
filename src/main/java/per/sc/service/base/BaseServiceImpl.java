package per.sc.service.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zhuxiaomeng
 * @date 2017/12/13.
 * @email 154040976@qq.com
 */
@Slf4j
public abstract class BaseServiceImpl<T, E extends Serializable> implements BaseService<T, E> {

    /**
     * general field(通用字段)
     */
    private static final String CREATE_BY = "createBy";

    private static final String CREATE_DATE = "createDate";

    private static final String UPDATE_BY = "updateBy";

    private static final String UPDATE_DATE = "updateDate";

    //系统默认 id 如果主键为其他字段 则需要自己手动 生成 写入 id
    private static final String ID = "id";

    private static final String STR = "java.lang.String";


    /**
     * general field(通用字段)
     */
    private static final String CREATED_BY = "createdId";

    private static final String CREATED_DATE = "createdDate";

    private static final String UPDATED_BY = "updatedId";

    private static final String UPDATED_DATE = "updatedDate";

    private static final String DELETE_BY = "id";

    private static final String DELETE_ISDEL = "isdel";


    public abstract BaseMapper<T, E> getMappser();


    @Override
    public List<T> select(T t) {
        return getMappser().select(t);
    }

    @Override
    public List<T> selectAll() {
        return getMappser().selectAll();
    }

    @Override
    public List<T> selectByIds(String ids) {
        return getMappser().selectByIds(ids);
    }

    @Override
    public int selectCount(T t) {
        return getMappser().selectCount(t);
    }


    @Override
    public int deleteByPrimaryKey(E id) {
        return getMappser().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        try {
            record = addValue(record, true);
        }catch (Exception e){

        }
        return getMappser().insert(record);
    }

    /**
     * 通用注入创建 更新信息 可通过super调用
     *
     * @param record
     * @param flag
     * @return
     */
    public T addValue(T record, boolean flag) {
        //统一处理公共字段
        Class<?> clazz = record.getClass();
        String operator, operateDate;
        try {
            if (flag) {
                //添加 id uuid支持
                Field idField = clazz.getDeclaredField(ID);
                idField.setAccessible(true);
                Object o = idField.get(record);
                Class<?> type = idField.getType();
                String name = type.getName();
                if ((o == null) && STR.equals(name)) {
                    //已经有值的情况下 不覆盖
                    idField.set(record, UUID.randomUUID().toString().replace("-", "").toLowerCase());
                }
                operator = CREATE_BY;
                operateDate = CREATE_DATE;
            } else {
                operator = UPDATE_BY;
                operateDate = UPDATE_DATE;
            }
            Field field = clazz.getDeclaredField(operator);
            field.setAccessible(true);
            Field fieldDate = clazz.getDeclaredField(operateDate);
            fieldDate.setAccessible(true);
            fieldDate.set(record, new Date());

        } catch (NoSuchFieldException e) {
            //无此字段
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return record;
    }


    /**
     * 通用注入创建 更新信息 可通过super调用
     *
     * @param record
     * @param flag
     * @return
     */
    public T addIdValue(T record, boolean flag , boolean delFalg) {
        //统一处理公共字段
        Class<?> clazz = record.getClass();
        String operator, operateDate;
        try {
            if (flag) {
                operator = CREATED_BY;
                operateDate = CREATED_DATE;
            }else {
                if (delFalg){
                    Field field = clazz.getDeclaredField(DELETE_ISDEL);
                    field.setAccessible(true);
                    field.set(record, 1);
                }
                operator = UPDATED_BY;
                operateDate = UPDATED_DATE;
            }
            Field field = clazz.getDeclaredField(operator);
            field.setAccessible(true);
            Field fieldDate = clazz.getDeclaredField(operateDate);
            fieldDate.setAccessible(true);
            fieldDate.set(record, new Date());

        } catch (NoSuchFieldException e) {
            //无此字段
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return record;
    }


    @Override
    public int insertSelective(T record) {
        try {
            record = addValue(record, true);
        }catch (Exception e){
        }
        return getMappser().insertSelective(record);
    }

    @Override
    public int updateIsDel(T t) {
        try {
            t = addIdValue(t, false,true);
        }catch (Exception e){
        }
        return getMappser().updateByPrimaryKeySelective(t);
    }

    @Override
    public int insertId(T record) {
        try {
            record = addIdValue(record, true,false);
        }catch (Exception e){
        }
        return getMappser().insertSelective(record);
    }

    @Override
    public int updateByIdT(T record) {
        try {
            record = addIdValue(record, false,false);
        }catch (Exception e){

        }
        return getMappser().updateByPrimaryKeySelective(record);
    }



    @Override
    public int updateByPrimaryKeySelective(T record) {
        try {
            record = addValue(record, false);
        }catch (Exception e){

        }
        return getMappser().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        try {
            record = addValue(record, false);
        }catch (Exception e){

        }
        return getMappser().updateByPrimaryKey(record);
    }

    @Override
    public List<T> selectListByPage(T record) {
        return getMappser().selectListByPage(record);
    }

    @Override
    public int deleteByPrimaryKey(Object o) {
        return getMappser().deleteByPrimaryKey(o);
    }

    @Override
    public int delete(T t) {
        return getMappser().delete(t);
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return getMappser().existsWithPrimaryKey(o);
    }

    @Override
    public T selectByPrimaryKey(Object o) {
        return getMappser().selectByPrimaryKey(o);
    }

    @Override
    public T selectOne(T t) {
        return getMappser().selectOne(t);
    }

    @Override
    public int deleteByIds(String s) {
        return getMappser().deleteByIds(s);
    }

    @Override
    public int insertList(List<T> list) {
        return getMappser().insertList(list);
    }

    @Override
    public int insertUseGeneratedKeys(T t) {
        return getMappser().insertUseGeneratedKeys(t);
    }


    @Override
    public int deleteByExample(Object o) {
        return getMappser().deleteByExample(o);
    }


    @Override
    public List<T> selectByExample(Object o) {
        return getMappser().selectByExample(o);
    }


    @Override
    public int selectCountByExample(Object o) {
        return getMappser().selectCountByExample(o);
    }


    @Override
    public T selectOneByExample(Object o) {
        return getMappser().selectOneByExample(o);
    }


    @Override
    public int updateByExample(T t, Object o) {
        return getMappser().updateByExample(t,o);
    }


    @Override
    public int updateByExampleSelective(T t, Object o) {
        return getMappser().updateByExampleSelective(t,o);
    }


    @Override
    public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return getMappser().selectByExampleAndRowBounds(o,rowBounds);
    }


    @Override
    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        return getMappser().selectByRowBounds(t,rowBounds);
    }


    @Override
    public PageInfo listPage(PluginPage pluginPage) {
        PageHelper
            .startPage(pluginPage.getPageNum(), pluginPage.getPageSize())
            .setOrderBy(pluginPage.getOrderBy());
        List<T> t=null;
        try {
            t =this.select((T)pluginPage.getT());
        } catch (Exception e) {
            log.error("class:BaseServiceImpl ->method:listPage->message:" + e.getMessage());
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(t,pluginPage.getPageSize());
        return pageInfo;
    }

    @Override
    public int updatedIsdelAndUser(T cord) {
        try {
            cord = addValue(cord, false);
        }catch (Exception e){

        }
        return getMappser().updateByPrimaryKey(cord);
    }

    @Override
    public List<T>  getValueByExample(T t, String key, String value) {
        Class<?> aClass = t.getClass();
        Example example = new Example(aClass);
            example.createCriteria()
                    .andEqualTo(key,value);
            return selectByExample(example);
    }

}
