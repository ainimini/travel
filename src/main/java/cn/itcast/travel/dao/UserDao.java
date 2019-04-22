package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @ClassName dell
 * @Description TOOD
 * @Author X
 * @Data 2019/4/4
 * @Version 1.0
 **/
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    public void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
