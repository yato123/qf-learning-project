package service.Impl;

import userDao.IUserDao;
import userDao.userDaoImpl.UserDaoImpl;
import entity.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();
    @Override
    public boolean userLogin(User user) {
        if (userDao.login(user.getUsername(), user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkUser(String username) {
        if (!userDao.CheckRegister(username)){
            return true;
        }
        return false;
    }

    @Override
    public boolean register(User user) {

        if (userDao.register(user) >0){
                   return true;
        }

        return false;
    }
}
