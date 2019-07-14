package service.Impl;

import org.springframework.stereotype.Service;
import userDao.IUserDao;
import userDao.userDaoImpl.UserDaoImpl;
import entity.User;
import service.IUserService;

@Service
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
    public boolean checkUser(String username , String password) {
        if (!userDao.CheckRegister(username) && !"".equals(password) && password != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUserName(String username) {
        System.out.println("2"+username);
        if (userDao.CheckRegister(username)){
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
