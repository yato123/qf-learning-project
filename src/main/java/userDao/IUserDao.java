package userDao;

import entity.User;

import java.util.List;

public interface IUserDao {
    boolean CheckRegister(String username);
    boolean login(String username, String password);
    int register(User user);
    Integer getTotalCount();
    List<User> getList(int index, int pageSize);
}
