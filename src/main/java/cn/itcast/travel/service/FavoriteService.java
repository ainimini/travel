package cn.itcast.travel.service;

import cn.itcast.travel.domain.Route;

import java.util.List;


/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/11
 * @Version 1.0
 **/

public interface FavoriteService {
    boolean isFavorite(String rid, int uid);

    void add(String rid, int uid);

    //人气旅游线路
    List<Route> findHot();
}
