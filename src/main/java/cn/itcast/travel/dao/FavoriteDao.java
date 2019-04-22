package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;

/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/11
 * @Version 1.0
 **/

import java.util.List;


public interface FavoriteDao {
    Favorite findByRidAndUid(int rid, int uid);

    int findCountByRid(int rid);

    void add(int rid, int uid);

    List<Integer> myFavoriteRid(int uid);

    Route favoriteRoute(int rid);
    //查询人气线路
    List<Route> findHot();
}
