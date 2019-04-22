package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;


/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/11
 * @Version 1.0
 **/

public interface RouteDao {
    int findTotalCount(int cid, String rname);


    List<Route> findByPage(int cid, int start, int pageSize, String rname);

    Route findOne(int rid);
}
