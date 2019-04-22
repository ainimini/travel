package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;
/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/11
 * @Version 1.0
 **/


public interface SellerDao {
    Seller findById(int sid);
}
