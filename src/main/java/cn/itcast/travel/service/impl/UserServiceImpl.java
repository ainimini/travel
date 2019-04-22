package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;


public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * @ClassName dell
     * @Description 注册用户
     * @Author X
     * @Data 2019/4/4
     * @Version 1.0
     **/
    @Override
    public boolean regist(User user) {
        //根据用户查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为空
        if (u != null) {
            //用户名存在
            return false;
        }
        //保存用户信息
        //设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //设置激活状态
        user.setStatus("N");
        userDao.save(user);

        //激活邮箱发送，邮件正文？
        String content = "<a href ='http://localhost:8080/travel/user/active?code=" + user.getCode() + "'>点击激活【黑马旅游网】</a>";

        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {

        //根据激活码完成激活对象
        User user = userDao.findByCode(code);
        if(user!= null){
            //调用dao修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }

    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {

        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

}
