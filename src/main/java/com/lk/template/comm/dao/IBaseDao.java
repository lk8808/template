package com.lk.template.comm.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {
	/**
     * 获取单条数据
     *
     * @param id 主键
     * @return T t
     */
	T get(long id);

    /**
     * 扩展单条数据
     *
     * @param entity T
     * @return T t
     */
    T expand(T entity);
    
    /**
     * 查询所有数据
     *
     * @return List<T> list
     */
    List<T> queryAllList();

    /**
     * 查询数据列表
     *
     * @param params 查询条件
     * @return List<T> list
     */
    List<T> queryList(Map<String, Object> params);
    
    /**
     * 分页查询
     * @param params
     * @return
     */
    List<T> queryListWithPage(Map<String, Object> params);

    /**
     * 根据查询条件查询总记录数
     * @param params
     * @return
     */
    Integer count(Map<String, Object> params);
    
    /**
     * 插入数据
     *
     * @param entity T
     * @return int int
     */
    int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity T
     * @return int int
     */
    int update(T entity);

    /**
     * 删除数据
     *
     * @param entity T
     * @return int int
     */
    int delete(T entity);

    /**
     * 删除数据
     *
     * @param id entity id
     * @return int int
     */
    int deleteById(long id);

    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    public int deleteBatch(String[] ids);

}
