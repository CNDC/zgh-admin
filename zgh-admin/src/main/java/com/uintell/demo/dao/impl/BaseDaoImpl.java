package com.uintell.demo.dao.impl;

import com.uintell.demo.dao.BaseDao;
import com.uintell.demo.utils.ConvertUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2018/1/3 17:00
 */
public class BaseDaoImpl implements BaseDao {
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 根据Id获取对象
     *
     * @param sqlId 脚本编号
     * @param id    主键
     * @return Object对象
     */
    public Object queryForObject(String sqlId, int id) {
        return getSqlSession().selectOne(sqlId, id);
    }

    /**
     * 根据Id获取对象
     *
     * @param sqlId 脚本编号
     * @param id    主键
     * @param cls   返回的对象Class
     * @return cls对应的类
     */
    @SuppressWarnings("unchecked")
    public <T> T queryForObject(String sqlId, int id, Class<T> cls) {
        return (T) getSqlSession().selectOne(sqlId, id);
    }

    /**
     * 根据Id获取对象
     *
     * @param sqlId 脚本编号
     * @param id    主键
     * @param cls   返回的对象Class
     * @return cls对应的类
     */
    @SuppressWarnings("unchecked")
    public <T> T queryForObject(String sqlId, long id, Class<T> cls) {
        return (T) getSqlSession().selectOne(sqlId, id);
    }

    /**
     * 根据条件获取对象
     *
     * @param sqlId  脚本编号
     * @param params 参数
     * @return
     */
    public Object queryForObject(String sqlId, Map<String, Object> params) {
        return getSqlSession().selectOne(sqlId, params);
    }

    /**
     * 根据条件获取对象
     *
     * @param sqlId  脚本编号
     * @param params 参数
     * @param cls    返回的对象Class
     * @return cls对应的类
     */
    @SuppressWarnings("unchecked")
    public <T> T queryForObject(String sqlId, Map<String, Object> params,
                                Class<T> cls) {
        return (T) getSqlSession().selectOne(sqlId, params);
    }

    /**
     * 获取数据总条数
     *
     * @param sqlId  脚本编号
     * @param params 参数
     * @return 条数
     */
    public int getTotalCount(String sqlId, Map<String, String> params) {
        return (Integer) getSqlSession().selectOne(sqlId, params);
    }

    /**
     * 查询列表
     *
     * @param sqlId  脚本编号
     * @param params 参数
     * @param cls    返回的对象Class
     * @return 列表<cls对应的类>
     */
    public <T> List<T> queryForList(String sqlId, Map<String, String> params,
                                    Class<T> cls) {
        return getSqlSession().selectList(sqlId, params);
    }

    /**
     * 查询列表
     *
     * @param sqlId  脚本编号
     * @param params 参数
     * @param cls    返回的对象Class
     * @return 列表<cls对应的类>
     */
    public <T> List<T> queryForListForObject(String sqlId, Map<String, Object> params,
                                             Class<T> cls) {
        return getSqlSession().selectList(sqlId, params);
    }

    /**
     * 查询列表
     *
     * @param sqlId  脚本编号
     * @param params 参数
     * @return 列表
     */
    public List<Map<String, Object>> queryForList(String sqlId,
                                                  Map<String, Object> param) {
        List<Map<String, Object>> list = getSqlSession().selectList(sqlId, param);
        List<Map<String, Object>> beans = ConvertUtil.convertSqlMap2JavaMap(list);
        return beans;
    }

    /**
     * 修改数据
     *
     * @param sqlId  脚本编号
     * @param object 对象
     */
    public int update(String sqlId, Object object) {
        return getSqlSession().update(sqlId, object);
    }

    /**
     * 插入数据
     *
     * @param sqlId  脚本编号
     * @param object 待插入的对象
     * @return 插入条数
     */
    public int insert(String sqlId, Object object) {
        return (Integer) getSqlSession().insert(sqlId, object);
    }

    /**
     * 删除数据
     *
     * @param sqlId 脚本编号
     * @param id    主键
     * @return 主键
     */
    public int delete(String sqlId, int id) {
        return getSqlSession().delete(sqlId, id);
    }

    /**
     * 删除数据
     *
     * @param sqlId 脚本编号
     * @param id    主键
     * @return 主键
     */
    public int delete(String sqlId, long id) {
        return getSqlSession().delete(sqlId, id);
    }

    /**
     * 删除数据
     *
     * @param sqlId 脚本编号
     * @param map   待删除的对象
     * @return 主键
     */
    public int delete(String sqlId, Map<String, Object> map) {
        return getSqlSession().delete(sqlId, map);
    }

    /**
     * 查询列表
     *
     * @param sqlId  脚本编号
     * @param params 参数
     * @param cls    返回的对象Class
     * @return 列表<cls对应的类>
     */
    public <T> List<T> queryList(String sqlId, Map<String, Object> params, Class<T> cls) {
        return getSqlSession().selectList(sqlId, params);
    }


    public <T> List<T> queryForList(String sqlId, Object object, Class<T> cls) {
        return getSqlSession().selectList(sqlId, object);
    }
}
