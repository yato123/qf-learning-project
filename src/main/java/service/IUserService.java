package service;

import entity.User;

public interface IUserService {
    /**
     * 用户登陆验证
     * @return
     */
    boolean userLogin(User user);
    boolean checkUser(String username,String password);
    boolean checkUserName(String username);
    boolean register(User user);
}
