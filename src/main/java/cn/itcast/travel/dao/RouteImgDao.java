package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;


/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/11
 * @Version 1.0
 **/

public interface RouteImgDao {
    //根据rid查询线路的图片集合
    List<RouteImg> findByRid(int rid);
}