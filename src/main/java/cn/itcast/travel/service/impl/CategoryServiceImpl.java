package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/10
 * @Version 1.0
 **/
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {

        //从redis中查询
        //获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //可以使用sortedset排序查询
       //Set<String> categorys = jedis.zrange("category", 0, -1);
        //查询sortedset中的分数（cid）和值（cname）
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;
        //判断查询的集合是否为空
        if (categorys == null || categorys.size() == 0) {

           // System.out.println("从数据库中查询...");
            //如果为空，需要从数据库中查询，在存入redis
            //从数据库中查询
            cs = categoryDao.findAll();
            //将集合数据存储到redis中category的key中
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
           // System.out.println("从redis中查询...");
            //如果不为空，将set存储到list中
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);
            }
        }
        return cs;
    }
}
