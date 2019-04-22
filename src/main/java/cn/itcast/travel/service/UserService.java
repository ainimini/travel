package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;


public interface UserService {
    /**
     * @ClassName dell
     * @Description 注册用户
     * @Author X
     * @Data 2019/4/4
     * @Version 1.0
     **/
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
