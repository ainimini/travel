package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/10
 * @Version 1.0
 **/
public interface CategoryDao {

    /**
     * 查询所有
     *
     * @return
     */
    public List<Category> findAll();

}
